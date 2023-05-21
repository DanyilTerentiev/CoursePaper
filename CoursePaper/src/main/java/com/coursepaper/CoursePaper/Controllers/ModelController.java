package com.coursepaper.CoursePaper.Controllers;

import com.coursepaper.CoursePaper.DTOs.ModelDTO;
import com.coursepaper.CoursePaper.Entitities.Model;
import com.coursepaper.CoursePaper.Entitities.Order;
import com.coursepaper.CoursePaper.Entitities.Tissue;
import com.coursepaper.CoursePaper.Repositories.ModelService;
import com.coursepaper.CoursePaper.Repositories.TissueService;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/fashionStudio/models")
public class ModelController  {
    private final ModelService modelService;
    private final TissueService tissueService;
    @Autowired
    public ModelController(ModelService modelService, TissueService tissueService) {
        this.modelService = modelService;
        this.tissueService = tissueService;
    }

    @GetMapping(path = "{tissueId}")
    public Optional<List<Model>> getModels(@PathVariable("tissueId") int id) {
        return modelService.getAllModels(id);
    }

    @PostMapping(path = "{tissueId}")
    public ResponseEntity<?> addModel(@RequestBody ModelDTO modelDTO) {
        return modelService.addModel(modelDTO);
    }
}
