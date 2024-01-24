package com.example.demo762.instrument;
import com.example.demo762.entity.MusicalInstrument;
import com.example.demo762.repository.MusicalInstrumentRepository;
import com.example.demo762.service.MusicalInstrumentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @InjectMocks
    private MusicalInstrumentService musicalInstrumentService;

    @Mock
    private MusicalInstrumentRepository musicalInstrumentRepository;

    @Test
    void searchByInstrument() {
        MusicalInstrument instrument = new MusicalInstrument("domra","derevo", 1);
        Mockito.when(musicalInstrumentRepository.searchByInstrument("domra")).thenReturn(instrument);

        MusicalInstrument instrument1 = musicalInstrumentService.searchByInstrument("domra");

        Assertions.assertEquals(instrument.getName(),instrument1.getName() );
    }

    @Test
    void searchByFields() {
        MusicalInstrument instrument = new MusicalInstrument("fleita", "zhelso", 1);

        Mockito.when(musicalInstrumentRepository.searchByFields("%zh%")).thenReturn(List.of(instrument));

        List<MusicalInstrument> instrument1 = musicalInstrumentService.searchByFields("%e%");

        Assertions.assertEquals(instrument.getId(), instrument1.get(0).getId());
        Assertions.assertEquals(instrument.getName(), instrument1.get(0).getName());
        Assertions.assertEquals(instrument.getMaterial(), instrument1.get(0).getMaterial());
        Assertions.assertEquals(instrument.getAmount(), instrument1.get(0).getAmount());
    }

}
