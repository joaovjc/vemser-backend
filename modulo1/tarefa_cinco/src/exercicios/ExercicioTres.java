package exercicios;

import java.util.LinkedList;
import java.util.Queue;

public class ExercicioTres {
	public static void main(String[] args) {

		Queue<Integer> filaPessoas = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			filaPessoas.add(i+1);
		}
		
		System.out.println("Proximo numero: "+filaPessoas.poll());
		System.out.println("Proximo numero: "+filaPessoas.poll());
		System.out.println("Proximo numero: "+filaPessoas.poll());
		
		filaPessoas.add(6);
		filaPessoas.add(7);
		filaPessoas.add(8);
		
		System.out.println("Proximo numero: "+filaPessoas.poll());
		System.out.println("Proximo numero: "+filaPessoas.poll());
		System.out.println("Proximo numero: "+filaPessoas.poll());
		System.out.println("numeros Restantes: ");
		filaPessoas.forEach(System.out::println);
		
	}
}
