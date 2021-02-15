package com.quasar.fire.rebellion.controllers;

import com.quasar.fire.rebellion.dto.responses.ErrorResponse;
import com.quasar.fire.rebellion.exceptions.MessageException;
import com.quasar.fire.rebellion.exceptions.TrilaterationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);

    @ExceptionHandler(value = {TrilaterationException.class})
    public ResponseEntity<ErrorResponse> handleTrilaterationException(TrilaterationException ex){
        logger.error("A request was met with the TrilaterationException: " + ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MessageException.class})
    public ResponseEntity<ErrorResponse> handleMessageException(MessageException ex){
        logger.error("A request was met with the MessageException: " + ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse(ex.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex){
        ObjectError err = ex.getBindingResult().getAllErrors().get(0);
        logger.error("A request was met with the Client Exception: " + err.getDefaultMessage());
        return new ResponseEntity<>(new ErrorResponse(err.getDefaultMessage()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<ErrorResponse> handleValidationException(HttpMessageNotReadableException ex){
        logger.error("A request was met with the Client Exception: " + ex.getMessage());
        return new ResponseEntity<>(new ErrorResponse("Invalid JSON format"),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<HttpStatus> handleException(Exception ex){
        logger.error("A request was met with an unknown exception: " + ex.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}