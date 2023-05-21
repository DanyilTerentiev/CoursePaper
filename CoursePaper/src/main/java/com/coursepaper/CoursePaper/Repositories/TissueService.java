package com.coursepaper.CoursePaper.Repositories;

import com.coursepaper.CoursePaper.Entitities.Tissue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TissueService {
    private final ITissueRepository repository;
    @Autowired
    public TissueService(ITissueRepository repository) {
        this.repository = repository;
    }
    public List<Tissue> getTissues() {
        return repository.findAll();
    }
    public Optional<Tissue> getTissueById(int id) {
        return repository.findById(id);
    }

    public Tissue addTissue(@RequestBody Tissue tissue) {
        Optional<Tissue> s = repository.findTissueByName(tissue.getName());
        if (s.isPresent()) {
            throw new IllegalStateException("email has been taken");
        }
        Tissue savedTissue = repository.save(tissue);
        return savedTissue;
    }

    public void deleteTissue(int id) {
        repository.deleteById(id);
    }

    public Optional<Tissue> updateTissue(@RequestBody Tissue tissue) {
        Optional<Tissue> s = repository.findById(tissue.getId());
        if (s.isEmpty()) {
            throw new NoSuchElementException("there is no tissue with such id");
        } else if (s.isPresent()) {
//            s = Optional.of(tissue);
            repository.save(tissue);
        }
        return Optional.of(tissue);
    }

    public Optional<Tissue> getTissue(int id) {
        return repository.findById(id);
    }
}
