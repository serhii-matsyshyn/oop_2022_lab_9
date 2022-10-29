package ua.edu.ucu.apps.demo.delivery;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.edu.ucu.apps.demo.order.Order;

@Getter @Setter @ToString
public class Delivery implements DeliveryStrategy {
    private DeliveryStrategy deliveryStrategy;

    public Delivery() {
        this.deliveryStrategy = new PostDeliveryStrategy();
    }

    public Delivery(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public String deliver(Order order) {
        return deliveryStrategy.deliver(order);
    }
}