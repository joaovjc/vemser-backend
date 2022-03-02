package exercicio_quatro_segunda_tentativa;

import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioQuatroTentativaDois {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		
		ArrayList<Estado> b = new ArrayList<>();
		ArrayList<Cidade> c = new ArrayList<>();
		c.add(new Cidade("Erechim"," �rea: 430.764 km�", "Popula��o: 106.633"));
		c.add(new Cidade("Porto Alegre"," �rea: 496,8 km�"," Popula��o metropolitana: 4.405.769 "));
		b.add(new Estado(c,"Rio Grande do Sul"));
		ArrayList<Cidade> d = new ArrayList<>();
		d.add(new Cidade("Natal","169,3 km�", "890.480 (2020)"));
		d.add(new Cidade("Macau", "775.302 km�", "32.260"));
		b.add(new Estado(d,"Rio Grande do Norte"));
		ArrayList<Cidade> e = new ArrayList<>();
		e.add(new Cidade("Campinas","795,7 km�", " 3.656.363"));
		e.add(new Cidade("S�o Bernardo do Campo", "409,5 km�", "844.483 (2020)"));
		b.add(new Estado(e,"S�o Paulo"));
		Pais brasil = new Pais(b, "Brasil");
		
		System.out.println("Escolha um estado dentre as op��es: ");
		brasil.getEstados().forEach(System.out::println);
		Estado estado = brasil.acharEstado(s.nextLine());
		System.out.println("Escolha uma das cidades deste estado: ");
		estado.getCidades().forEach(es -> System.out.println(es.getNome()));
		System.out.println(estado.acharCidade(s.nextLine()));
		
		s.close();
	}
	
}
