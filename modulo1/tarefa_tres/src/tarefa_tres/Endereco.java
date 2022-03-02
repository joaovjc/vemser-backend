package tarefa_tres;

public class Endereco {
	
	private String logadouro;
	private String complemento;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	private int tipo;
	private int numero;
	
	public Endereco(String logadouro, String complemento, String cep, String cidade, 
			String estado, String pais, int tipo, int numero) {
		this.logadouro = logadouro;
		this.complemento = complemento;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
		this.pais = pais;
		this.tipo = tipo;
		this.numero = numero;
	}
	
	public void imprimirEndereco() {
		System.out.println("Endereço " + ((tipo == 1)?"Residencial:\n":"Comercial:\n") + this.logadouro + " "+ this.complemento+ ", " + 
	this.numero + " - " + this.cidade + ", " + this.estado + ", " + this.pais+ ", " + this.cep);
	}

	public String getLogadouro() {
		return logadouro;
	}

	public void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
}
