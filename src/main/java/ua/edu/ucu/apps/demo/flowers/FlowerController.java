package ua.edu.ucu.apps.demo.flowers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/flowers-list")
public class FlowerController {
    @GetMapping
    public List<Flower> getFlowers() {
        return List.of(
                new Flower(FlowerType.ROSE, FlowerColor.BLUE, 10, 20),
                new Flower(FlowerType.ROSE, FlowerColor.RED, 20, 222),
                new Flower(FlowerType.CHAMOMILE, FlowerColor.RED, 22, 111)
        );
    }
}
