package exercicio_quatro_segunda_tentativa;

public class Cidade {
	
	private String nome, area, populacao;
	
	public Cidade(String nome, String area,String populacao) {
		this.nome = nome;
		this.area = area;
		this.populacao = populacao;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getPopulacao() {
		return populacao;
	}

	public void setPopulacao(String populacao) {
		this.populacao = populacao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Cidade "+ nome+" [ area=" + area + ", populacao=" + populacao + "]";
	}
	
	
}
