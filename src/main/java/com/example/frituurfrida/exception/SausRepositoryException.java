package com.example.frituurfrida.exception;

public class SausRepositoryException extends RuntimeException{
    public SausRepositoryException(String message){
        super(message);
    }

    public  SausRepositoryException(String message, Exception oorzaak){
        super(message, oorzaak);
    }
}
