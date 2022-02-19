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
}
