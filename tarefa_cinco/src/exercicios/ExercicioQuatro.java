package exercicios;

import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class ExercicioQuatro {
	
	public static void main(String[] args) {
		Random r = new Random();
		ArrayList<Integer> num = new ArrayList<>();
		Stack<Integer> numeros = new Stack<>();
		
		for (int i = 0; i < 15; i++) {
			num.add(r.nextInt(100));
		}
		num.forEach(System.out::println);
		System.out.println("=============================");
		
		for (int j = 0; j < num.size(); j++) {
			System.out.println("O numero é " + num.get(j) + " e ele é "+ (((num.get(j)%2)==0)?"par": "impar"));
			if((num.get(j)%2)==0) {
				System.out.println("adicionado");
				numeros.push(num.get(j));
			}else {
				if (!numeros.isEmpty()) {
					System.out.println("removido o numero " + numeros.pop());
				}
			}
		}
		
		numeros.forEach(System.out::println);
	}
}
