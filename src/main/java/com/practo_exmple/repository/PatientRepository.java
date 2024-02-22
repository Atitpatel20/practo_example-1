package com.practo_exmple.repository;

import com.practo_exmple.entity.Doctor;
import com.practo_exmple.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
//    Doctor findDoctorById(long doctorId);
}
