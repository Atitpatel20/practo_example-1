package com.practo_exmple.repository;

import com.practo_exmple.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE d.name LIKE %:keyword% OR d.qualification LIKE %:keyword% OR d.hospital LIKE %:keyword%")
    List<Doctor> findByDoctorNameOrSpecializationOrHospital(@Param("keyword") String keyword);
}
