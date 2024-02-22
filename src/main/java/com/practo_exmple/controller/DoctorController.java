package com.practo_exmple.controller;
import com.practo_exmple.payload.DoctorDto;
import com.practo_exmple.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto doctorDto) {
        DoctorDto createdDoctor = doctorService.addDoctor(doctorDto);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }
    @GetMapping("/search")
    public ResponseEntity<List<DoctorDto>> findDoctorsByNameOrSpecializationOrHospital(
            @RequestParam(value = "keyword") String keyword) {
        List<DoctorDto> doctors = doctorService.findDoctorsByNameOrSpecializationOrHospital(keyword);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }
}