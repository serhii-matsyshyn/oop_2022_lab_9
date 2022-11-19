package ua.edu.ucu.apps.demo.order;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.edu.ucu.apps.demo.delivery.Delivery;
import ua.edu.ucu.apps.demo.delivery.DeliveryStrategy;
import ua.edu.ucu.apps.demo.delivery.PostDeliveryStrategy;
import ua.edu.ucu.apps.demo.flowers.*;
import ua.edu.ucu.apps.demo.item.Item;
import ua.edu.ucu.apps.demo.payment.PayPalPaymentStrategy;
import ua.edu.ucu.apps.demo.payment.PaymentStrategy;
import ua.edu.ucu.apps.demo.users.StoreUser;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.UUID;

@Getter @Setter @ToString
public class Order implements OrderInterface{
    UUID orderId;
    ArrayList<Item> items;

    PaymentStrategy payment;
    DeliveryStrategy deliveryStrategy;

    @Transient
    OrderNotifier notifier;


    public Order() {
        this.orderId = UUID.randomUUID();
        this.items = new ArrayList<>();

        this.payment = new PaymentStrategy(new PayPalPaymentStrategy());
        this.deliveryStrategy = new Delivery(new PostDeliveryStrategy());
        this.notifier = new OrderNotifier();
    }

    public Order(ArrayList<Item> items) {
        this.orderId = UUID.randomUUID();
        this.items = items;

        this.payment = new PaymentStrategy(new PayPalPaymentStrategy());
        this.deliveryStrategy = new Delivery(new PostDeliveryStrategy());
        this.notifier = new OrderNotifier();
    }

    // factory method
    public static Order createOrderFlowers(ArrayList<Flower> items) {
        ArrayList<Item> items1 = new ArrayList<>();
        for (Flower item : items) {
            items1.add(new Item(item, 1));
        }
        return new Order(items1);
    }

    public double calculateTotalPrice(){
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public int getTotalQuantity(){
        int totalQuantity = 0;
        for (Item item : items) {
            totalQuantity += item.getQuantity();
        }
        return totalQuantity;
    }

    public void addItem(Item item){
        items.add(item);
    }
    public void removeItem(Item item){
        items.remove(item);
    }
    public void update(Item item, int quantity){
        item.setQuantity(quantity);
    }
    public void clear(){
        items.clear();
    }

    public static Order createRandomFlowersOrder(int flowersCount) {
        Order order = new Order();
        // Just for demo
        for (int i = 0; i < flowersCount; i+=3) {
            FlowerBucket bucket = FlowerBucket.createRandomFlowersBucket(12);
            order.addItem(new Item(bucket, 1));
        }
        return order;
    }

    public void setPaymentStrategy(PaymentStrategy payment){
        this.payment = payment;
    }
    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy){
        this.deliveryStrategy = deliveryStrategy;
    }

    public void processOrder(){
        System.out.println("Processing order...");
        System.out.println("Order id: " + orderId);
        System.out.println("Items: " + items);
        System.out.println("Total price: " + calculateTotalPrice());
        System.out.println("Total quantity: " + getTotalQuantity());
        System.out.println("Payment: " + payment.pay(calculateTotalPrice()));
        notifier.notifyUsers("Order was payed");
        System.out.println("Delivery: " + deliveryStrategy.deliver(this));
        System.out.println("Order processed");
        notifier.notifyUsers("Order processed");
    }
}
