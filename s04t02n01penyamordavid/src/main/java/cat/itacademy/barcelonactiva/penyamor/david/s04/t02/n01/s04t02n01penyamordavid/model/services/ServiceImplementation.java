package cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.services;

import java.util.Optional;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.domain.Fruit;
import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.penyamor.david.s04.t02.n01.s04t02n01penyamordavid.model.repository.FruitRepository;


@Service
public class ServiceImplementation implements FruitServices {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public void updateFruit(long id, Fruit fruit) {

        Fruit existingFruit = fruitRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("fruit not found"));
        
        existingFruit.setKilograms(fruit.getKilograms());
        existingFruit.setName(fruit.getName());
        fruitRepository.save(existingFruit);
    }

    public void deleteFruit(long id) {
        
        Optional<Fruit> fruit = fruitRepository.findById(id);
        if (!fruit.isPresent())
            throw new FruitNotFoundException("Fruit not found");
        fruitRepository.deleteById(id);
    }

    public Fruit getOne(long id) {

        Optional<Fruit> fruit = fruitRepository.findById(id);
        return fruit.orElseThrow(() -> new FruitNotFoundException("Fruit not found"));
    }

    public List<Fruit> getAll() {

        return fruitRepository.findAll();
    }
}
