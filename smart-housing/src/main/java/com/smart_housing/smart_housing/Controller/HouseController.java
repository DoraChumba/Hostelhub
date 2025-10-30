package com.smart_housing.smart_housing.Controller;

/*import com.smart_housing.smart_housing.model.House;
import com.smart_housing.smart_housing.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@CrossOrigin(origins={ "http://localhost:8080","http://127.0.0.01:8080"}) // frontend origin
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

    @PostMapping(consumes = {"multipart/form-data"})
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
*/


import com.smart_housing.smart_housing.model.House;
import com.smart_housing.smart_housing.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@CrossOrigin(origins={ "http://localhost:8080","http://127.0.0.01:8080"}) // frontend origin
public class HouseController {

    @Autowired
    private HouseService houseService;

    // --- GET methods remain unchanged ---

    @GetMapping
    public List<House> getAllHouses() {
        return houseService.getAllHouses();
    }

    @GetMapping("/{id}")
    public House getHouseById(@PathVariable int id) {
        return houseService.getHouseById(id);
    }

    // -------------------------------------------------------------------------
    // REWRITTEN POST METHOD TO HANDLE MULTIPART/FORM-DATA
    // -------------------------------------------------------------------------

    /**
     * Handles creating a new House, accepting the house details as a JSON part
     * and the image file as a separate part in a single multipart/form-data request.
     *
     * @param houseData The house data (e.g., landlordId, location, rent) sent as a JSON object within the request.
     * @param imageFile The actual file being uploaded.
     * @return The newly created House object.
     */
    @PostMapping(consumes = {"multipart/form-data"})
    public House addHouse(
    @RequestParam("landlordId") int landlordId,
    @RequestParam("location") String location,
    @RequestParam("rent") double rent,
    @RequestParam("amenities") String amenities,
    @RequestParam("image_path") String imagePath,
    @RequestParam("status") String status,
    // File uses @RequestPart
     @RequestPart("imageFile") MultipartFile imageFile) {
        
        // This method signature is designed to resolve the 415 error.
        // It uses @RequestPart to properly handle the two separate parts of the multipart request.
        
        // You will need to update your service layer to handle the file storage logic.
        House house = new House(landlordId, location, rent, amenities, imagePath, status);
        return houseService.addHouse(house, imageFile);
        
    }

    // --- PUT and DELETE methods remain unchanged ---

    @PutMapping("/{id}")
    public House updateHouse(@PathVariable int id, @RequestBody House house) {
        return houseService.updateHouse(id, house);
    }

    @DeleteMapping("/{id}")
    public String deleteHouse(@PathVariable int id) {
        return houseService.deleteHouse(id);
    }
}