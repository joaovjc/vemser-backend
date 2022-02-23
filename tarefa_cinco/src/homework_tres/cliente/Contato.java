package homework_tres.cliente;

public class Contato {
	
	private String descicao;
	private String numero;
	private int tipo;
	
	public Contato(String descicao, String numero, int tipo) {
		this.descicao = descicao;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	public void imprimirContato(){
		System.out.println(((this.tipo == 1)? "Residencial":((this.tipo == 2)?"Comercial":"Não preenchido Corretamente")) + ":");
		System.out.println(this.descicao + " " + numero);
	}

	public String getDescicao() {
		return descicao;
	}

	public void setDescicao(String descicao) {
		this.descicao = descicao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	
}
