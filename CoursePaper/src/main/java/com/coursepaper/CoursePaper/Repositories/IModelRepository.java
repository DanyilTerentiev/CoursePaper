package com.coursepaper.CoursePaper.Repositories;

import com.coursepaper.CoursePaper.Entitities.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IModelRepository extends JpaRepository<Model, Integer> {
    public Optional<List<Model>> findModelsByTissueId(int tissueId);
    public Optional<List<Model>> findModelsByOrderId(int orderId);
}
