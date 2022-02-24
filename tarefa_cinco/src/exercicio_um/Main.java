package exercicio_um;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		OperacaoMatematica soma= (a,b) -> a+b;
		OperacaoMatematica subtracao= (a,b) -> a-b; 
		OperacaoMatematica divisao = (a,b) -> a/b;
		OperacaoMatematica multiplicacao = (a,b) -> a*b;
		
		List<OperacaoMatematica> opUm = Arrays.asList(soma,subtracao,divisao,multiplicacao);
		
		opUm.forEach(ope -> System.out.println(ope.calcula(2, 5)));
		
//		OperacaoMatematica sr = null;
//		
//		List<OperacaoMatematica> opDois = Arrays.asList(sr = (a,b) -> a+b, sr = (a,b) -> a-b, 
//				sr = (a,b) -> a/b, sr = (a,b) -> a*b);
//		
//		opDois.forEach(ope -> System.out.println(ope.calcula(10, 5)));

	}

}
