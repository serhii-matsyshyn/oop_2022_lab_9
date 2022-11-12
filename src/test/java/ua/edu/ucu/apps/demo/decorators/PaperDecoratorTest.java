package ua.edu.ucu.apps.demo.decorators;

import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.demo.flowers.Flower;
import ua.edu.ucu.apps.demo.flowers.FlowerColor;
import ua.edu.ucu.apps.demo.flowers.FlowerType;
import ua.edu.ucu.apps.demo.item.Item;

import static org.junit.jupiter.api.Assertions.*;

class PaperDecoratorTest {

    @Test
    void price() {
        Item item = new Item(new Flower(FlowerType.ROSE, FlowerColor.RED, 1, 1), 1);
        PaperDecorator paperDecorator = new PaperDecorator(item);
        assertEquals(paperDecorator.price(), 14);
    }

    @Test
    void getDescription() {
        Item item = new Item(new Flower(FlowerType.ROSE, FlowerColor.RED, 1, 1), 1);
        PaperDecorator paperDecorator = new PaperDecorator(item);
        assertEquals(paperDecorator.getDescription(), "Flower in paper");
    }
}