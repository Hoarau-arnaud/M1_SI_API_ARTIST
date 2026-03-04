package com.services.impl;

import com.dtos.ArtistDto;
import com.entities.Artist;
import com.mappers.ArtistMapper;
import com.repositories.ArtistRepository;
import com.services.ArtistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final ArtistMapper artistMapper;

    public ArtistServiceImpl(ArtistRepository artistRepository, ArtistMapper artistMapper) {
        this.artistRepository = artistRepository;
        this.artistMapper = artistMapper;
    }

    @Override
    public List<ArtistDto> getAllArtists() {
        return artistRepository.findAll()
                .stream()
                .map(artistMapper::toDto)
                .toList();
    }

    @Override
    public ArtistDto getArtistById(Long id) {
        Artist artist = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist introuvable: id=" + id));
        return artistMapper.toDto(artist);
    }

    @Override
    @Transactional
    public ArtistDto createArtist(ArtistDto dto) {
        // Important : en création, l'id doit être null (ou ignoré)
        dto.setId(null);

        Artist artist = artistMapper.toEntity(dto);
        Artist saved = artistRepository.save(artist);
        return artistMapper.toDto(saved);
    }

    @Override
    @Transactional
    public ArtistDto updateArtist(Long id, ArtistDto dto) {
        Artist existing = artistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artist introuvable: id=" + id));

        // Mise à jour champ par champ (safe)
        existing.setPrenom(dto.getPrenom());
        existing.setNom(dto.getNom());
        existing.setAge(dto.getAge());
        existing.setGenre(dto.getGenre());
        existing.setEstActeur(dto.getEstActeur());
        existing.setEstRealisateur(dto.getEstRealisateur());
        existing.setBio(dto.getBio());

        Artist saved = artistRepository.save(existing);
        return artistMapper.toDto(saved);
    }

    @Override
    @Transactional
    public Boolean deleteArtist(Long id) {
        if (!artistRepository.existsById(id)) {
            return false;
        }
        artistRepository.deleteById(id);
        return true;
    }
}