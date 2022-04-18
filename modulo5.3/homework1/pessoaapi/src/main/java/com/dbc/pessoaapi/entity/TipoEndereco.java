package com.dbc.pessoaapi.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoEndereco {
    RESIDENCIAL(0),
    COMERCIAL(1);

    private Integer tipo;

    TipoEndereco(Integer tipo) {
        this.tipo = tipo;
    }

    @JsonValue
    public Integer getTipo() {
        return tipo;
    }

    public static TipoEndereco ofTipo(Integer tipo){
        return Arrays.stream(TipoEndereco.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
