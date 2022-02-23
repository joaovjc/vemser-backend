package homework_tres.cliente;

import java.util.ArrayList;

public class Cliente {
	
	private String nome;
	private String cpf;
	private ArrayList<Contato> contato = new ArrayList<>();
	private ArrayList<Endereco> endereco= new ArrayList<>();
	
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

	public ArrayList<Contato> getContato() {
		return contato;
	}

	public void setContato(ArrayList<Contato> contato) {
		this.contato = contato;
	}

	public ArrayList<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(ArrayList<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	public void addEndereco(Endereco endereco) {
		this.endereco.add(endereco);
	}
	
	public void addContato(Contato contato) {
		this.contato.add(contato);
	}
}
