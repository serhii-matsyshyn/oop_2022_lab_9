package ua.edu.ucu.apps.demo.decorators;

import ua.edu.ucu.apps.demo.item.Item;

public class RibbonDecorator extends AbstractDecorator {
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return super.price() + 40;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " in ribbon";
    }
}