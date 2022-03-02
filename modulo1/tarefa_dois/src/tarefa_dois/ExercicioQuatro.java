package tarefa_dois;

import java.util.Scanner;

public class ExercicioQuatro {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] numeros = new int[3];
		System.out.println("digite Três numeros");
		numeros[0] = s.nextInt();
		numeros[1] = s.nextInt();
		numeros[2] = s.nextInt();
		
		if (numeros[0] < numeros[1] && numeros[0] < numeros[2]) {
			System.out.println("o menor numero é " + numeros[0]);
		}else if(numeros[1] < numeros[2]){
			System.out.println("o menor numero é " + numeros[1]);
		}else {
			System.out.println("o menor numero é " + numeros[3]);
		}
		
//		ou
		
//		System.out.println("o menor numero é");
//		System.out.println((numeros[0]<numeros[1])?(numeros[0]<numeros[2]?numeros[0]:numeros[2]):(numeros[1]<numeros[2]?numeros[1]:numeros[2]));
		s.close();
	}
	
}
