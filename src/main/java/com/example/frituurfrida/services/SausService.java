package com.example.frituurfrida.services;

import com.example.frituurfrida.domain.Saus;
import com.example.frituurfrida.repositories.CSVSausRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SausService {
    private final CSVSausRepository csvSausRepository;

    public SausService(CSVSausRepository csvSausRepository) {
        this.csvSausRepository = csvSausRepository;
    }

    public List<Saus> findAll(){
        return csvSausRepository.findAll();
    }

    public List<Saus> findByBeginNaam(char letter){
        return csvSausRepository.findAll()
                .stream()
                .filter(saus -> saus.getNaam().startsWith(String.valueOf(letter)))
                .toList();
    }

    public Optional<Saus> findById(long id){
        return csvSausRepository.findAll().stream().filter(saus -> saus.getNummer() == id).findFirst();
    }
}
