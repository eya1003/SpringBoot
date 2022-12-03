package com.example.clinic.Repositorys;

import com.example.clinic.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaitenRepository extends JpaRepository<Patient,Long> {
}
