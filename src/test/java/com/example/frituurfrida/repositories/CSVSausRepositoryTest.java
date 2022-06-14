package com.example.frituurfrida.repositories;

import com.example.frituurfrida.domain.Saus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.InstanceOf;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CSVSausRepositoryTest {

    private CSVSausRepository csvsr;

    @BeforeEach
    void beforeEach(){
        csvsr = new CSVSausRepository();
    }
    @Test
    void erZittenEnkelObjectenVanSausInLijst(){
        assertThat(csvsr.findAll()).hasOnlyElementsOfType(Saus.class);
    }
}