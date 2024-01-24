// MusicalInstrumentRepository.java
package com.example.demo762.repository;

import com.example.demo762.entity.MusicalInstrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MusicalInstrumentRepository extends JpaRepository<MusicalInstrument, Long> {

    @Query("SELECT r FROM MusicalInstrument r " +
            "WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR LOWER(r.material) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
            "OR CAST(r.amount AS string) LIKE CONCAT('%', :searchTerm, '%')")
    List<MusicalInstrument> searchByFields(@Param("searchTerm") String searchTerm);
    @Query("SELECT r FROM MusicalInstrument r " +
            "WHERE LOWER(r.material) LIKE LOWER(CONCAT('%', :searchInstrument, '%')) ")
    MusicalInstrument searchByInstrument(@Param("searchInstrument") String searchInstrument);
}
