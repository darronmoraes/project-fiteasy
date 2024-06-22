package com.developerjugad.fiteasy.db.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @NotNull(message = "Address caanot be null")
    @NotEmpty(message = "Address caanot be empty")
    private String address;

    @NotNull(message = "Gender cannot be null")
    private Boolean isMale;
}