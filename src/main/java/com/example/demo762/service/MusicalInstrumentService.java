// MusicalInstrumentService.java
package com.example.demo762.service;

import com.example.demo762.entity.MusicalInstrument;
import com.example.demo762.repository.MusicalInstrumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicalInstrumentService {

    private final MusicalInstrumentRepository musicalInstrumentRepository;

    @Autowired
    public MusicalInstrumentService(MusicalInstrumentRepository musicalInstrumentRepository) {
        this.musicalInstrumentRepository = musicalInstrumentRepository;
    }

    public List<MusicalInstrument> getAllInstruments() {
        return musicalInstrumentRepository.findAll();
    }

    public MusicalInstrument getInstrumentById(Long id) {
        return musicalInstrumentRepository.findById(id).orElse(null);
    }

    public MusicalInstrument createInstrument(MusicalInstrument instrument) {
        return musicalInstrumentRepository.save(instrument);
    }

    public MusicalInstrument updateInstrument(Long id, MusicalInstrument updatedInstrument) {
        updatedInstrument.setId(id);
        return musicalInstrumentRepository.save(updatedInstrument);
    }

    public void deleteInstrument(Long id) {
        musicalInstrumentRepository.deleteById(id);
    }

    public List<MusicalInstrument> searchByFields(String searchTerm) {
        return musicalInstrumentRepository.searchByFields(searchTerm);
    }
    public MusicalInstrument searchByInstrument(String searchInstrument) {
        return musicalInstrumentRepository.searchByInstrument(searchInstrument);
    }

}
