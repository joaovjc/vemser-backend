package tarefa_tres;

public class Cliente {
	
	private String nome;
	private String cpf;
	private Contato[] contato = new Contato[2];
	private Endereco[] endereco = new Endereco[2];
	
	public Cliente(String nome, String cpf, Contato[] contato, Endereco[] endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.endereco = endereco;
	}

	public void imprimirContatos(){
		System.out.println("Contato 1: \n");
		contato[0].imprimirContato();
		System.out.println("Contato 2: \n");
		contato[1].imprimirContato();
	}
	public void imprimirEnderecos(){
		System.out.println("Endereço 1: \n");
		endereco[0].imprimirEndereco();
		System.out.println("Endereço 2: \n");
		endereco[1].imprimirEndereco();
	}
	public void imprimirCliente(){
		System.out.println("Nome: "+ nome
				+ "\nCPF: " + cpf);
	}
}
