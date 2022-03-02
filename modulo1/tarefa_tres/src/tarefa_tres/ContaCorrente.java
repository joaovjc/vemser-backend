package tarefa_tres;

import java.math.BigDecimal;

public class ContaCorrente {
	
	private Cliente cliente;
	private String numeroConta;
	private int agencia;
	private BigDecimal saldo;
	private BigDecimal chequeEpecial;
	
	public ContaCorrente(Cliente cliente, String numeroConta, int agencia, BigDecimal saldo, BigDecimal chequeEpecial) {
		this.cliente = cliente;
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.saldo = saldo;
		this.chequeEpecial = chequeEpecial;
	}

	public void imprimirContaCorrente() {
		System.out.println("Nome: " + this.cliente.getNome() 
		+ "\nNumero da Conta: " + this.numeroConta 
				+ "\nAgencia: " + this.agencia 
				+ "\nSaldo: " + this.saldo.doubleValue() 
				+ "\nCheque Especial: " + this.chequeEpecial.doubleValue());
	}
	
	
	public boolean sacar(double valor) {
		if (valor > this.saldo.doubleValue() || valor <= 0) {
			
			if (valor > this.saldo.add(this.chequeEpecial).doubleValue() || valor <= 0) {
				return false;
			}
			
			this.saldo = this.saldo.subtract(new BigDecimal(valor));
			return true;
		}
		
		this.saldo = this.saldo.subtract(new BigDecimal(valor));
		return true;
	}
	
	
	public boolean depositar(double valor) {
		if (valor <= 0)return false;
		
		this.saldo = this.saldo.add(new BigDecimal(valor));
		return true;
	}
	
	
	public double retornarSaldoComChequeEspecial() {
		return this.saldo.add(this.chequeEpecial).doubleValue();
	}
	
	
	public boolean transferir(ContaCorrente contaCorrente, double valor) {
		if (valor > this.saldo.doubleValue() || valor <= 0) {
			if (valor > this.saldo.add(this.chequeEpecial).doubleValue() || valor <= 0) {
				return false;
			}
			
			this.saldo = this.saldo.subtract(new BigDecimal(valor));

			contaCorrente.depositar(valor);
			return true;
		}
		
		this.saldo = this.saldo.subtract(new BigDecimal(valor));
		contaCorrente.depositar(valor);
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

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public BigDecimal getChequeEpecial() {
		return chequeEpecial;
	}

	public void setChequeEpecial(BigDecimal chequeEpecial) {
		this.chequeEpecial = chequeEpecial;
	}
	
	
}
