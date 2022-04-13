package com.dbc.kafkachat.Entity.enums;

public enum UsersEnum {
	ANA, EZEQUIAS, FLAVIO, FELIPE,
	GABRIEL, GUILHERME, GUSTAVO, JOAO,
	LUCAS, LUIZ, MAICON, NICOLAS, PABLO;

	public String getNome() {
		return this.toString().toLowerCase();
	}
}
