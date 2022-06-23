package com.example.frituurfrida.exception;

import com.example.frituurfrida.domain.Snack;
import com.example.frituurfrida.repositories.SnackRepository;

public class SnackRepositoryException extends RuntimeException{
    public SnackRepositoryException(String msg){
        super(msg);
    }
    public SnackRepositoryException(String msg, Exception ex){
        super(msg, ex);
    }
}
