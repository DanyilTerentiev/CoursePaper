package com.coursepaper.CoursePaper.Controllers;

import com.coursepaper.CoursePaper.Entitities.Tissue;
import com.coursepaper.CoursePaper.Repositories.ITissueRepository;
import com.coursepaper.CoursePaper.Repositories.TissueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/fashionStudio/tissues")
public class TissueController extends BaseController {
    private final TissueService service;
    @Autowired
    public TissueController(TissueService service) {
        this.service = service;
    }
    @GetMapping
    public List<Tissue> getTissues() {
        return service.getTissues();
    }
    @PostMapping
    public void addTissue(@RequestBody Tissue tissue) {
        service.addTissue(tissue);
    }
    @DeleteMapping(path = "{tissueId}")
    public void deleteTissue(@PathVariable("tissueId") int id) {
        service.deleteTissue(id);
    }

    @PutMapping
    public void updateTissue(@RequestBody Tissue tissue) {
        service.updateTissue(tissue);
    }
}
