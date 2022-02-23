package exercicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExercicioCinco {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Map<String, String> pessoaCpf = new HashMap<>();
		pessoaCpf.put("12345678910", "João Victor");
		pessoaCpf.put("01987654321", "Maria");
		pessoaCpf.put("98745632198", "Pedro");
		System.out.println("Digite um CPF");
		String str = s.nextLine();
		System.out.println();
		if (pessoaCpf.containsKey(str)) {
			System.out.println(pessoaCpf.get(str));
			pessoaCpf.remove(str);
		}
		
		pessoaCpf.forEach((s1, s2) -> System.out.println(s1 + " " + s2));
		
		s.close();
	}

}
