package org.example.userservice.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PetRequest {
    private String name;
    private LocalDate birthDate;
    private Integer typeId;
    private Integer ownerId;
}
