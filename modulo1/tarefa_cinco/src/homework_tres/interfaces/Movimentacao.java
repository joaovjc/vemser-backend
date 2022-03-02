package homework_tres.interfaces;

import homework_tres.contas.Conta;

public interface Movimentacao {
	
	boolean sacar(double valor);
	boolean depositar(double valor);
	boolean transferir(Conta contaPessoa, double valor);
	
}
