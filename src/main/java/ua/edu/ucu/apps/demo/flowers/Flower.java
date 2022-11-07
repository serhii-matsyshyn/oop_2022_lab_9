package ua.edu.ucu.apps.demo.flowers;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import java.util.Objects;


@Setter
@ToString
@AllArgsConstructor
@Entity
@Table
public class Flower {
    @javax.persistence.Id
    @Id @GeneratedValue @Setter @Getter
    private Long id;
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
