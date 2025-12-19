package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.CartItem;
import com.example.demo.model.Product;
import com.example.demo.service.impl.CartItemServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    private final CartItemServiceImpl service;

    public CartItemController(CartItemServiceImpl service) {
        this.service = service;
    }

    // ✅ Add item to cart
    @PostMapping
    public CartItem addItem(
            @RequestParam Long cartId,
            @RequestParam Long productId,
            @RequestParam Integer quantity) {

        CartItem item = new CartItem();

        Cart cart = new Cart();
        cart.setId(cartId);

        Product product = new Product();
        product.setId(productId);

        item.setCart(cart);
        item.setProduct(product);
        item.setQuantity(quantity);

        return service.addItemToCart(item);
    }

    // ✅ Get items for cart
    @GetMapping("/cart/{cartId}")
    public List<CartItem> getItems(@PathVariable Long cartId) {
        return service.getItemsForCart(cartId);
    }

    // ✅ Update quantity
    @PutMapping("/{id}")
    public CartItem updateQuantity(
            @PathVariable Long id,
            @RequestParam Integer quantity) {
        return service.updateQuantity(id, quantity);
    }

    // ✅ Remove item
    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id) {
        service.removeItem(id);
    }
}
