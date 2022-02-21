package tarefa_tres;

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
}
