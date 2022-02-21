package tarefa_tres;

public class Cliente {
	
	private String nome;
	private String cpf;
	private Contato[] contato;
	private Endereco[] endereco;
	
	public Cliente(String nome, String cpf, Contato[] contato, Endereco[] endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.contato = contato;
		this.endereco = endereco;
	}

	public void imprimirContatos(){
		for (Contato contatos : contato) {
			if (contatos != null) {
				contatos.imprimirContato();
				System.out.println();
			}
		}
	}
	public void imprimirEnderecos(){
		for (Endereco enderecos: endereco) {
			if (enderecos != null) {
				enderecos.imprimirEndereco();
				System.out.println();
			}
		}
	}
	public void imprimirCliente(){
		System.out.println("Nome: "+ nome
				+ "\nCPF: " + cpf);
	}

	public String getNome() {
		return nome;
	}
	
}
