package org.example.userservice.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.userservice.model.Owner;
import org.example.userservice.repository.OwnerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
@RequiredArgsConstructor
public class OwnerResource {
    private final OwnerRepository ownerRepository;
    @GetMapping
    public List<Owner> findAllOwners() {
        return ownerRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner createOwner(@Valid @RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }

    @GetMapping("/{ownerId}")
    public Owner getOwner(@PathVariable("ownerId") Integer ownerId) {
        return ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found: " + ownerId));
    }

    @PutMapping("/{ownerId}")
    public Owner updateOwner(@PathVariable("ownerId") Integer ownerId, @RequestBody Owner ownerRequest) {

        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        owner.setFirstName(ownerRequest.getFirstName());
        owner.setLastName(ownerRequest.getLastName());
        owner.setAddress(ownerRequest.getAddress());
        owner.setCity(ownerRequest.getCity());
        owner.setTelephone(ownerRequest.getTelephone());

        return ownerRepository.save(owner);
    }

    @DeleteMapping("/{ownerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOwner(@PathVariable("ownerId") Integer ownerId) {
        ownerRepository.deleteById(ownerId);
    }

    @GetMapping("/search")
    public List<Owner> findAllByFirstName(@RequestParam String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
