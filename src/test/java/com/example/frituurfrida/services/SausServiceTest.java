package com.example.frituurfrida.services;

import com.example.frituurfrida.domain.Saus;
import com.example.frituurfrida.repositories.CSVSausRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class SausServiceTest {
    private SausService sst;

    @BeforeEach
    void beforeEach(){
        sst = new SausService(new CSVSausRepository());
    }

    @Test
    void findAll() {
        assertThat(sst.findAll()).hasOnlyElementsOfType(Saus.class);
    }
}