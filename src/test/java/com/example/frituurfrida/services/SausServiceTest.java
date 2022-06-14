package com.example.frituurfrida.services;

import com.example.frituurfrida.domain.Saus;
import com.example.frituurfrida.repositories.CSVSausRepository;
import com.example.frituurfrida.repositories.PropertiesSausRepository;
import com.example.frituurfrida.repositories.SausRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SausServiceTest {
    private SausService sausService;

    @Mock
    private SausRepository sausRepository;

    @BeforeEach
    void beforeEach() {
        sausService = new SausService(new SausRepository[]{sausRepository});
    }

    @Test
    void findAll() {
        when(sausRepository.findAll()).thenReturn(
                List.of(
                        new Saus(1, "cocktail", new String[]{"mayonaise", " ketchup", "cognac"}),
                        new Saus(2, "mayonaise", new String[]{"ei", "mosterd"})
                )
        );
        assertThat(sausService.findAll()).isNotNull();
        verify(sausRepository).findAll();
    }
}