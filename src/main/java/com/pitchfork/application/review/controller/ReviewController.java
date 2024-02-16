package com.pitchfork.application.review.controller;

import com.pitchfork.application.review.dto.ReviewRequestDTO;
import com.pitchfork.application.review.dto.ReviewResponseDTO;
import com.pitchfork.application.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping("/reviews")
    public ResponseEntity<Page<ReviewResponseDTO>> getReviews(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Double minScore,
            @RequestParam(required = false) String genre,
            @RequestParam(defaultValue = "ASC") String orderBy) {
        return ResponseEntity.ok(reviewService.findReviews(page,size,minScore, genre, orderBy));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteReviewById(@RequestParam("id") Long id) {
       reviewService.deleteById(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Void> safeReview(@RequestBody ReviewRequestDTO reviewRequestDTO) {
        reviewService.saveReview(reviewRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
