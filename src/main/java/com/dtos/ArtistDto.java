package com.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArtistDto {

    private Long id;

    @NotBlank
    private String prenom;

    @NotBlank
    private String nom;

    private Integer age;
    private String genre;

    private Boolean estActeur;
    private Boolean estRealisateur;

    private String bio;
}