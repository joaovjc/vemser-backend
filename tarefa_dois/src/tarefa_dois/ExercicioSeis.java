package tarefa_dois;

import java.util.Random;
import java.util.Scanner;

public class ExercicioSeis {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int[] valores = {r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100),
			r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100), r.nextInt(100)};
		System.out.println("Digite um numero: ");
		
		for (int j : valores) {
			System.out.println(j);
		}
		
		int numero = s.nextInt();
		
		
		
		for (int i = 0; i < valores.length; i++) {
			if(valores[i] == numero) {
				System.out.println("O numero "+ numero +" existe nesse vetor");
				s.close();
				return;
			}else if(i == (valores.length - 1)){
				System.out.println("não existe, nesse vetor, o numero digitado!!");
			}
		}
		s.close();
	}
}
