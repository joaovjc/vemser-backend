package homework_tres.contas;

import homework_tres.cliente.Cliente;
import homework_tres.interfaces.Impressao;

public class ContaPagamento extends Conta implements Impressao {
	
	private final static double TAXA_SAQUE = 4.25;
	
	public ContaPagamento(Cliente cliente, String numeroConta, int agencia, double saldo) {
		super(cliente, numeroConta, agencia, saldo);
	}
	
	@Override
	public boolean sacar(double valor) {
		return super.sacar(valor+TAXA_SAQUE);
	}
	
	@Override
		public void imprimir() {
			System.out.println("Nome: " + super.getCliente().getNome() 
			+ "\nNumero da Conta: " + super.getNumeroConta() 
					+ "\nAgencia: " + super.getAgencia()
					+ "\nSaldo: " + super.getSaldo());
	}

}
