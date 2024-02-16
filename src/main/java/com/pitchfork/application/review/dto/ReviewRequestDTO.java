package com.pitchfork.application.review.dto;

import com.pitchfork.application.artist.dto.ArtistRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {

    private String title;

    private String artist;

    private String url;

    private Double score;

    private Boolean bestNewMusic;

    private String author;

    private String authorType;

    private String pubDate;

    private Integer pubWeekday;

    private Integer pubDay;

    private Integer pubMonth;

    private Integer pubYear;

    private List<ArtistRequestDTO> artists;
}
