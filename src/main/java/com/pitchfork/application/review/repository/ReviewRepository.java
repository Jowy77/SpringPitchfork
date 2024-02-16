package com.pitchfork.application.review.repository;

import com.pitchfork.application.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
  @Query("""
        SELECT r FROM Review r 
        WHERE (:minScore IS NULL OR r.score > :minScore) 
        AND (:genre IS NULL OR EXISTS (SELECT g FROM Genre g WHERE g.review = r AND g.genre = :genre))
        GROUP BY r.score, r.reviewid
    """)
    Page<Review> findByFilters(Double minScore, String genre, Pageable pageable);

}

