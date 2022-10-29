package ua.edu.ucu.apps.demo.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayPalPaymentStrategyTest {

    @Test
    void pay() {
        PayPalPaymentStrategy payPalPaymentStrategy = new PayPalPaymentStrategy();
        assertEquals("Paying by PayPal", payPalPaymentStrategy.pay(1));
    }

    @Test
    void testToString() {
        PayPalPaymentStrategy payPalPaymentStrategy = new PayPalPaymentStrategy();
        assertEquals("PayPalPaymentStrategy()", payPalPaymentStrategy.toString());
    }
}