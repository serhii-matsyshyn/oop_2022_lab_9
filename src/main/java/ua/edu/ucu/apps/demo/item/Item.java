package ua.edu.ucu.apps.demo.item;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.ToString;

@Getter @Setter @ToString
public class Item implements ItemInterface {
    String description;
    private final Object item;
    private int quantity;

    public Item(Object item, int quantity) {
        // check if quantity is positive
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        // check if item is not null
        if (item == null) {
            throw new IllegalArgumentException("Item must not be null");
        }

        // check if item has method getPrice
        try {
            item.getClass().getMethod("getPrice");
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Item must have method getPrice");
        }

        this.item = item;
        this.quantity = quantity;
        this.description = item.getClass().getSimpleName();
    }

    public Item(Object item, int quantity, String description) {
        // check if quantity is positive
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }

        // check if item is not null
        if (item == null) {
            throw new IllegalArgumentException("Item must not be null");
        }

        // check if item has method getPrice
        try {
            item.getClass().getMethod("getPrice");
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Item must have method getPrice");
        }

        this.item = item;
        this.quantity = quantity;
    }

    @SneakyThrows
    public double price() {
        return quantity * (double) item.getClass().getMethod("getPrice").invoke(item);
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity;
    }
}
