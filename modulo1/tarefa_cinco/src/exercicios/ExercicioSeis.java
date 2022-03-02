package exercicios;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ExercicioSeis {

	public static void main(String[] args) {
		List<Pessoa> pessoas = Arrays.asList(new Pessoa("joao", 20),new Pessoa("maria", 19),new Pessoa("maria", 17),new Pessoa("pedro", 17));
		
		pessoas.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
		
		pessoas.forEach(System.out::println);
		System.out.println("=============================");
		
		pessoas.sort((p1, p2) -> p2.getIdade() - p1.getIdade());
		
		pessoas.forEach(System.out::println);
		
		System.out.println("=============================");
		
//		pessoas.sort((p1, p2) -> 
//				(p1.getNome().equalsIgnoreCase(p2.getNome())
//				? p1.getIdade() - p2.getIdade() 
//				: p1.getNome().compareTo(p2.getNome())));
		
		
		pessoas.sort(new Comparator<Pessoa>() {
			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				if (o1.getNome().equalsIgnoreCase(o2.getNome())) {
					return o1.getIdade() - o2.getIdade();
				}else {
					return o1.getNome().compareTo(o2.getNome());
				}
			}
		});
		
		pessoas.forEach(System.out::println);
		
		
	}

}
