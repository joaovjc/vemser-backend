package br.com.dbc.vemser.pessoaapi.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Endereco {

	private Integer id;
	private long idPessoa;
	@NotNull
	private String tipoEndereco;
	@NotEmpty
	@Max(250)
	private String logadouro;
	@NotEmpty
	private String numero;
	@NotEmpty
	@Max(8)
	private String cep;
	@NotEmpty
	@Max(250)
	private String cidade;
	@NotNull
	private String estado;
	@NotNull
	private String pais;
	
	public Endereco() {}
	
	
	public Endereco(Integer id, long idPessoa, @NotNull String tipoEndereco, @NotEmpty @Max(250) String logadouro,
			@NotEmpty String numero, @NotEmpty @Max(8) String cep, @NotEmpty @Max(250) String cidade,
			@NotNull String estado, @NotNull String pais) {
		this.id = id;
		this.idPessoa = idPessoa;
		this.tipoEndereco = tipoEndereco;
		this.logadouro = logadouro;
		this.numero = numero;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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

	public String getLogadouro() {
		return logadouro;
	}


	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}
	
}
