package com.pitchfork.application.artist.service.impl;

import com.pitchfork.application.artist.dto.ArtistResponseDTO;
import com.pitchfork.application.artist.entity.Artist;
import com.pitchfork.application.artist.mapper.ArtistMapper;
import com.pitchfork.application.artist.repository.ArtistRepository;
import com.pitchfork.application.artist.service.ArtistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    private final ArtistMapper artistMapper;


    @Override
    @Transactional(readOnly = true)
    public List<ArtistResponseDTO> findAllByName(String name) {
        log.info("Searching for artists by name: {}", name);
        List<Artist> artists = artistRepository.findAllArtistsOrByArtistContainingIgnoreCase(name);
        if(CollectionUtils.isEmpty(artists)){
            log.info("No artist found.");
            return Collections.emptyList();
        }
        log.info("Found: {}", artists.size());
        return artistMapper.asArtistResponseList(artists);
    }

    @Override
    public void deleteById(Long id) {
        log.info("Removing the artist by ID: {}", id);
        artistRepository.deleteById(id);
    }
}
