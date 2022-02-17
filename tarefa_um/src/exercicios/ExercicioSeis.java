package exercicios;

import java.util.Scanner;

public class ExercicioSeis {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		switch (s.nextLine().toLowerCase()) {
		case "cachorro" -> System.out.println("Dog");
		case "tempo" -> System.out.println("Time");
		case "amor" -> System.out.println("Love");
		case "cidade" -> System.out.println("City");
		case "feliz" -> System.out.println("Happy");
		default -> System.out.println("Essa palavra não é válida.");
		}
		s.close();
	}
}
