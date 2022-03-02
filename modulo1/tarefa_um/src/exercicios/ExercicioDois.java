package exercicios;

import java.util.Scanner;

public class ExercicioDois {
	
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);
		double[] notas = new double[4];
		
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Digite a "+ (i+1) +" nota:");
			notas[i] = s.nextDouble();
		}
		
		double media = (notas[0]+notas[1]+notas[2]+notas[3])/4;
		
		if (media <=5) {
			System.out.println("Reprovado");
		}else if(media >=5.1 && media <= 6.9) {
			System.out.println("Em Exame");
		}else {
			System.out.println("Aprovado");
		}
		
		s.close();
	}
}
