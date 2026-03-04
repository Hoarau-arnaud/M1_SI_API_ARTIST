package com.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "artist")
@Data
@NoArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;

    private Integer age; // nullable
    private String genre;

    private Boolean estActeur = false;
    private Boolean estRealisateur = false;

    @Column(length = 2000)
    private String bio;
}