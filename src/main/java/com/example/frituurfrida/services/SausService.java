package com.example.frituurfrida.services;

import com.example.frituurfrida.domain.Saus;
import com.example.frituurfrida.exception.SausRepositoryException;
import com.example.frituurfrida.repositories.SausRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SausService {
    private final SausRepository[] sausRepositories;

    public SausService(SausRepository[] sausRepositories) {
        this.sausRepositories = sausRepositories;
    }

    public List<Saus> findAll(){
        Exception laatste = null;
        for(var repository : sausRepositories){
            try{
                return repository.findAll();
            } catch (SausRepositoryException e) {
                laatste = e;
            }
        }
        throw new SausRepositoryException("Kan de properties van de saus nergens lezen.", laatste);
    }

    public List<Saus> findByBeginNaam(char letter){
        Exception laatste = null;
        for(var repository : sausRepositories){
            try{
                return repository.findAll().stream().filter(saus -> saus.getNaam().startsWith(String.valueOf(letter))).toList();
            } catch (SausRepositoryException e) {
                laatste = e;
            }
        }
        throw new SausRepositoryException("Kan de properties van de saus nergens lezen.", laatste);
    }

    public Optional<Saus> findById(long id){
        Exception laatste = null;
        for(var repository : sausRepositories){
            try{
                return repository.findAll().stream().filter(saus -> saus.getNummer() == id).findFirst();
            } catch (SausRepositoryException e) {
                laatste = e;
            }
        }
        throw new SausRepositoryException("Kan de properties van de saus nergens lezen.", laatste);
    }
}
