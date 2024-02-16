package com.pitchfork.application.review.service.impl;

import com.pitchfork.application.artist.repository.ArtistRepository;
import com.pitchfork.application.review.dto.ReviewRequestDTO;
import com.pitchfork.application.review.dto.ReviewResponseDTO;
import com.pitchfork.application.review.entity.Review;
import com.pitchfork.application.review.mapper.ReviewMapper;
import com.pitchfork.application.review.repository.ReviewRepository;
import com.pitchfork.application.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;


@Slf4j
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    private final ArtistRepository artistRepository;

    private final String ORDER_BY_DES = "DESC";

    private final String ORDER_BY_ASC = "ASC";

    private final String SCORE ="score";


    @Override
    @Transactional(readOnly = true)
    public Page<ReviewResponseDTO> findReviews(int page, int size, Double minScore, String genre, String orderBy) {
        log.info("Find the reviews");
        Page<Review> reviews = reviewRepository.findByFilters(minScore, genre, PageRequest.of(page, size, orderBy(orderBy)));

        return reviews.map(reviewMapper::asReviewResponseDTO);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Removing the artist by ID: {}", id);
        reviewRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveReview(ReviewRequestDTO reviewRequestDTO) {
        Review review = reviewMapper.asReview(reviewRequestDTO);
        if (!CollectionUtils.isEmpty(review.getArtists())) {
            review.getArtists().forEach(artist -> artist.setReview(review));
        }
        log.info("Saving the review");
        reviewRepository.saveAndFlush(review);
    }

    private Sort orderBy(String orderBy) {
        if (orderBy != null) {
            if (ORDER_BY_ASC.equalsIgnoreCase(orderBy)) {
                return Sort.by(SCORE).ascending();
            } else if (ORDER_BY_DES.equalsIgnoreCase(orderBy)) {
                return Sort.by(SCORE).descending();
            }
        }
        return Sort.by(SCORE).ascending();
    }
}
