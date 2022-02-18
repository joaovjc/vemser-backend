package tarefa_dois;

import java.util.Scanner;
//import java.util.regex.Pattern;

public class ExercicioOito {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int[][] valores = new int[5][4];
		int matriculaPremiada = 0;
		int j = 0;
//		Pattern p = Pattern.compile("^[0-9]{4}$");
//		String str;
//		System.out.println("digite uma matricula: (máximo 4 números)");
//		do {
//			str = s.nextLine();
//			if(!p.matcher(str).matches()) {
//				System.out.println("máximo 4 números, tente de novo");
//			}
//		} while (!p.matcher(str).matches());
//		
//		for(int i = 0; i < 4; i++) {
//			valores[0][i] = Character.getNumericValue(str.charAt(i));
//		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Insira a matricula do "+ i +" aluno: ");
			valores[i][0] = s.nextInt();
			s.nextLine();
			System.out.println("Insira a média das provas do "+ i +" aluno: ");
			valores[i][1] = s.nextInt();
			s.nextLine();
			System.out.println("Insira a média dos trabalhos do "+ i +" aluno: ");
			valores[i][2] = s.nextInt();
			s.nextLine();
			valores[i][3] = (int) Math.round((valores[i][1] * 0.6 + valores[i][2] * 0.4));
			if (j < valores[i][3]) {
				j = valores[i][3];
				matriculaPremiada = valores[i][0];
			}
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("A matricula do "+ i +" aluno é: "+ valores[i][0]);
			System.out.println("A média das provas do "+ i +" aluno é: " + valores[i][1]);
			System.out.println("A média dos trabalhos do "+ i +" aluno é: " + valores[i][2]);
			
		}
		System.out.println("A maior media foi da matricula: " + matriculaPremiada);
		System.out.println("a media da turma foi: " + ((valores[0][3]+valores[1][3]+valores[2][3]+valores[3][3]+valores[4][3])/5));
		
		s.close();
	}
}
