package com.pitchfork.application.artist.entity;

import com.pitchfork.application.review.entity.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long artistid;

    @ManyToOne
    @JoinColumn(name = "reviewid")
    private Review review;

    private String artist;
}
