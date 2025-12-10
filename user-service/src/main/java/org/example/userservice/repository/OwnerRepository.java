package org.example.userservice.repository;

import org.example.userservice.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
