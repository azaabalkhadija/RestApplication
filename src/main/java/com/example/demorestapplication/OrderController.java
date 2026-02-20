package com.example.demorestapplication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order input) {
        Long id = idGenerator.getAndIncrement();
        Order saved = new Order(id, input.getCustomer(), input.getAmount());

        orders.add(saved);

        System.out.println("[REST] Nouvelle commande reçue (sans Kafka) : id="
                + saved.getId() + ", client=" + saved.getCustomer()
                + ", montant=" + saved.getAmount());

        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Order>> listOrders() {
        return ResponseEntity.ok(orders);
    }
}
