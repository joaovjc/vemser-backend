package tarefa_tres;

public class Contato {
	
	private String descicao;
	private String numero;
	
	public Contato(String descicao, String numero) {
		this.descicao = descicao;
		this.numero = numero;
	}
	
	public void imprimirContato(){
		System.out.println(this.descicao + " " + numero);
	}
}
