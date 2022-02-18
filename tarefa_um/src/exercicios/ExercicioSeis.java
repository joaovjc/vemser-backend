package exercicios;

import java.util.Scanner;

public class ExercicioSeis {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String palavra = s.nextLine().toLowerCase();
		
		switch (palavra) {
		
			case "cachorro", "dog" -> System.out.println(("dog".equals(palavra)?"Cachorro":"dog"));
			
			case "tempo", "time" -> System.out.println(("time".equals(palavra)?"Tempo":"Time"));
			
			case "amor", "love" -> System.out.println(("love".equals(palavra)?"Amor":"Love"));
			
			case "cidade", "city" -> System.out.println(("city".equals(palavra)?"Cidade":"City"));
			
			case "feliz", "happy" -> System.out.println(("happy".equals(palavra)?"Feliz":"Happy"));
			
			default -> System.out.println("Essa palavra não é válida.");
		
		}
		
		s.close();
	}
}
