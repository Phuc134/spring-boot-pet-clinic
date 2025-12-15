package org.example.userservice.web;

import lombok.RequiredArgsConstructor;
import org.example.userservice.model.Pet;
import org.example.userservice.model.PetType;
import org.example.userservice.repository.PetRepository;
import org.example.userservice.repository.PetTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetResource {
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    @GetMapping
    public List<Pet> getPets() {
        return petRepository.findAll();
    }

    @GetMapping("/{petId}")
    public Pet getPet(@PathVariable("petId") Integer petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new RuntimeException("Pet not found: " + petId));
    }

    @PostMapping
    public Pet createPet(@RequestBody Pet pet) {
        return petRepository.save(pet);
    }

    @GetMapping("/types")
    private  List<PetType> getPetTypes() {
        return petTypeRepository.findAll();
    }
}
