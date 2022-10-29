package ua.edu.ucu.apps.demo.item;

import java.lang.reflect.InvocationTargetException;

public interface ItemInterface {
    public Object item = null;
    int quantity = 0;
    double price() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

    void setQuantity(int quantity);
}
