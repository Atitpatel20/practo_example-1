package com.practo_exmple.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private long id;
    private String name;
    private String diseases;
    private int age;
}
