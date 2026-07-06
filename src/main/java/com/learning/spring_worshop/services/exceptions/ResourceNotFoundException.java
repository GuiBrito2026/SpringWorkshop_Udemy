package com.learning.spring_worshop.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id){
        super("error not found. id "+ id);
    }
}
