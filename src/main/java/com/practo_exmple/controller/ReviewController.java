package com.practo_exmple.controller;

import com.practo_exmple.payload.DoctorDto;
import com.practo_exmple.payload.DoctorReviewDto;
import com.practo_exmple.payload.ReviewDto;
import com.practo_exmple.repository.DoctorRepository;
import com.practo_exmple.service.DoctorService;
import com.practo_exmple.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<ReviewDto> giveReview(@RequestBody ReviewDto reviewDto) {
        ReviewDto reviews = reviewService.giveReview(reviewDto);
        return new ResponseEntity<>(reviews, HttpStatus.CREATED);
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorReviewDto> getReviewByDoctorId(@PathVariable long doctorId) {
        List<ReviewDto> reviewByDoctorId = reviewService.getReviewByDoctorId(doctorId);
        DoctorDto dtos = doctorService.findDoctorByDoctorId(doctorId);

        // user direct repository layer to find doctor but its not the right way
//        Doctor doctor = doctorRepository.findById(doctorId).get();
        DoctorReviewDto reviewDto = new DoctorReviewDto();
        reviewDto.setDoctor(dtos);
        reviewDto.setReviews(reviewByDoctorId);
        return new ResponseEntity<>(reviewDto, HttpStatus.OK);
    }

}
