package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.domain.Fruit;
import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.services.ServiceImplementation;


@RestController
@RequestMapping(value = "/api/v1/fruit")
public class FruitController {

    @Autowired
    private ServiceImplementation serviceImplementation;

    @PostMapping(value = "/add")
    public ResponseEntity<String> createFruit(@RequestBody Fruit fruit) {
            
        serviceImplementation.addFruit(fruit);
        return new ResponseEntity<>("fruit successfully added", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteFruitById(@PathVariable("id") Long id) {
        
        serviceImplementation.deleteFruit(id);
        return new ResponseEntity<>("fruit deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/getAll")
    public List<Fruit> getAllFruits() {

        return serviceImplementation.getAll();
    }

    @GetMapping("/getOne/{id}")
    public Fruit findFruitById(@PathVariable("id") Long id) {
        
        return serviceImplementation.getOne(id);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFruitById(@PathVariable("id") long id, @RequestBody Fruit updatedFruit) {

        serviceImplementation.updateFruit(id, updatedFruit);
        return new ResponseEntity<>("fruit updated successfully", HttpStatus.OK);
        }
        
}
