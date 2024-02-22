package com.practo_exmple.service;

import com.practo_exmple.payload.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto addDoctor(DoctorDto doctorDto);

    List<DoctorDto> findDoctorsByNameOrSpecializationOrHospital(String keyword);

    DoctorDto findDoctorByDoctorId(long doctorId);
}
