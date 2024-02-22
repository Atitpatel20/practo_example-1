package com.practo_exmple.service;

import com.practo_exmple.payload.ReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewDto giveReview(ReviewDto reviewDto);

    List<ReviewDto> getReviewByDoctorId(long doctorId);
}
