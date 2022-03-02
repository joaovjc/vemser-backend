package exercicios;

import java.util.Scanner;

public class ExercicioCinco {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		double b, a, c, d;
		System.out.println("valor da hora em R$: ");
		a= s.nextDouble();
		System.out.println("número de horas normais trabalhas: ");
		b= s.nextDouble();
		System.out.println("número de horas extras 50%: ");
		c= s.nextDouble();
		System.out.println("número de horas extras 100%");
		d= s.nextDouble();
		
		System.out.println("O salario bruto total é " + ((b * a) + (c * a * 1.5) + (d * a * 2)));
		s.close();
	}
	
}
