package tarefa_quatro;

import tarefa_quatro.cliente.Cliente;
import tarefa_quatro.cliente.Contato;
import tarefa_quatro.cliente.Endereco;
import tarefa_quatro.contas.ContaCorrente;
import tarefa_quatro.contas.ContaPoupanca;

public class Main {
	public static void main(String[] args) {
		
		Endereco enderecoPessoalJoao = new Endereco("rua", "Batatinha Embatatada", "12345-678", "batatopolis", "batatonia", "batatolandia", 1, 2222);
		Endereco enderecoEmpresarialJoao = new Endereco("rua", "cenourinha cenourada", "98765-432", "cenouropolis", "cenouronia", "cenoulandia", 2, 1111);
		Endereco[] enderecosJoao = {enderecoPessoalJoao, enderecoEmpresarialJoao};
		
		Contato contatoPessoalJoao = new Contato("Numero Pessoal", "123456789", 1);
		Contato contatoEmpresarialJoao = new Contato("Numero Comercial", "987654321", 2);
		
		Contato[] contatosJoao = {contatoPessoalJoao, contatoEmpresarialJoao};
		
		Cliente joao = new Cliente("João Victor", "123.456.789-12");
		joao.setEndereco(enderecosJoao);
		joao.setContato(contatosJoao);
		
		joao.imprimirCliente();
		joao.imprimirContatos();
		joao.imprimirEnderecos();
		
		System.out.println();
		
		Endereco enderecoPessoalMaria = new Endereco("rua", "churras churrascada", "12345-678", "churrascopolis", "churrasconia", "churraslandia", 1, 2222);
		Endereco enderecoEmpresarialMaria = new Endereco("rua", "pizzinha pizzada", "98765-432", "pizzopolis", "pizzonia", "pizzalandia", 2, 1111);
		Endereco[] enderecosMaria = {enderecoPessoalMaria, enderecoEmpresarialMaria};
		
		Contato contatoPessoalMaria = new Contato("Numero Pessoal", "123456789", 1);
		Contato contatoEmpresarialMaria = new Contato("Numero Comercial", "987654321", 2);
		
		Contato[] contatosMaria = {contatoPessoalMaria, contatoEmpresarialMaria};
		
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
