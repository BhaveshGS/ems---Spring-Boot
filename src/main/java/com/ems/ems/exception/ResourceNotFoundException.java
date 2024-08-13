package com.ems.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//incase employee id is not found
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String Message){
        super(Message); 
//When you call super(Message) in the constructor of ResourceNotFoundException,
//you are calling the constructor of the superclass (RuntimeException) 
//that takes a String parameter
    }
}
//heirarchy
// java.lang.Object
//    ↳ java.lang.Throwable
//    ↳ java.lang.Exception
//        ↳ java.lang.RuntimeException
//            ↳ ResourceNotFoundException
