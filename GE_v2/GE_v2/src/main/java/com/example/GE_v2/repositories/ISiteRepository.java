package com.example.GE_v2.repositories;

import com.example.GE_v2.models.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISiteRepository extends JpaRepository<Site, Long> {
}
