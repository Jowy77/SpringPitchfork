package com.pitchfork.application.genre.entity;

import com.pitchfork.application.review.entity.Review;
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
@Table(name = "genres" )
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long genreid;

    @ManyToOne
    @JoinColumn(name = "reviewid")
    private Review review;

    private String genre;
}
