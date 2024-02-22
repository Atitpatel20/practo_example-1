package com.practo_exmple.payload;

import com.practo_exmple.entity.Doctor;
import com.practo_exmple.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class DoctorReviewDto {
    private DoctorDto doctor;
    List<ReviewDto> reviews;
}
