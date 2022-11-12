package ua.edu.ucu.apps.demo.decorators;

import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.demo.flowers.Flower;
import ua.edu.ucu.apps.demo.flowers.FlowerColor;
import ua.edu.ucu.apps.demo.flowers.FlowerType;
import ua.edu.ucu.apps.demo.item.Item;

import static org.junit.jupiter.api.Assertions.*;

class RibbonDecoratorTest {

    @Test
    void price() {
        Item item = new Item(new Flower(FlowerType.ROSE, FlowerColor.RED, 1, 1), 1);
        RibbonDecorator ribbonDecorator = new RibbonDecorator(item);
        assertEquals(ribbonDecorator.price(), 41);
    }

    @Test
    void getDescription() {
        Item item = new Item(new Flower(FlowerType.ROSE, FlowerColor.RED, 1, 1), 1);
        RibbonDecorator ribbonDecorator = new RibbonDecorator(item);
        assertEquals(ribbonDecorator.getDescription(), "Flower in ribbon");
    }
}