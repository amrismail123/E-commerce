package com.example.mooshproject.controller;

import com.example.mooshproject.dtos.AddItemToCartRequest;
import com.example.mooshproject.dtos.CartDto;
import com.example.mooshproject.dtos.CartItemDto;
import com.example.mooshproject.dtos.UpdateCartItemRequest;
import com.example.mooshproject.exceptions.CartNotFoundException;
import com.example.mooshproject.exceptions.ProductNotFoundException;
import com.example.mooshproject.service.CartService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/carts")
public class CartController {

    private final CartService cartService;

    @PostMapping
    public ResponseEntity<CartDto> createCart(
            UriComponentsBuilder uriBuilder
    ){
        var cartDto = cartService.createCart();
        var uri = uriBuilder.path("/carts/{id}").buildAndExpand(cartDto.getId()).toUri();
        return ResponseEntity.created(uri).body(cartDto);
    }

    @Transactional
    @PostMapping("/{cartId}/items")
    public ResponseEntity<CartItemDto>addToCart(@PathVariable UUID cartId,
                                                @RequestBody AddItemToCartRequest request){
        var cartItemDto = cartService.addToCart(cartId, request.getProductId());
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemDto);
    }

    @Transactional
    @GetMapping("/{cartId}")
    public CartDto getCart(@PathVariable UUID cartId){
        return cartService.getCart(cartId);
    }

    @Transactional
    @PutMapping("/{cartId}/items/{productId}")
    public CartItemDto updateItem(
            @PathVariable UUID cartId,
            @PathVariable Long productId
           ,@Valid @RequestBody UpdateCartItemRequest request){

       return cartService.updateCartItem(cartId, productId, request.getQuantity());
    }

    @DeleteMapping("/{cartId}/items/{productId}")
    public ResponseEntity<?> deleteItem(@PathVariable UUID cartId, @PathVariable Long productId){
        cartService.removeItem(cartId, productId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{cartId}/items")
    public ResponseEntity<?> clearCart(@PathVariable UUID cartId){
        cartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(CartNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCartNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "Cart Not Found")
        );
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                Map.of("error", "Product Not Found in the cart")
        );
    }
}
