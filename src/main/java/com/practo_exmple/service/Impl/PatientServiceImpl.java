package com.practo_exmple.service.Impl;

import com.practo_exmple.entity.Patient;
import com.practo_exmple.payload.PatientDto;
import com.practo_exmple.repository.PatientRepository;
import com.practo_exmple.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = mapToEntity(patientDto);
        Patient savePatient = patientRepository.save(patient);
        return mapToDto(savePatient);
    }

    PatientDto mapToDto(Patient patient) {
        PatientDto dto = modelMapper.map(patient, PatientDto.class);
        return dto;
    }

    Patient mapToEntity(PatientDto patientDto) {
        Patient dto = modelMapper.map(patientDto, Patient.class);
        return dto;
    }
}
