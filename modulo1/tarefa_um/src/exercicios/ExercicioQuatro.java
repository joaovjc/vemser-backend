package exercicios;

import java.util.Scanner;

public class ExercicioQuatro {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Escolha um estado: ");
		System.out.println("Rio Grande do Sul ou RS"
				+ "Rio Grande do Norte ou RN"
				+ "P�o Paulo ou SP");
		
		switch (s.nextLine().toLowerCase()) {
			case "rio grande do sul", "rs" ->{
				
				System.out.println("Escolha uma cidade: "
						+ "Porto Alegre"
						+ "Erechim");
				
				switch (s.nextLine().toLowerCase()) {
				
					case "porto alegre" -> System.out.println("�rea: 496,8 km�\r\n"
							+ "Prefeito: Sebasti�o Melo\r\n"
							+ "Popula��o metropolitana: 4.405.769 ");
					
					case "erechim" -> System.out.println("�rea: 430.764 km�\r\n"
							+ "Eleva��o: 783 m\r\n"
							+ "Popula��o: 106.633");
					
					default -> throw new IllegalArgumentException("Esta Cidade N�o foi adicionada ainda");
				
				}
			
			}
			
			case "rio grande do norte", "rn" ->{ 
				System.out.println("Escolha uma cidade: "
						+ "Natal"
						+ "Macau");
				switch (s.nextLine().toLowerCase()) {
				
					case "natal" -> System.out.println("�rea: 169,3 km�\r\n"
							+ "Popula��o: 890.480 (2020)\r\n"
							+ "Prefeito: �lvaro Costa Dias");
					
					case "macau" -> System.out.println("�rea: 775.302 km�\r\n"
							+ "Popula��o total (est. IBGE/2021): 32 260 hab\r\n"
							+ "Prefeito(a): Jos� Ant�nio de Menezes Sousa");
					
					default -> throw new IllegalArgumentException("Esta Cidade N�o foi adicionada ainda");
				
				}
				
				
			}
			
			case "s�o paulo", "sao paulo", "sp" ->{ 
				System.out.println("Escolha uma cidade: "
						+ "Campinas"
						+ "S�o Bernardo do Campo");
				
				switch (s.nextLine().toLowerCase()) {
				
					case "campinas" -> System.out.println("�rea: 795,7 km�\r\n"
							+ "Funda��o: 14 de julho de 1774\r\n"
							+ "Popula��o metropolitana: 3.656.363");
					
					case "s�o bernardo do campo", "sao bernardo do campo" -> System.out.println("Eleva��o: 762 m\r\n"
							+ "�rea: 409,5 km�\r\n"
							+ "Popula��o: 844.483 (2020)");
					
					default -> throw new IllegalArgumentException("Esta Cidade N�o foi adicionada ainda");
				}
			}
			
			default ->
			throw new IllegalArgumentException("Ainda n�o adicionamos este estado");
		}
		s.close();
	}
	
}
