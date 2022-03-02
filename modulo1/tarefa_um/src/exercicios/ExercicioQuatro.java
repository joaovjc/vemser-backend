package exercicios;

import java.util.Scanner;

public class ExercicioQuatro {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Escolha um estado: ");
		System.out.println("Rio Grande do Sul ou RS"
				+ "Rio Grande do Norte ou RN"
				+ "Pão Paulo ou SP");
		
		switch (s.nextLine().toLowerCase()) {
			case "rio grande do sul", "rs" ->{
				
				System.out.println("Escolha uma cidade: "
						+ "Porto Alegre"
						+ "Erechim");
				
				switch (s.nextLine().toLowerCase()) {
				
					case "porto alegre" -> System.out.println("Área: 496,8 km²\r\n"
							+ "Prefeito: Sebastião Melo\r\n"
							+ "População metropolitana: 4.405.769 ");
					
					case "erechim" -> System.out.println("Área: 430.764 km²\r\n"
							+ "Elevação: 783 m\r\n"
							+ "População: 106.633");
					
					default -> throw new IllegalArgumentException("Esta Cidade Não foi adicionada ainda");
				
				}
			
			}
			
			case "rio grande do norte", "rn" ->{ 
				System.out.println("Escolha uma cidade: "
						+ "Natal"
						+ "Macau");
				switch (s.nextLine().toLowerCase()) {
				
					case "natal" -> System.out.println("Área: 169,3 km²\r\n"
							+ "População: 890.480 (2020)\r\n"
							+ "Prefeito: Álvaro Costa Dias");
					
					case "macau" -> System.out.println("Área: 775.302 km²\r\n"
							+ "População total (est. IBGE/2021): 32 260 hab\r\n"
							+ "Prefeito(a): José Antônio de Menezes Sousa");
					
					default -> throw new IllegalArgumentException("Esta Cidade Não foi adicionada ainda");
				
				}
				
				
			}
			
			case "são paulo", "sao paulo", "sp" ->{ 
				System.out.println("Escolha uma cidade: "
						+ "Campinas"
						+ "São Bernardo do Campo");
				
				switch (s.nextLine().toLowerCase()) {
				
					case "campinas" -> System.out.println("Área: 795,7 km²\r\n"
							+ "Fundação: 14 de julho de 1774\r\n"
							+ "População metropolitana: 3.656.363");
					
					case "são bernardo do campo", "sao bernardo do campo" -> System.out.println("Elevação: 762 m\r\n"
							+ "Área: 409,5 km²\r\n"
							+ "População: 844.483 (2020)");
					
					default -> throw new IllegalArgumentException("Esta Cidade Não foi adicionada ainda");
				}
			}
			
			default ->
			throw new IllegalArgumentException("Ainda não adicionamos este estado");
		}
		s.close();
	}
	
}
