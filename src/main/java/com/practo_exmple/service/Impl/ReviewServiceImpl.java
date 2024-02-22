package com.practo_exmple.service.Impl;

import com.practo_exmple.entity.Doctor;
import com.practo_exmple.entity.Patient;
import com.practo_exmple.entity.Review;
import com.practo_exmple.exception.ResourceNotFoundException;
import com.practo_exmple.payload.ReviewDto;
import com.practo_exmple.repository.DoctorRepository;
import com.practo_exmple.repository.PatientRepository;
import com.practo_exmple.repository.ReviewRepository;
import com.practo_exmple.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PatientRepository  patientRepository;
    @Override
    public ReviewDto giveReview(ReviewDto reviewDto) {
        Patient patient = patientRepository.findById(reviewDto.getPatientId()).orElseThrow(
                () -> new ResourceNotFoundException("patient is not found with id: " + reviewDto.getPatientId())
        );


        Doctor doctor = doctorRepository.findById(reviewDto.getDoctorId()).orElseThrow(
                () -> new ResourceNotFoundException("doctor is not found with id: " + reviewDto.getDoctorId())
        );
        if (doctor!=null || patient!=null) {
            Review review = mapToEntity(reviewDto);
            Review save = reviewRepository.save(review);
            return mapToDto(save);
        }else{
            return null;
        }
    }

    @Override
    public List<ReviewDto> getReviewByDoctorId(long doctorId) {
        List<Review> reviews = reviewRepository.findByDoctorId(doctorId);
        List<ReviewDto> collect = reviews.stream().map(r -> mapToDto(r)).collect(Collectors.toList());
        return collect;
    }

    ReviewDto mapToDto(Review review) {
        ReviewDto dto = modelMapper.map(review, ReviewDto.class);
        return dto;
    }

    Review mapToEntity(ReviewDto reviewDto) {
        Review dto = modelMapper.map(reviewDto, Review.class);
        return dto;
    }
}
