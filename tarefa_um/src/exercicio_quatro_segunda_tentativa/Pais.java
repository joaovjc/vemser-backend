package exercicio_quatro_segunda_tentativa;

import java.util.ArrayList;

public class Pais {
	
	private ArrayList<Estado> estados;
	private String nome;
	
	public Pais(ArrayList<Estado> estados, String nome) {
		this.estados = estados;
		this.nome = nome;
	}
	public ArrayList<Estado> getEstados() {
		return estados;
	}
	public void setEstados(ArrayList<Estado> estados) {
		this.estados = estados;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estado acharEstado(String nomeEstado) {
		for (Estado estado : estados) if(estado.getNome().toLowerCase().contains(nomeEstado.toLowerCase()))return estado;
		return null;
	}
	
	@Override
	public String toString() {
		return nome;
	}
}
