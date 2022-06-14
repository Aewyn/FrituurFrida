package com.example.frituurfrida.repositories;

import com.example.frituurfrida.domain.Saus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CSVSausRepositoryTest {

    private SausRepository csvsr;

    @BeforeEach
    void beforeEach(){
        csvsr = new CSVSausRepository();
    }
    @Test
    void erZittenEnkelObjectenVanSausInLijst(){
        assertThat(csvsr.findAll()).hasOnlyElementsOfType(Saus.class);
    }
}