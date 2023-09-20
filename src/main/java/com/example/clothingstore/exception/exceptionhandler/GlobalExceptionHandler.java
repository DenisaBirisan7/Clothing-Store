package com.example.clothingstore.exception.exceptionhandler;

import com.example.clothingstore.exception.InternalServerErrorException;
import com.example.clothingstore.exception.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> resourceNotFoundException(NotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);  //404

    }

    //You can add how many exception handlers you need for any different custom exceptions

    @ExceptionHandler(InternalServerErrorException.class)
    public ResponseEntity<String> handleInternalServerErrorException(InternalServerErrorException exp){
        return new ResponseEntity<>(exp.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);  //500
    }
}
