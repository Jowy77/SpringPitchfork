package com.pitchfork.application.artist.service;

import com.pitchfork.application.artist.dto.ArtistResponseDTO;

import java.util.List;

public interface ArtistService {

    List<ArtistResponseDTO> findAllByName(String name);

    void deleteById(Long id);

}
