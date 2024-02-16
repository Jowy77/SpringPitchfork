package com.pitchfork.application.artist.mapper;

import com.pitchfork.application.artist.dto.ArtistResponseDTO;
import com.pitchfork.application.artist.entity.Artist;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ArtistMapper {

   List<ArtistResponseDTO> asArtistResponseList(List<Artist> artists);



}
