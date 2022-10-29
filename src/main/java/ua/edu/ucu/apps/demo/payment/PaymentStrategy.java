package ua.edu.ucu.apps.demo.payment;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
public class PaymentStrategy {
    private Payment paymentStrategy;

    public PaymentStrategy() {
        this.paymentStrategy = new CreditCardPaymentStrategy();
    }

    public PaymentStrategy(Payment paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public String pay(double price) {
        return paymentStrategy.pay(price);
    }
}
