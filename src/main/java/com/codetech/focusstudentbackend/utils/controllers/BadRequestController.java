package com.codetech.focusstudentbackend.utils.controllers;

import com.codetech.focusstudentbackend.utils.exceptions.NotFoundException;
import com.codetech.focusstudentbackend.utils.models.BaseErrorResponse;
import com.codetech.focusstudentbackend.utils.models.ErrorListResponse;
import com.codetech.focusstudentbackend.utils.models.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class BadRequestController {

    @ExceptionHandler(NotFoundException.class)
    public BaseErrorResponse handleIdNotFound(NotFoundException exception) {
        return ErrorResponse.builder()
                .message(exception.getMessage())
                .status(HttpStatus.BAD_REQUEST.name())
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseErrorResponse handleIdNotFound(MethodArgumentNotValidException exception) {

        var listErrors = new ArrayList<String>();
        exception.getAllErrors()
                .forEach(error -> listErrors.add(error.getDefaultMessage()));

        return ErrorListResponse.builder()
                .listErrors(listErrors)
                .status(HttpStatus.BAD_REQUEST.name())
                .errorCode(HttpStatus.BAD_REQUEST.value())
                .build();
    }
}
