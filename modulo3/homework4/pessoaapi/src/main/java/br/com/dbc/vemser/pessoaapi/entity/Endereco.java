package br.com.dbc.vemser.pessoaapi.entity;

import org.springframework.stereotype.Component;

@Component
public class Endereco {

	private long id;
	private long idPessoa;
	private String tipoEndereco;
	private String numero;
	private String descricao;
	
	public Endereco() {}
	
	public Endereco(long id, long idPessoa, String tipoEndereco, String numero, String descricao) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.tipoEndereco = tipoEndereco;
		this.numero = numero;
		this.descricao = descricao;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getIdPessoa() {
		return idPessoa;
	}
	public void setIdPessoa(long idPessoa) {
		this.idPessoa = idPessoa;
	}
	public String getTipoEndereco() {
		return tipoEndereco;
	}
	public void setTipoEndereco(String tipoEndereco) {
		this.tipoEndereco = tipoEndereco;
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
	
}
