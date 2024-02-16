package com.pitchfork.application.artist.dto;

import com.pitchfork.application.review.dto.ReviewResponseDTO;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistResponseDTO {

    private String artist;

    private ReviewResponseDTO review;
}
