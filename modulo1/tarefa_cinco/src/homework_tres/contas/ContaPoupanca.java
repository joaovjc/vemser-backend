package homework_tres.contas;

import homework_tres.cliente.Cliente;
import homework_tres.interfaces.Impressao;

public class ContaPoupanca extends Conta implements Impressao {
	
	private final static double JUROS_MENSAL = 1.01;
	
	public ContaPoupanca(Cliente cliente, String numeroConta, int agencia, double saldo) {
		super(cliente, numeroConta, agencia, saldo);
	}
	
	public void creditarTaxa() {
		super.setSaldo(super.getSaldo() * JUROS_MENSAL);
	}
	
	@Override
	public void imprimir() {
		System.out.println("Nome: " + super.getCliente().getNome() 
				+ "\nNumero da Conta: " + super.getNumeroConta() 
						+ "\nAgencia: " + super.getAgencia()
						+ "\nSaldo: " + super.getSaldo());
	}

}
