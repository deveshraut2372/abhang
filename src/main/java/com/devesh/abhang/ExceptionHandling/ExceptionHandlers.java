package com.devesh.abhang.ExceptionHandling;

import com.devesh.abhang.ExceptionHandling.Exceptions.ResourceNotFound;
import com.devesh.abhang.ExceptionHandling.Exceptions.UnauthorizeAccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
//ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(value = ResourceNotFound.class)
    public ResponseEntity<ExceptionRes> resourceNotFound(ResourceNotFound resourceNotFound, WebRequest request)
    {
        return new ResponseEntity<>( new ExceptionRes(resourceNotFound.getMessage(),"RESOURCE_NOT_FOUND", LocalDateTime.now(),request.getDescription(false)), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = UnauthorizeAccess.class)
    public ResponseEntity<ExceptionRes> unauthorizeAccess (UnauthorizeAccess unauthorizeAccess,WebRequest request)
    {
        return new ResponseEntity<>(new ExceptionRes(unauthorizeAccess.getMessage(),"UNAUTHORIZED ACCESS",LocalDateTime.now(),request.getDescription(false)),HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = NullPointerException.class)
    public ResponseEntity<ExceptionRes> unauthorizeAccess (NullPointerException nullPointerException, WebRequest request)
    {
        return new ResponseEntity<>( new ExceptionRes(nullPointerException.getMessage(),"NULL POINTER EXCEPTION ",LocalDateTime.now(),request.getDescription(false)),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionRes> Exception(Exception e,WebRequest request)
    {
        return new ResponseEntity<>( new ExceptionRes(e.getMessage(),"INTERNAL_SERVER_ERROR",LocalDateTime.now(),request.getDescription(false)),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
