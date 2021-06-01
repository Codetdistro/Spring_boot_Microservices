package com.example.dogs.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.dogs.entity.Dog;
import com.example.dogs.exceptions.BreedNotFoundException;
import com.example.dogs.exceptions.DogNotFoundException;
import com.example.dogs.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class Mutation implements GraphQLMutationResolver {
    DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public Boolean deleteDogBreed(String breed){
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        for(Dog d:allDogs){
            if(d.getBreed().equals(breed)){
                dogRepository.delete(d);
                deleted = true;
            }
        }
        if (!deleted){
            throw new BreedNotFoundException("Breed not Found",breed);
        }
        return deleted;
    }


    public Dog updateDogName(String newName,Long id){
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()){
            Dog d  = optionalDog.get();
            d.setName(newName);
            dogRepository.save(d);
            return d;
        }else {
            throw new DogNotFoundException("Dog not Found",id);
        }

    }
}
