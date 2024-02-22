package com.practo_exmple.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDto {
    private long id;
    private long patientId;
    private long doctorId;
    private int ratings;
    private String description;
}
