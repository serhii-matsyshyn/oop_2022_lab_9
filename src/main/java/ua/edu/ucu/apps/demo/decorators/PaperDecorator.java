package ua.edu.ucu.apps.demo.decorators;

import ua.edu.ucu.apps.demo.item.Item;

public class PaperDecorator extends AbstractDecorator {
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double price() {
        return super.price() + 13;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " in paper";
    }
}