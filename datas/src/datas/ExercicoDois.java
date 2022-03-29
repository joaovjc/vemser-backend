package datas;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class ExercicoDois {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a data inicial: YYYY-MM-DD");
		LocalDate dataInicial = LocalDate.parse(sc.nextLine());
		System.out.println("Digite a data final: YYYY-MM-DD");
        LocalDate dataFinal = LocalDate.parse(sc.nextLine());
        Period periodoEntre = Period.between(dataInicial, dataFinal);
        System.out.println("O periodo entre essas datas é: "+periodoEntre);
        
        sc.close();
	}
}
