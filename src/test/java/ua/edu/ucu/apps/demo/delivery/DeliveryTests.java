package ua.edu.ucu.apps.demo.delivery;

import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.demo.flowers.Flower;
import ua.edu.ucu.apps.demo.flowers.FlowerColor;
import ua.edu.ucu.apps.demo.flowers.FlowerType;
import ua.edu.ucu.apps.demo.item.Item;
import ua.edu.ucu.apps.demo.order.Order;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTests {

    @Test
    void generalTest() {
        ArrayList<Item> flowers = new ArrayList<>();
        flowers.add(new Item(new Flower(FlowerType.ROSE, FlowerColor.RED, 1, 1), 1));
        Order order = new Order(flowers);

        DeliveryStrategy deliveryStrategy = new PostDeliveryStrategy();
        Delivery delivery = new Delivery(deliveryStrategy);
        assertEquals(delivery.deliver(order), "Delivering order " + order.getOrderId() + " with Post");
        assertEquals(delivery.getDeliveryStrategy(), deliveryStrategy);
        assertEquals(delivery.toString(), "Delivery(deliveryStrategy=PostDeliveryStrategy())");
        // dhl
        deliveryStrategy = new DHLDeliveryStrategy();
        delivery = new Delivery(deliveryStrategy);
        assertEquals(delivery.deliver(order), "Delivering order " + order.getOrderId() + " with DHL");
        assertEquals(delivery.getDeliveryStrategy(), deliveryStrategy);
        assertEquals(delivery.toString(), "Delivery(deliveryStrategy=DHLDeliveryStrategy())");

        // delivery
        delivery = new Delivery();
        assertEquals(delivery.deliver(order), "Delivering order " + order.getOrderId() + " with Post");
        assertEquals(delivery.toString(), "Delivery(deliveryStrategy=PostDeliveryStrategy())");

    }

}
