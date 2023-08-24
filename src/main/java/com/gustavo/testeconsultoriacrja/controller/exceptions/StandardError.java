package com.gustavo.testeconsultoriacrja.controller.exceptions;

public class StandardError {
    
    private Long timestamp;
    private Integer status;
    private String erro;

    public StandardError(){

    }

    public StandardError(Long timestamp, Integer status, String erro) {
        this.timestamp = timestamp;
        this.status = status;
        this.erro = erro;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    
}
