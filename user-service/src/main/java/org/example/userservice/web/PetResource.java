package org.example.userservice.web;

import lombok.RequiredArgsConstructor;
import org.example.userservice.dto.request.PetRequest;
import org.example.userservice.model.Owner;
import org.example.userservice.model.Pet;
import org.example.userservice.model.PetType;
import org.example.userservice.repository.OwnerRepository;
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
    private final OwnerRepository ownerRepository;
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
    public Pet createPet(@RequestBody PetRequest pet) {
        Pet newPet = new Pet();
        pet.setName(newPet.getName());
        pet.setBirthDate(newPet.getBirthDate());

        PetType petType = petTypeRepository.findById(pet.getTypeId())
                .orElseThrow(() -> new RuntimeException("PetType not found: " + pet.getTypeId()));
        newPet.setPetType(petType);

        Owner owner = ownerRepository.findById(pet.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found: " + pet.getOwnerId()));
        newPet.setOwner(owner);
        return petRepository.save(newPet);
    }

    @GetMapping("/types")
    private  List<PetType> getPetTypes() {
        return petTypeRepository.findAll();
    }
}
