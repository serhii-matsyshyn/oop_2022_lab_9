package ua.edu.ucu.apps.demo.decorators;

import ua.edu.ucu.apps.demo.item.Item;

public class BasketDecorator extends AbstractDecorator {
    public BasketDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return super.price() + 4;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " in basket";
    }
}