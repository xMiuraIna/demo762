package com.example.demo762.instrument;

import com.example.demo762.controller.MusicalInstrumentController;
import com.example.demo762.repository.MusicalInstrumentRepository;
import com.example.demo762.service.MusicalInstrumentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MusicalInstrumentController.class)
public class ControllerTest {

        @MockBean
        private MusicalInstrumentService productService;


        @MockBean
        private MusicalInstrumentRepository productRepository;


        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private ObjectMapper objectMapper;



        @Test
        void getProduct() throws Exception {
            mockMvc.perform(get("/api/instrument/1")).andExpect(status().isOk());
        }


}
