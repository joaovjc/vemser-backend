package tarefa_dois;

import java.util.Random;
import java.util.Scanner;

public class ExercicioDois {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);	
		Random r = new Random();
		int usuarioUm = 0, usuarioDois = 0;
		System.out.println("Você tem um amigo para jogar?");
		switch (s.nextLine()) {
		case "não", "nao", "n" -> {
			System.out.println("sem problemas, o computador sempre estara aqui por você!");
			System.out.println(""" 
					
					¯\\_(ツ)_/¯
					
					""");
			System.out.println("tente adivinhar o numero que o computador gerou, boa sorte!!");
			usuarioDois = r.nextInt(10);
				do {
				
				usuarioUm = s.nextInt();
				
				if(usuarioUm != usuarioDois)System.out.println("nop, não é esse meu numero");
				
				if (usuarioUm != usuarioDois && usuarioUm < usuarioDois) {
					System.out.println("meu numero é maior do que o que você digitou");
				}else if(usuarioUm != usuarioDois){
					System.out.println("meu numero é menor do que o que você digitou");
				}
				
			}while(usuarioUm != usuarioDois);
			
			System.out.println("boa esse era meu numero " + usuarioDois);
		}
		
		case "sim", "s" ->{
			System.out.println("uma pessoa digite um numero, mas não deixe seu amigo olhar");
			usuarioDois = s.nextInt();
			for (int i = 0; i < 30; i++) System.out.println("\n");
			System.out.println("Agora é só adivinhar, boa sorte!!");
			do {
				
				usuarioUm = s.nextInt();
				
				if(usuarioUm != usuarioDois)System.out.println("esse não é o numero do seu amigo!!!");
				
				if (usuarioUm != usuarioDois && usuarioUm < usuarioDois) {
					System.out.println("o numero do seu amigo é maior do que o que você digitou");
				}else if(usuarioUm != usuarioDois){
					System.out.println("o numero do seu amigo é menor do que o que você digitou");
				}
			}while(usuarioUm != usuarioDois);
			System.out.println("eba acertouuuu!!!!! O numero era " + usuarioDois);
		}
		
		default ->
		System.out.println("Não existe esta opção");
		}
		s.close();
	}
}
