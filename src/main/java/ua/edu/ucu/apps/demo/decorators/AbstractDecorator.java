package ua.edu.ucu.apps.demo.decorators;

import lombok.Getter;
import lombok.Setter;
import ua.edu.ucu.apps.demo.item.Item;

public abstract class AbstractDecorator extends Item {
    @Getter @Setter
    private Item item;

    public AbstractDecorator(Item item) {
        super(item.getItem(), item.getQuantity());
        this.item = item;
    }

    @Override
    public double price() {
        return item.price();
    }

    @Override
    public String getDescription() {
        return item.getDescription();
    }
}