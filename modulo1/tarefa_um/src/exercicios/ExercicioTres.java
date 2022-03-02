package exercicios;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExercicioTres {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		BigDecimal valorTotal, valorPago;
		
		System.out.println("Digite o valor total:");
		valorTotal = new BigDecimal(s.nextDouble());
		System.out.println("Digite o valor pago:");
		valorPago = new BigDecimal(s.nextDouble());
		
		System.out.println((valorTotal.compareTo(valorPago) == 1)?"O valor pago deve ser maior ou igual ao valor consumido" 
				: ("o troco total é "+ (valorPago.subtract(valorTotal).toString())));
		s.close();
	}

}
