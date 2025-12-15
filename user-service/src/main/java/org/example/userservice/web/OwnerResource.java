package org.example.userservice.web;

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
    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Owner save(@RequestBody Owner owner) {
        return ownerRepository.save(owner);
    }
}
