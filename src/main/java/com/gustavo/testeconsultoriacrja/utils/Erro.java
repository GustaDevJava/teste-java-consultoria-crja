package com.gustavo.testeconsultoriacrja.utils;

public enum Erro {
    
    ERRO_VALIDACAO_CAMPOS("Erro na validação de campos!");

    private String descricao;

    Erro(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }
}
