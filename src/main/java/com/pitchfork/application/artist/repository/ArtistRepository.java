package com.pitchfork.application.artist.repository;

import com.pitchfork.application.artist.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    List<Artist> findByArtistContainingIgnoreCase(String name);

    default List<Artist> findAllArtistsOrByArtistContainingIgnoreCase(String name) {
        if (name == null || name.isEmpty()) {
            return findAll();
        } else {
            return findByArtistContainingIgnoreCase(name);
        }
    }

}
