// MusicalInstrumentController.java
package com.example.demo762.controller;

import com.example.demo762.entity.MusicalInstrument;
import com.example.demo762.service.MusicalInstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class MusicalInstrumentController {

    private final MusicalInstrumentService musicalInstrumentService;

    @Autowired
    public MusicalInstrumentController(MusicalInstrumentService musicalInstrumentService) {
        this.musicalInstrumentService = musicalInstrumentService;
    }

    @GetMapping
    public List<MusicalInstrument> getAllInstruments() {
        return musicalInstrumentService.getAllInstruments();
    }

    @GetMapping("/{id}")
    public MusicalInstrument getInstrumentById(@PathVariable Long id) {
        return musicalInstrumentService.getInstrumentById(id);
    }

    @PostMapping
    public MusicalInstrument createInstrument(@RequestBody MusicalInstrument instrument) {
        return musicalInstrumentService.createInstrument(instrument);
    }

    @PutMapping("/{id}")
    public MusicalInstrument updateInstrument(@PathVariable Long id, @RequestBody MusicalInstrument updatedInstrument) {
        return musicalInstrumentService.updateInstrument(id, updatedInstrument);
    }

    @DeleteMapping("/{id}")
    public void deleteInstrument(@PathVariable Long id) {
        musicalInstrumentService.deleteInstrument(id);
    }

    @GetMapping("/search")
    public List<MusicalInstrument> searchByFields(@RequestParam(name = "searchTerm") String searchTerm) {
        return musicalInstrumentService.searchByFields(searchTerm);
    }

    @GetMapping("/search/material")
    public MusicalInstrument searchByInstrument(@RequestParam(name = "searchInstrument") String searchInstrument) {
        return musicalInstrumentService.searchByInstrument(searchInstrument);
    }
}
