package com.example.frituurfrida.repositories;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class PropertiesSausRepositoryTest {
    private PropertiesSausRepository psr;

    @BeforeEach void beforeEach(){
        psr = new PropertiesSausRepository();
    }

    @Test
    void findAll() {
        assertThat(psr.findAll()).isNotNull();
    }
}