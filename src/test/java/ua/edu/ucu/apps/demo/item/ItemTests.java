package ua.edu.ucu.apps.demo.item;

import org.junit.jupiter.api.Test;
import ua.edu.ucu.apps.demo.flowers.Flower;
import ua.edu.ucu.apps.demo.flowers.FlowerColor;
import ua.edu.ucu.apps.demo.flowers.FlowerType;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryTests {

    @Test
    void generalTest() {
        ArrayList<Item> flowers = new ArrayList<>();
        flowers.add(new Item(new Flower(FlowerType.ROSE, FlowerColor.RED, 1, 1), 1));
        assertEquals(flowers.get(0).price(), 1);
        assertEquals(flowers.get(0).toString(), "Item(description=Flower, item=Flower(flowerType=ROSE, color=#FF0000, sepalLength=1.0, price=1.0), quantity=1)");
        flowers.get(0).setQuantity(2);
        assertEquals(flowers.get(0).getQuantity(), 2);
        assertThrows(IllegalArgumentException.class, () -> flowers.get(0).setQuantity(-1));

        // description
        assertEquals(flowers.get(0).getDescription(), "Flower");
        }

}
