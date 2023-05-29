package com.example.GE_v2.repositories;

import com.example.GE_v2.models.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEleveRepository extends JpaRepository<Eleve, Long> {
   List<Eleve> findByFiliereNom(String nomFiliere);
}
