package exercicio_um;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		List<OperacaoMatematica> op = Arrays.asList(new Soma(), new Divisao(), 
				new Subtracao(), new Multiplicacao());
	
		op.forEach(ope -> System.out.println(ope.calcula(10, 5)));

	}

}
