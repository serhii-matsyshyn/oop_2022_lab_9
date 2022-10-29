package ua.edu.ucu.apps.demo.flowers;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;


@Setter
@ToString
public class Flower {
    @Getter
    private FlowerType flowerType;

    private FlowerColor color;

    @Getter
    private double sepalLength;

    @Getter
    private double price;


    public Flower() {
        flowerType = FlowerType.ANY;
        sepalLength = 0;
        color = FlowerColor.ANY;
        price = 0;
    }

    public Flower(FlowerType flowerType) {
        this.flowerType = flowerType;
        sepalLength = 0;
        color = FlowerColor.ANY;
        price = 0;
    }

    public Flower(FlowerType flowerType, FlowerColor flowerColor,
                  double sepalLength, int price) {
        this.flowerType = flowerType;
        this.color = flowerColor;
        this.sepalLength = sepalLength;
        this.price = price;
    }

    public Flower(FlowerType flowerType, FlowerColor flowerColor,
                  double sepalLength) {
        this.flowerType = flowerType;
        this.color = flowerColor;
        this.sepalLength = sepalLength;
    }

    public String getColor() {
        return color.toString();
    }

    public boolean almostEquals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Flower flower = (Flower) obj;

        if (!Objects.equals(flower.getColor(), FlowerColor.ANY.toString())
                && !Objects.equals(flower.getColor(), getColor())) {
            return false;
        }
        if (flower.getFlowerType() != FlowerType.ANY
                && !Objects.equals(flower.getFlowerType(), getFlowerType())) {
            return false;
        }
        if (flower.getSepalLength() != 0
                && !Objects.equals(flower.getSepalLength(), getSepalLength())) {
            return false;
        }
        return true;
    }
}
