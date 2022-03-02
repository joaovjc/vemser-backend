package exercicio_quatro_segunda_tentativa;

import java.util.ArrayList;

public class Estado {
	
	private ArrayList<Cidade> cidades;
	private String nome;

	public Estado(ArrayList<Cidade> cidades, String nome) {
		this.cidades = cidades;
		this.nome = nome;
	}
	
	public ArrayList<Cidade> getCidades() {
		return cidades;
	}

	public void addCidade(Cidade cidades) {
		this.cidades.add(cidades);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cidade acharCidade(String nomeCidade) {
		for (Cidade cidade : cidades) if(cidade.getNome().toLowerCase().contains(nomeCidade.toLowerCase()))return cidade;
		return null;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
