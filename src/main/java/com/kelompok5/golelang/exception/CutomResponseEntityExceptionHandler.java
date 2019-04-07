package com.kelompok5.golelang.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CutomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handlerUserNameException(
        UserNameException exception, WebRequest request
    ) {
        UserNameExceptionResponse response = new UserNameExceptionResponse(exception.getMessage());
        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }
}
