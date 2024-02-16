package com.pitchfork.application.artist.controller;

import com.pitchfork.application.artist.dto.ArtistResponseDTO;
import com.pitchfork.application.artist.service.ArtistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/artist")
public class ArtistController {

    private final ArtistService artistService;

    @GetMapping("/name")
    public ResponseEntity<List<ArtistResponseDTO>> findAllArtistsByName(@RequestParam(name = "name", required = false) String name){
        return ResponseEntity.ok(artistService.findAllByName(name));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteArtistById(@RequestParam("id") Long id) {
        artistService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
