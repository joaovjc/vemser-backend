package tarefa_quatro.interfaces;

import tarefa_quatro.contas.Conta;

public interface Movimentacao {
	
	public boolean sacar(double valor);
	public boolean depositar(double valor);
	public boolean transferir(Conta contaPessoa, double valor);
	
}
