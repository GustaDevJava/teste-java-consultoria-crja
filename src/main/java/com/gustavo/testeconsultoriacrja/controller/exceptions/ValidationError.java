package com.gustavo.testeconsultoriacrja.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
    
    private List<FielMessade> erros = new ArrayList<>();

    public ValidationError(){

    }

    public ValidationError(Long timestamp, Integer status, String erro) {
        super(timestamp, status, erro);
    }

    public List<FielMessade> getErros() {
        return erros;
    }

    public void addErros(String fielName, String mesage) {
        this.erros.add(new FielMessade(fielName, mesage));
    }
}
