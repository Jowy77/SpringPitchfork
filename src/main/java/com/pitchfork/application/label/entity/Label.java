package com.pitchfork.application.label.entity;

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
@Table(name = "labels" )
public class Label {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labelid;

    @ManyToOne
    @JoinColumn(name = "reviewid")
    private Review review;

    private String label;
}
