package tarefa_dois;

import java.util.Random;
import java.util.Scanner;

public class ExercicioSete {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int[][] valores = {{r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100)}, {r.nextInt(100),
				r.nextInt(100), r.nextInt(100), r.nextInt(100)}, {r.nextInt(100), r.nextInt(100), 
				r.nextInt(100), r.nextInt(100)}, {r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100)}};
		System.out.println("os valores maiores que dez gerados automaticamente são: ");
		int f = 0;
		for (int i = 0; i < valores.length; i++) {
			for (int j = 0; j < valores.length; j++) {
				if (valores[i][j] > 10) {
					System.out.println(valores[i][j]);
					f++;
				}
			}
		}
		System.out.println("Totalizando " + f + " números");
		s.close();
	}
}
