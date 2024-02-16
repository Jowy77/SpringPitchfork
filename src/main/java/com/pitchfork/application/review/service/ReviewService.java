package com.pitchfork.application.review.service;

import com.pitchfork.application.review.dto.ReviewRequestDTO;
import com.pitchfork.application.review.dto.ReviewResponseDTO;
import org.springframework.data.domain.Page;


public interface ReviewService {

    Page<ReviewResponseDTO> findReviews(int page, int size, Double minScore, String genre, String orderBy);

    void deleteById(Long id);

    void saveReview(ReviewRequestDTO reviewRequestDTO);
}
