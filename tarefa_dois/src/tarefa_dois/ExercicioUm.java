package tarefa_dois;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExercicioUm {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		
		String nomeProduto;
		BigDecimal valor;	
		
		System.out.println("Digite o nome do produto: ");
		nomeProduto = s.nextLine();
		String str = "";
		// colocando uma delimitação no que pode ser digitado, 
		//  no caso delimit6ando o uso de numeros de 0 a 9 e um . opicional
		Pattern p = Pattern.compile("^[0-9]*\\.?[0-9]+$");
		// ps prof se puder depois ensinar direitinho como uusar todo o potencial 
		//  de regular expressions eu agradeço :)
		boolean flag = true;
		do {
			System.out.println("Digite o valor do produto: ");
			str = s.nextLine();
			//fazendo a verificação para ver se a String contem o padrão definido
			if(p.matcher(str).matches()) {
				flag = false;
			}else {
				System.out.println("por favor digitar so numeros");
			}
			
		} while (flag);
		
		valor = new BigDecimal(str);
		
		System.out.println("Produto.: "+ nomeProduto
				+ "\nPreço R$.: "+ valor
				+ "\nPromoção: "+ nomeProduto
				+ "\n------------------------");
		
		for (int i = 1; i < 11; i++) {
			
			System.out.println(i+" x R$"+ 
					//fazendo o calculo de valor total menos a porcentagem
					(((valor.subtract(valor.multiply(new BigDecimal(0.05*i)))))
					// fazendo arredondamento para cima, para até 3 casas depois do ponto
					.round(new MathContext(3, RoundingMode.HALF_UP))) + " = R$ " 
					//fazendo o calculo de valor total menos a porcentagem e multiplicando pela quantdade de produtos
						+(((valor.subtract(valor.multiply(new BigDecimal(0.05*i))))).multiply(new BigDecimal(i))
					// fazendo arredondamento para cima, para até 3 casas depois do ponto
					.round(new MathContext(3, RoundingMode.HALF_UP))));
		}
		s.close();
	}

}
