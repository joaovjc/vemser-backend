package tarefa_quatro.contas;

import tarefa_quatro.cliente.Cliente;
import tarefa_quatro.interfaces.Impressao;

public class ContaCorrente extends Conta implements Impressao{

	private double chequeEpecial;
	
	public ContaCorrente(Cliente cliente, String numeroConta, int agencia, double saldo, double chequeEpecial) {
		super(cliente, numeroConta, agencia, saldo);
		this.chequeEpecial = chequeEpecial;
	}
	
	public void setChequeEpecial(double chequeEpecial) {
		this.chequeEpecial = chequeEpecial;
	}
	
	public double retornarSaldoComChequeEspecial() {
		return super.getSaldo() + this.chequeEpecial;
	}
	
	@Override
	public boolean sacar(double valor) {
		if (valor > super.getSaldo() || valor <= 0) {
			if (valor > (super.getSaldo() + this.chequeEpecial) || valor <= 0) {
				return false;
			}
			super.setSaldo((super.getSaldo() - valor));
			return true;
		}
		
		super.setSaldo((super.getSaldo() - valor));
		return true;
	}
	
	@Override
	public void imprimir() {
		System.out.println("Nome: " + super.getCliente().getNome() 
		+ "\nNumero da Conta: " + super.getNumeroConta() 
				+ "\nAgencia: " + super.getAgencia()
				+ "\nSaldo: " + super.getSaldo()
				+ "\nCheque Especial: " + this.chequeEpecial);
	}
}
