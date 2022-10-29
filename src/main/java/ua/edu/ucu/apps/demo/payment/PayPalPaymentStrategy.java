package ua.edu.ucu.apps.demo.payment;

import lombok.ToString;

@ToString
public class PayPalPaymentStrategy implements Payment {
    @Override
    public String pay(double price) {
        return "Paying by PayPal";
    }
}
