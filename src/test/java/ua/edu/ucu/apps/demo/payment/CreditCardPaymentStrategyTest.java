package ua.edu.ucu.apps.demo.payment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardPaymentStrategyTest {

    @Test
    void pay() {
        CreditCardPaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy();
        assertEquals("Paying by card", creditCardPaymentStrategy.pay(1));
    }

    @Test
    void testToString() {
        CreditCardPaymentStrategy creditCardPaymentStrategy = new CreditCardPaymentStrategy();
        assertEquals("CreditCardPaymentStrategy()", creditCardPaymentStrategy.toString());
    }
}