package com.example.mooshproject.payments;

import com.example.mooshproject.entity.Order;
import com.example.mooshproject.exceptions.CartEmptyException;
import com.example.mooshproject.exceptions.CartNotFoundException;
import com.example.mooshproject.repository.CartRepository;
import com.example.mooshproject.repository.OrdersRepository;
import com.example.mooshproject.service.AuthService;
import com.example.mooshproject.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CheckoutService {
    private final CartRepository cartRepository;
    private final OrdersRepository orderRepository;
    private final CartService cartService;
    private final AuthService authService;
    private final PaymentGateway paymentGateway;

    @Transactional
    public CheckoutResponse checkout(CheckoutRequest request){
        var cart = cartRepository.getCartWithItems(request.getCartId()).orElse(null);
        if (cart == null) {
            throw new CartNotFoundException();
        }
        if (cart.isEmpty()) {
            throw new CartEmptyException();
        }
        var order = Order.fromCart(cart, authService.getCurrentUser());
        orderRepository.save(order);

        //Create a checkout session
        try{
            var session = paymentGateway.createCheckoutSession(order);
            cartService.clearCart(cart.getId());
            return new CheckoutResponse(order.getId(), session.getCheckouturl());
        }
        catch (PaymentException ex) {
            System.out.println(ex.getMessage());
            orderRepository.delete(order);
            throw ex;
        }
    }
    public void handleWebhookEvent(WebhookRequest request){
        paymentGateway
                .parseWebhookRequest(request)
                .ifPresent(paymentResult ->{
                    var order = orderRepository.findById(paymentResult.getOrderId()).orElseThrow();
                    order.setStatus(paymentResult.getPaymentStatus());
                    orderRepository.save(order);
        });
    }
}

