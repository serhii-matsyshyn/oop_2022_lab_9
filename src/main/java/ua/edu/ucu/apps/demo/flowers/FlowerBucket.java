package ua.edu.ucu.apps.demo.flowers;

import lombok.ToString;

import java.util.List;

@ToString
public class FlowerBucket {
    private final List<FlowerPack> flowerPacks;

    public FlowerBucket() {
        flowerPacks = new java.util.ArrayList<>();
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    public static FlowerBucket createRandomFlowersBucket(int flowersCount) {
        FlowerBucket flowerBucket = new FlowerBucket();

        for (int i = 0; i < flowersCount; i+=3) {
            // random flower
            FlowerPack flowerPack = new FlowerPack(new Flower(FlowerType.values()[(int) (Math.random() * 3)],
                    FlowerColor.values()[(int) (Math.random() * 3)], (int) (Math.random() * 100)), 3);
            flowerBucket.addFlowers(flowerPack);
        }
        return flowerBucket;
    }

    public void addFlowers(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public boolean searchFlower(FlowerType flowerType) {
        for (FlowerPack flowerPack : flowerPacks) {
            if (flowerPack.getFlower().getFlowerType() == flowerType) {
                return true;
            }
        }
        return false;
    }
}
