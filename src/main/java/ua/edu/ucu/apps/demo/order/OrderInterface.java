package ua.edu.ucu.apps.demo.order;

import ua.edu.ucu.apps.demo.delivery.DeliveryStrategy;
import ua.edu.ucu.apps.demo.item.Item;
import ua.edu.ucu.apps.demo.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.UUID;

public interface OrderInterface {
    UUID orderId = null;
    ArrayList<Item> items = null;
    PaymentStrategy payment = null;
    DeliveryStrategy deliveryStrategy = null;

    ArrayList<Item> getItems();
    double calculateTotalPrice();
    int getTotalQuantity();

    void addItem(Item item);
    void removeItem(Item item);
    void update(Item item, int quantity);
    void clear();

    void setPaymentStrategy(PaymentStrategy payment);
    void setDeliveryStrategy(DeliveryStrategy deliveryStrategy);

    void processOrder();

    static Order createRandomFlowersOrder(int flowersCount) {
        return null;
    }
}
