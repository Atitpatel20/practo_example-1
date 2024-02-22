package com.practo_exmple.service.Impl;

import com.practo_exmple.entity.Doctor;
import com.practo_exmple.exception.ResourceNotFoundException;
import com.practo_exmple.payload.DoctorDto;
import com.practo_exmple.repository.DoctorRepository;
import com.practo_exmple.service.DoctorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DoctorDto addDoctor(DoctorDto doctorDto) {
        Doctor doctor = mapToEntity(doctorDto);
        Doctor save = doctorRepository.save(doctor);
        return mapToDto(save);
    }

    @Override
    public List<DoctorDto> findDoctorsByNameOrSpecializationOrHospital(String keyword) {
        List<Doctor> doctors = doctorRepository.findByDoctorNameOrSpecializationOrHospital(keyword);
        List<DoctorDto> listOfDoctors = doctors.stream().map(d -> mapToDto(d)).collect(Collectors.toList());
        return listOfDoctors;
    }

    @Override
    public DoctorDto findDoctorByDoctorId(long doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(
                () -> new ResourceNotFoundException("Doctor not found with id: " + doctorId));
        return mapToDto(doctor);
    }

    DoctorDto mapToDto(Doctor doctor) {
        DoctorDto dto = modelMapper.map(doctor, DoctorDto.class);
        return dto;
    }

    Doctor mapToEntity(DoctorDto doctorDto) {
        Doctor dto = modelMapper.map(doctorDto, Doctor.class);
        return dto;
    }
}
