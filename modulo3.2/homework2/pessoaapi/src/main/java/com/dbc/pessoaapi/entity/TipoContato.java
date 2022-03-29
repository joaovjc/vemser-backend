package com.dbc.pessoaapi.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoContato {
    RESIDENCIAL(0),
    COMERCIAL(1);

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }
    
    @JsonValue
    public Integer getTipo() {
        return tipo;
    }

    public static TipoContato ofTipo(Integer tipo){
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
