package ua.edu.ucu.apps.demo.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.demo.delivery.PostDeliveryStrategy;
import ua.edu.ucu.apps.demo.flowers.Flower;
import ua.edu.ucu.apps.demo.flowers.FlowerColor;
import ua.edu.ucu.apps.demo.flowers.FlowerType;
import ua.edu.ucu.apps.demo.item.Item;
import ua.edu.ucu.apps.demo.payment.CreditCardPaymentStrategy;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    Order order;
    // before each
    @BeforeEach
    void setUp() {
        // calculateTotalPrice
        ArrayList<Item> flowers = new ArrayList<>();
        flowers.add(new Item(new Flower(FlowerType.ROSE, FlowerColor.RED, 1, 1), 1));
        flowers.add(new Item(new Flower(FlowerType.CHAMOMILE, FlowerColor.RED, 1, 1), 1));
        order = new Order(flowers);
    }

    @Test
    void calculateTotalPrice() {
        assertEquals(order.calculateTotalPrice(), 2);
    }

    @Test
    void getTotalQuantity() {
        assertEquals(order.getTotalQuantity(), 2);
    }

    @Test
    void addItem() {
        order.addItem(new Item(new Flower(FlowerType.CHAMOMILE, FlowerColor.RED, 1, 1), 1));
        assertEquals(order.getTotalQuantity(), 3);
    }

    @Test
    void removeItem() {
        order.removeItem(new Item(new Flower(FlowerType.CHAMOMILE, FlowerColor.RED, 1, 1), 1));
        assertEquals(2, order.getTotalQuantity());
    }

    @Test
    void update() {
        order.update(new Item(new Flower(FlowerType.CHAMOMILE, FlowerColor.RED, 1, 1), 1), 2);
        assertEquals(2, order.getTotalQuantity());
    }

    @Test
    void clear() {
        order.clear();
        assertEquals(0, order.getTotalQuantity());
    }

    @Test
    void createRandomFlowersOrder() {
        Order order = Order.createRandomFlowersOrder(2);
        assertEquals(order.getTotalQuantity(), 1);
    }

   @Test
    void setDeliveryStrategy() {
        order.setDeliveryStrategy(new PostDeliveryStrategy());
        assertEquals(order.getDeliveryStrategy().toString(), "PostDeliveryStrategy()");
    }

    @Test
    void getItems() {
        assertEquals(order.getItems().size(), 2);
    }

    @Test
    void getDeliveryStrategy() {
        assertEquals(order.getDeliveryStrategy().toString(), "Delivery(deliveryStrategy=PostDeliveryStrategy())");
    }
}