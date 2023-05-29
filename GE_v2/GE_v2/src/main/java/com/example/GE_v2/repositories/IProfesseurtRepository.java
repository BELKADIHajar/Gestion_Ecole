package com.example.GE_v2.repositories;

import com.example.GE_v2.models.professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProfesseurtRepository extends JpaRepository<professeur, Long> {
    List<professeur> findByMatiereNom(String nomMatiere);

}