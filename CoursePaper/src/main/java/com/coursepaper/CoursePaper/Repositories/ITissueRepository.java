package com.coursepaper.CoursePaper.Repositories;

import com.coursepaper.CoursePaper.Entitities.Tissue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ITissueRepository extends JpaRepository<Tissue, Integer> {
    public Optional<Tissue> findTissueByProvider(String provider);
    public Optional<Tissue> findTissueByName(String name);
}
