package com.smart_housing.smart_housing.Controller;

import com.smart_housing.smart_housing.model.House;
import com.smart_housing.smart_housing.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@CrossOrigin(origins = "http://localhost:5500") // frontend origin
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @GetMapping("/{id}")
    public House getHouseById(@PathVariable int id) {
        return houseService.getHouseById(id);
    }

    @PostMapping
    public House addHouse(@RequestBody House house) {
        return houseService.addHouse(house);
    }

    @PutMapping("/{id}")
    public House updateHouse(@PathVariable int id, @RequestBody House house) {
        return houseService.updateHouse(id, house);
    }

    @DeleteMapping("/{id}")
    public String deleteHouse(@PathVariable int id) {
        return houseService.deleteHouse(id);
    }
}
