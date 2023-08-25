package com.gustavo.testeconsultoriacrja.dtos;

import java.io.Serializable;

public class PessoaMediaHorasDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String media;

    public PessoaMediaHorasDTO(){}

    public PessoaMediaHorasDTO(String media) {
        this.media = media;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    
    
}
