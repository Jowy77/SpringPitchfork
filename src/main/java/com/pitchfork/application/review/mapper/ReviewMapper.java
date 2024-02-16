package com.pitchfork.application.review.mapper;

import com.pitchfork.application.artist.entity.Artist;
import com.pitchfork.application.review.dto.ReviewRequestDTO;
import com.pitchfork.application.review.dto.ReviewResponseDTO;
import com.pitchfork.application.review.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface ReviewMapper {

    ReviewResponseDTO asReviewResponseDTO(Review review);

    Review asReview(ReviewRequestDTO reviewRequestDTO);

}
