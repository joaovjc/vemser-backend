package tarefa_quatro.contas;

import tarefa_quatro.cliente.Cliente;
import tarefa_quatro.interfaces.Movimentacao;

public abstract class Conta implements Movimentacao{
	
	private Cliente cliente;
	private String numeroConta;
	private int agencia;
	private double saldo;
	
	
	public Conta(Cliente cliente, String numeroConta, int agencia, double saldo) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
	}
	
	@Override
	public boolean sacar(double valor) {
		if (valor > this.saldo || valor <= 0) {
				return false;
		}
		
		this.saldo -= valor;
		return true;
	}
	
	@Override
	public boolean depositar(double valor) {
		if (valor <= 0)return false;
		
		this.saldo += valor;
		return true;
	}
	
	@Override
	public boolean transferir(Conta contaPessoa, double valor) {
		if (valor > this.saldo || valor <= 0) {
				return false;
		}
		this.saldo -= valor;
		contaPessoa.depositar(valor);
		return true;
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
}
