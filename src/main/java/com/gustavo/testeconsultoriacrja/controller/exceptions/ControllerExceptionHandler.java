package com.gustavo.testeconsultoriacrja.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gustavo.testeconsultoriacrja.exceptions.ObjectNotFoundException;
import com.gustavo.testeconsultoriacrja.utils.Erro;

@ControllerAdvice
public class ControllerExceptionHandler {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validacaoRequest(MethodArgumentNotValidException e){
        ValidationError erros = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(),
                Erro.ERRO_VALIDACAO_CAMPOS.getDescricao());

        for(FieldError f : e.getBindingResult().getFieldErrors()){
            erros.addErros(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> validacaoRequest(ObjectNotFoundException e){
        ValidationError error = new ValidationError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
                e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
