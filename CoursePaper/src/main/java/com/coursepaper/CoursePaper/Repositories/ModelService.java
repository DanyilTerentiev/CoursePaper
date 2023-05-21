package com.coursepaper.CoursePaper.Repositories;

import com.coursepaper.CoursePaper.DTOs.ModelDTO;
import com.coursepaper.CoursePaper.Entitities.Model;
import com.coursepaper.CoursePaper.Entitities.Tissue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ModelService {
    private final IModelRepository repository;
    private final TissueService tissueService;
    @Autowired
    public ModelService(IModelRepository repository, TissueService tissueService) {
        this.repository = repository;
        this.tissueService = tissueService;
    }

    public Optional<List<Model>> getAllModels(int topicId) {
        if (repository.findModelsByTissueId(topicId).isPresent())
            return repository.findModelsByTissueId(topicId);
        else return null;
    }

    public ResponseEntity<?> addModel(@RequestBody ModelDTO modelDTO) {
        Tissue t = tissueService.getTissue(modelDTO.getTissueId()).get();
        if (tissueService.getTissue(modelDTO.getTissueId()).isEmpty())
            return new ResponseEntity<>("No tissues with that index", HttpStatus.FAILED_DEPENDENCY);
        Model model = new Model();
        model.setTissue(t);
        model.setName(modelDTO.getName());
        model.setPrice(modelDTO.getPrice() + t.getPrice());
        repository.save(model);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    public void deleteModel(int id) {
        repository.deleteById(id);
    }

    public Optional<Model> updateModel(@RequestBody Model model) {
        Optional<Model> s = repository.findById(model.getId());
        if (s.isEmpty()) {
            throw new NoSuchElementException("there is no model with such id");
        } else if (s.isPresent()) {
            repository.save(model);
        }
        return Optional.of(model);
    }
}
