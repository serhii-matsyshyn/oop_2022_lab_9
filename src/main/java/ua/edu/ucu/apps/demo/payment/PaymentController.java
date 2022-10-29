package ua.edu.ucu.apps.demo.payment;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.edu.ucu.apps.demo.order.Order;
import ua.edu.ucu.apps.demo.order.OrderController;

import java.util.*;

@RestController
public class PaymentController extends PaymentStrategy {
    public PaymentController() {
        super();
    }

    @RequestMapping("/api/payment/pay/{orderId}")
    public String pay(@PathVariable("orderId") UUID orderId) {
        Order order = OrderController.getOrderById(orderId);
        double price = order.calculateTotalPrice();
        return order.getPayment().pay(price);
    }

    @SneakyThrows
    public HashMap<String, Payment> allPaymentTypesHashMap() {
        // use reflections to get all classes that implement PaymentStrategy interface
        // and return their names

        Reflections reflections = new Reflections("ua.edu.ucu.apps.demo.payment");
        Set<Class<? extends Payment>> allClasses =
                reflections.getSubTypesOf(Payment.class);

        HashMap<String, Payment> paymentStrategies = new HashMap<>();
        for (Class<? extends Payment> cls : allClasses) {
            paymentStrategies.put(cls.getSimpleName(), cls.getDeclaredConstructor().newInstance());
        }

        return paymentStrategies;
    }

    @GetMapping
    @RequestMapping("/api/payment/all-payment-types")
    public String allPaymentTypes() {
        return allPaymentTypesHashMap().keySet().toString();
    }
}
