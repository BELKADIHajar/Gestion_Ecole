package com.example.GE_v2.repositories;

import com.example.GE_v2.models.Eleve;
import com.example.GE_v2.models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INiveauRepository  extends JpaRepository<Niveau, Long> {
    List<Niveau> findBySiteNom(String nomSite);
}
