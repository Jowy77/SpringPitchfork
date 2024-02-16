package com.pitchfork.application.year.entity;

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
@Table(name = "years" )
public class Year {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long yearid;

    @ManyToOne
    @JoinColumn(name = "reviewid")
    private Review review;

    @Column(name = "`YEAR`")
    private String year;
}
