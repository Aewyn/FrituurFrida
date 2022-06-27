package com.example.frituurfrida.services;

import com.example.frituurfrida.domain.Snack;
import com.example.frituurfrida.repositories.SnackRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SnackService {
    private final SnackRepository snackRepository;

    public SnackService(SnackRepository snackRepository) {
        this.snackRepository = snackRepository;
    }

    public Optional<Snack> read(long id){
        return snackRepository.read(id);
    }

    public void update(Snack snack){
        snackRepository.update(snack);
    }

    public List<Snack> findByBeginNaam(String beginNaam){
        return snackRepository.findByBeginNaam(beginNaam);
    }
}
