package com.practo_exmple.payload;

import com.practo_exmple.entity.Doctor;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Long id;
    private String name;
    private String qualification;
    private String specialization;
    private String experience;
    private String description;
    private String hospital;
}
