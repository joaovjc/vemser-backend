package br.com.dbc.vemser.pessoaapi.entity;

import org.springframework.stereotype.Component;

@Component
public class Contato {
	
	private long id;
	private long idContato;
	private String tipoContato;
	private String numero;
	private String descricao;
	
	public Contato() {}
	
	public Contato(long id, long idContato, String tipoContato, String numero, String descricao) {
		super();
		this.id = id;
		this.idContato = idContato;
		this.tipoContato = tipoContato;
		this.numero = numero;
		this.descricao = descricao;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdContato() {
		return idContato;
	}
	public void setIdContato(long idContato) {
		this.idContato = idContato;
	}
	public String getTipoContato() {
		return tipoContato;
	}
	public void setTipoContato(String tipoContato) {
		this.tipoContato = tipoContato;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Contato [id=" + id + ", idContato=" + idContato + ", tipoContato=" + tipoContato + ", numero=" + numero
				+ ", descricao=" + descricao + "]";
	}	
}
