package org.example.userservice.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "types")
@Data
@Entity
public class PetType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;


}
