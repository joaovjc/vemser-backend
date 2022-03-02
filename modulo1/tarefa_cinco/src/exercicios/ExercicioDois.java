package exercicios;

import java.util.ArrayList;
import java.util.Scanner;

public class ExercicioDois {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); 
		ArrayList<String> nomes = new ArrayList<>();
		String str = "";
		do {
			
			System.out.println("Digite um nome: ");
			
			str = s.nextLine();
			
			if(str.equalsIgnoreCase("sair"))break;
			
			nomes.add(str);
			
		}while(true);
		
		System.out.println("Penultimo nome: ");
		System.out.println(( nomes.size()>=2 )
				?( nomes.get(nomes.size()-2 ) )
				:( !nomes.isEmpty() )
					? nomes.get(0)
					: "ArraysList vazio");
		
		System.out.println("Primeiro nome: ");
		System.out.println(( !nomes.isEmpty() )
				? nomes.get(0)
				: "ArraysList vazio");
		
		System.out.println("ultimo nome: ");
		System.out.println(( !nomes.isEmpty() )
				? nomes.remove(nomes.size()-1)
				: "ArraysList vazio");
		
		System.out.println("Tem "+nomes.size()+ " nomes");
		
		System.out.println("Todos os nomes: ");
		nomes.forEach(System.out::println);
		
		s.close();
	}
}
