package tarefa_dois;

import java.util.Scanner;

public class ExercicioTres {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str;
		float altura = 0;
		double alturaTotal = 0, MaiorPeso = 0;
		int jogadoresTotal = 0, maisVelho = 0;
		
		do {
			System.out.println("Digite o nome: ");
			str = s.nextLine();
			if (str.equalsIgnoreCase("sair"))break;
			System.out.println("Digite a Altura: ");
			str = s.nextLine();
			if(Double.parseDouble(str) > altura)altura = (float) Double.parseDouble(str);
			alturaTotal += Double.parseDouble(str);
			System.out.println("Digite a idade: ");
			str= s.nextLine();
			if(Integer.parseInt(str) > maisVelho)maisVelho = Integer.parseInt(str);
			System.out.println("Digite seu peso: ");
			str = s.nextLine();
			if(Double.parseDouble(str) > MaiorPeso)MaiorPeso = Double.parseDouble(str);
			
			jogadoresTotal++;
		} while (true);
		
		System.out.println("Quantidade de jogadores cadastrados: "+ jogadoresTotal
				+ "\nAltura do maior Jogador " + altura
				+ "\nJogador mais velho: "+ maisVelho
				+ "\nJogador mais pesado: "+ MaiorPeso
				+ "\nMédia das alturas jogadores: "+ (alturaTotal/jogadoresTotal));
		s.close();
	}
}
