package com.services;

import com.dtos.ArtistDto;

import java.util.List;

public interface ArtistService {
    List<ArtistDto> getAllArtists();
    ArtistDto getArtistById(Long id);
    ArtistDto createArtist(ArtistDto dto);
    ArtistDto updateArtist(Long id, ArtistDto dto);
    Boolean deleteArtist(Long id);
}