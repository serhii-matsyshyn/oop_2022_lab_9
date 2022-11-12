package ua.edu.ucu.apps.demo.flowers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlowerController {
    private final FlowerService flowerService;

    @Autowired
    public FlowerController(FlowerService flowerService) {
        this.flowerService = flowerService;
    }

    @GetMapping(value= {"/api/v1/flower", "/api/flowers-list"})
    public List<Flower> getFlowers() {
        return flowerService.getFlowers();
    }

    // addFlower post method with json body
    @PostMapping(value= {"/api/add-flower", "/api/v1/flower"})
    public List<Flower> addFlower(@RequestBody Flower flower) {
        flowerService.addFlower(flower);
        return flowerService.getFlowers();
    }
}
