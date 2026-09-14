package com.example.mooshproject.service;

import com.example.mooshproject.dtos.OrderDto;
import com.example.mooshproject.exceptions.OrderNotFoundException;
import com.example.mooshproject.mappers.OrderMapper;
import com.example.mooshproject.repository.OrdersRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class OrderService {
    private final OrdersRepository orderRepository;
    private final AuthService authService;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAllOrders() {
        var user = authService.getCurrentUser();
        var orders = orderRepository.getOrderByCustomer(user);
        return orders.stream().map(orderMapper::toDto).toList();
    }

    public OrderDto getOrder(Long orderId) {
        var order = orderRepository
                .getOrdersWithItem(orderId)
                .orElseThrow(OrderNotFoundException::new);
        var user = authService.getCurrentUser();
        if(!order.getCustomer().getId().equals(user.getId())) {
            throw new AccessDeniedException("You dont have access to this order");
        }
        return orderMapper.toDto(order);
    }
}
