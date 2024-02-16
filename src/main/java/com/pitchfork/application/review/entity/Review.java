package com.pitchfork.application.review.entity;

import com.pitchfork.application.artist.entity.Artist;
import com.pitchfork.application.genre.entity.Genre;
import com.pitchfork.application.label.entity.Label;
import com.pitchfork.application.year.entity.Year;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewid;

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

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Artist> artists;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Genre> genres;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Label> labels;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Year> years;
}
