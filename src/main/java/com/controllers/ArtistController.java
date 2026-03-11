package com.controllers;

import com.dtos.ArtistDto;
import com.services.ArtistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<ArtistDto> getAll() {
        return artistService.getAllArtists();
    }

    @GetMapping("/{id}")
    public ArtistDto getById(@PathVariable("id") Long id) {
        return artistService.getArtistById(id);
    }

    @PostMapping
    public ArtistDto create(@RequestBody ArtistDto dto) {
        return artistService.createArtist(dto);
    }

    @PutMapping("/{id}")
    public ArtistDto update(@PathVariable("id") Long id, @RequestBody ArtistDto dto) {
        return artistService.updateArtist(id, dto);
    }

    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id) {
        return artistService.deleteArtist(id);
    }
    
    
    
    
    
}