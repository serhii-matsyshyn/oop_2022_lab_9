package ua.edu.ucu.apps.demo.delivery;


import lombok.ToString;
import ua.edu.ucu.apps.demo.order.Order;

public interface DeliveryStrategy {
    String deliver(Order order);
}
