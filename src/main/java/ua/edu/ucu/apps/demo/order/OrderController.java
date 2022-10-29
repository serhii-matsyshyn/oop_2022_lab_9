package ua.edu.ucu.apps.demo.order;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.UUID;

@RestController
public class OrderController extends Order {
    @Getter
    static public HashMap<UUID, Order> allOrders = new HashMap<>();

    public static Order getOrderById(UUID id) {
        return allOrders.get(id);
    }

    @GetMapping
    @RequestMapping("/api/get-all-orders")
    public String getAllOrders() {
        return allOrders.toString();
    }

    @GetMapping
    @RequestMapping("/api/get-order/{orderId}")
    public String getOrderByIdExternal(@PathVariable("orderId") UUID orderId) {
        return getOrderById(orderId).toString();
    }

    @GetMapping
    @RequestMapping("/api/order/create/randomFlowersOrder/{flowersCount}")
    public String createRandomFlowersOrderExternal(@PathVariable("flowersCount") int flowersCount) {
        Order order = Order.createRandomFlowersOrder(flowersCount);
        allOrders.put(order.getOrderId(), order);
        return order.toString();
    }
}