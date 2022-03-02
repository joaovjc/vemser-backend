package tarefa_tres;

public class Cliente {
	
	private String nome;
	private String cpf;
	private Contato[] contato;
	private Endereco[] endereco;
	
	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Contato[] getContato() {
		return contato;
	}

	public void setContato(Contato[] contato) {
		if (contato.length == 2) {
			this.contato = contato;
		}else {
			System.err.println("maior ou menor que dois contatos");
		}
	}

	public Endereco[] getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco[] endereco) {
		this.endereco = endereco;
	}

	
	
}
