package org.example.userservice.web;

import lombok.RequiredArgsConstructor;
import org.example.userservice.model.Owner;
import org.example.userservice.repository.OwnerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
