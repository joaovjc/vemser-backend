package homework_tres;

import java.util.ArrayList;
import java.util.Arrays;

import homework_tres.cliente.Cliente;
import homework_tres.cliente.Contato;
import homework_tres.cliente.Endereco;
import homework_tres.contas.ContaCorrente;
import homework_tres.contas.ContaPagamento;
import homework_tres.contas.ContaPoupanca;

public class Main {
	public static void main(String[] args) {
		
		Endereco enderecoPessoalJoao = new Endereco("rua", "Batatinha Embatatada", "12345-678", "batatopolis", "batatonia", "batatolandia", 1, 2222);
		Endereco enderecoEmpresarialJoao = new Endereco("rua", "cenourinha cenourada", "98765-432", "cenouropolis", "cenouronia", "cenoulandia", 2, 1111);
		ArrayList<Endereco> enderecosJoao = 
				(ArrayList<Endereco>) Arrays.asList(enderecoPessoalJoao, enderecoEmpresarialJoao);
		
		Contato contatoPessoalJoao = new Contato("Numero Pessoal", "123456789", 1);
		Contato contatoEmpresarialJoao = new Contato("Numero Comercial", "987654321", 2);
		
		ArrayList<Contato> contatosJoao = 
				(ArrayList<Contato>) Arrays.asList(contatoPessoalJoao, contatoEmpresarialJoao);
		
		
		Cliente joao = new Cliente("João Victor", "123.456.789-12");
		joao.setEndereco(enderecosJoao);
		joao.setContato(contatosJoao);
		
		joao.imprimirCliente();
		joao.imprimirContatos();
		joao.imprimirEnderecos();
		
		System.out.println();
		
		Endereco enderecoPessoalMaria = new Endereco("rua", "churras churrascada", "12345-678", "churrascopolis", "churrasconia", "churraslandia", 1, 2222);
		Endereco enderecoEmpresarialMaria = new Endereco("rua", "pizzinha pizzada", "98765-432", "pizzopolis", "pizzonia", "pizzalandia", 2, 1111);
		ArrayList<Endereco> enderecosMaria = (ArrayList<Endereco>) Arrays.asList(enderecoPessoalMaria, enderecoEmpresarialMaria);
		
		Contato contatoPessoalMaria = new Contato("Numero Pessoal", "123456789", 1);
		Contato contatoEmpresarialMaria = new Contato("Numero Comercial", "987654321", 2);
		
		ArrayList<Contato> contatosMaria = (ArrayList<Contato>) Arrays.asList(contatoPessoalMaria, contatoEmpresarialMaria);
		
		Cliente maria = new Cliente("Maria Eduarda", "123.456.789-12");
		maria.setEndereco(enderecosMaria);
		maria.setContato(contatosMaria);
		
		maria.imprimirCliente();
		maria.imprimirContatos();
		maria.imprimirEnderecos();
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("====================================================================================================================");
		
		ContaCorrente contaCorrenteJoao = 
				new ContaCorrente(joao, "12.345-4", 133, 500, 5000);
		ContaPagamento contaPagamentoJoao = 
				new ContaPagamento(joao, "12.345-4", 133, 500);
		ContaPoupanca contaPoupancaMaria = 
				new ContaPoupanca(maria, "98.765-4", 331, 500);
		
		contaCorrenteJoao.imprimir();
		System.out.println();
		System.out.println(contaCorrenteJoao.depositar(100));
		System.out.println();
		contaCorrenteJoao.imprimir();
		System.out.println();
		System.out.println(contaCorrenteJoao.sacar(100));
		System.out.println();
		contaCorrenteJoao.imprimir();
		System.out.println();
		System.out.println("======================================================");
		contaPagamentoJoao.imprimir();
		System.out.println();
		System.out.println(contaPagamentoJoao.depositar(100));
		System.out.println();
		contaPagamentoJoao.imprimir();
		System.out.println();
		System.out.println(contaPagamentoJoao.sacar(100));
		System.out.println();
		contaPagamentoJoao.imprimir();
		System.out.println();
		System.out.println("======================================================");
		contaPoupancaMaria.imprimir();
		System.out.println();
		System.out.println(contaCorrenteJoao.transferir(contaPoupancaMaria, 500));
		System.out.println();
		contaPoupancaMaria.imprimir();
		System.out.println();
		contaCorrenteJoao.imprimir();
		System.out.println("======================================================");
		System.out.println();
		contaPoupancaMaria.imprimir();
		contaPoupancaMaria.creditarTaxa();
		System.out.println();
		contaPoupancaMaria.imprimir();
	}
}
