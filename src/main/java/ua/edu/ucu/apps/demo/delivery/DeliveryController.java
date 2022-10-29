package ua.edu.ucu.apps.demo.delivery;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ucu.apps.demo.DemoApplication;
import ua.edu.ucu.apps.demo.order.Order;
import ua.edu.ucu.apps.demo.order.OrderController;
import ua.edu.ucu.apps.demo.payment.PaymentStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.UUID;

@RestController
public class DeliveryController extends Delivery {
    @GetMapping
    @RequestMapping("/api/delivery/deliver/{orderId}")
    public String deliver(@PathVariable("orderId") UUID orderId) {
        Order order = OrderController.getOrderById(orderId);
        return order.getDeliveryStrategy().deliver(order);
    }

    @SneakyThrows
    @Cacheable
    public HashMap<String, DeliveryStrategy> allDeliveryTypesHashMap() {
        // use reflections to get all classes that implement DeliveryStrategy interface
        // and return their names

        Reflections reflections = new Reflections("ua.edu.ucu.apps.demo.delivery");
        Set<Class<? extends DeliveryStrategy>> allClasses =
                reflections.getSubTypesOf(DeliveryStrategy.class);

        HashMap<String, DeliveryStrategy> deliveryStrategies = new HashMap<>();
        for (Class<? extends DeliveryStrategy> cls : allClasses) {
            if (!cls.getSimpleName().equals("Delivery") && !cls.getSimpleName().equals("DeliveryController")) {
                System.out.println(cls.getSimpleName());
                deliveryStrategies.put(cls.getSimpleName(), cls.getDeclaredConstructor().newInstance());
            }
        }

        return deliveryStrategies;
    }

    @GetMapping
    @RequestMapping("/api/delivery/all-delivery-types")
    public String allDeliveryTypesExternal() {
        return allDeliveryTypesHashMap().keySet().toString();
    }
}
