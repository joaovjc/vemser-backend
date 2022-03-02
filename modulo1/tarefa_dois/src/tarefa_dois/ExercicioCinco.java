package tarefa_dois;

import java.util.Random;

public class ExercicioCinco {
	public static void main(String[] args) {
		Random r = new Random();
		int[] valores = {r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100),
				r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100),
				r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100),
				r.nextInt(100), r.nextInt(100), r.nextInt(100)};
		
		for (int j = 0; j < valores.length; j++) {
			System.out.println("valor " + (j+1) + " é "+ valores[j]);
		}
		System.out.println("\nagora invertido\n");
		for (int i = (valores.length - 1); i >= 0; i--) {
			System.out.println(valores[i]);
			
		}
		
		
	}
}
