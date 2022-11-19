package ua.edu.ucu.apps.demo.order;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.edu.ucu.apps.demo.flowers.Flower;
import ua.edu.ucu.apps.demo.flowers.FlowerController;
import ua.edu.ucu.apps.demo.flowers.FlowerRepository;
import ua.edu.ucu.apps.demo.flowers.FlowerService;
import ua.edu.ucu.apps.demo.item.Item;
import ua.edu.ucu.apps.demo.users.StoreUser;

import java.util.*;

@RestController
public class OrderController extends Order {
    @Autowired
    private FlowerRepository flowerRepository;

    public OrderController(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

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
    @RequestMapping("/api/order/create/randomFlowersPreOrder/{flowersCount}")
    public String createRandomFlowersOrderExternal(@PathVariable("flowersCount") int flowersCount) {
        Order order = Order.createRandomFlowersOrder(flowersCount);
        allOrders.put(order.getOrderId(), order);
        return order.toString();
    }

    // make order with json body
    @PostMapping("/api/order/create")
    public String createOrderExternal(@RequestBody ArrayList<Flower> flowers) {
        // check if items are in stock
        // flowers list
        List<Flower> flowers_available = flowerRepository.findAll();
        if (flowers_available.size() == 0) {
            return "Not enough flowers in stock";
        }
        System.out.println(flowers_available);
        for (Flower flower : flowers) {
            boolean found = false;
            for (Flower flower_available : flowers_available) {
                if (flower_available.getFlowerType().equals(flower.getFlowerType()) &&
                        flower_available.getColor().equals(flower.getColor())) {
                    found = true;
                }
            }
            if (!found) {
                return "Not enough required flowers in stock";
            }
        }

        Order order = Order.createOrderFlowers(flowers);
        allOrders.put(order.getOrderId(), order);
        return order.toString();
    }

    @GetMapping("/api/order/{orderId}/set-order-processed")
    public String setOrderProcessedExternal(@PathVariable("orderId") UUID orderId) {
        Order order = allOrders.get(orderId);
        order.deliveryStrategy.deliver(order);
        order.notifier.notifyUsers("Order " + order.getOrderId() + " is processed");
        return order.toString();
    }

    @PostMapping("/api/order/{orderId}/addUser")
    public String addUserToOrder(@PathVariable("orderId") UUID orderId, @RequestBody StoreUser user) {
        Order order = allOrders.get(orderId);
        order.notifier.addUser(user);
        return order.toString();
    }

    @PostMapping("/api/order/{orderId}/removeUser")
    public String removeUserFromOrder(@PathVariable("orderId") UUID orderId, @RequestBody StoreUser user) {
        Order order = allOrders.get(orderId);
        order.notifier.removeUser(user);
        return order.toString();
    }

}