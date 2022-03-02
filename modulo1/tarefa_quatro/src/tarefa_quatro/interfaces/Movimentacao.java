package tarefa_quatro.interfaces;

import tarefa_quatro.contas.Conta;

public interface Movimentacao {
	
	boolean sacar(double valor);
	boolean depositar(double valor);
	boolean transferir(Conta contaPessoa, double valor);
	
}
