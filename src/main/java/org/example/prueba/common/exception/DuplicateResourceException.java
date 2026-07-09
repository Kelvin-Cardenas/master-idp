package org.example.prueba.common.exception;

public class DuplicateResourceException  extends RuntimeException{
    public DuplicateResourceException(String message){
        super(message);
    }
}
