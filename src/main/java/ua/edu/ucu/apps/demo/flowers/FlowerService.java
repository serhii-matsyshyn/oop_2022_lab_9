package ua.edu.ucu.apps.demo.flowers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {
    public List<Flower> getFlowers() {
        return List.of(
                new Flower(FlowerType.ROSE, FlowerColor.BLUE, 10, 20),
                new Flower(FlowerType.ROSE, FlowerColor.RED, 20, 222),
                new Flower(FlowerType.CHAMOMILE, FlowerColor.RED, 22, 111)
        );
    }
}
