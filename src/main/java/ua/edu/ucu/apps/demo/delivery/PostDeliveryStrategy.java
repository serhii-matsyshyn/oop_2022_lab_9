package ua.edu.ucu.apps.demo.delivery;

import lombok.ToString;
import ua.edu.ucu.apps.demo.order.Order;

@ToString
public class PostDeliveryStrategy implements DeliveryStrategy {
    @Override
    public String deliver(Order order) {
        return "Delivering order " + order.getOrderId() + " with Post";
    }
}
