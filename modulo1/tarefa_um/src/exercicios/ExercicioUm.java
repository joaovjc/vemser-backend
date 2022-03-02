package exercicios;

import java.util.Scanner;

public class ExercicioUm {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		String nome, cidade, estado;
		int idade;
		
		System.out.println("Insira seu nome: ");
		nome = s.nextLine();
		
		System.out.println("Insira sua cidade: ");
		cidade = s.nextLine();
		
		System.out.println("Insira seu estado: ");
		estado = s.nextLine();
		
		System.out.println("Insira sua idade: ");
		idade = s.nextInt();
		
		System.out.println("Olá seu nome é " +nome+", você tem "+ idade +" anos, é da cidade de "+cidade+", situada\r\n"
				+ "no estado " +estado);
		s.close();
	}
}
