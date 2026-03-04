package com.mappers;

import com.dtos.ArtistDto;
import com.entities.Artist;
import org.springframework.stereotype.Component;

@Component
public class ArtistMapper {

    public ArtistDto toDto(Artist a) {
        if (a == null) return null;
        ArtistDto dto = new ArtistDto();
        dto.setId(a.getId());
        dto.setPrenom(a.getPrenom());
        dto.setNom(a.getNom());
        dto.setAge(a.getAge());
        dto.setGenre(a.getGenre());
        dto.setEstActeur(a.getEstActeur());
        dto.setEstRealisateur(a.getEstRealisateur());
        dto.setBio(a.getBio());
        return dto;
    }

    public Artist toEntity(ArtistDto dto) {
        if (dto == null) return null;
        Artist a = new Artist();
        if (dto.getId() != null) a.setId(dto.getId());
        a.setPrenom(dto.getPrenom());
        a.setNom(dto.getNom());
        a.setAge(dto.getAge());
        a.setGenre(dto.getGenre());
        a.setEstActeur(dto.getEstActeur());
        a.setEstRealisateur(dto.getEstRealisateur());
        a.setBio(dto.getBio());
        return a;
    }
}