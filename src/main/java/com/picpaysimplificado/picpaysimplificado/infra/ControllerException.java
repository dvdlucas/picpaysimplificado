package com.picpaysimplificado.picpaysimplificado.infra;

import javax.persistence.EntityNotFoundException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.picpaysimplificado.picpaysimplificado.dtos.ExceptionDTO;

@RestControllerAdvice
public class ControllerException {
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity threaEntityduplicateEntry(DataIntegrityViolationException exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Usuário já cadastrado", "400");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity threatGeneralException(Exception exception) {
        ExceptionDTO exceptionDTO = new ExceptionDTO("Internal Server Error  -> " + exception.getMessage(), "500");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
