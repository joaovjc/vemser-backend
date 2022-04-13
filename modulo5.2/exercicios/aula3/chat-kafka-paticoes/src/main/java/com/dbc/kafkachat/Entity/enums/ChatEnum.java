package com.dbc.kafkachat.Entity.enums;

public enum ChatEnum {
	GERAL, PRIVATE;

	public String getNome() {
		return this.toString().toLowerCase();
	}
}
