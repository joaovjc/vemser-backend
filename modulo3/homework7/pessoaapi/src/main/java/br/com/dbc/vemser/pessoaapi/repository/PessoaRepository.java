package br.com.dbc.vemser.pessoaapi.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;

@Repository
public class PessoaRepository {
    private static List<Pessoa> listaPessoas = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public PessoaRepository() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); //18/10/2020
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*1*/, "Maicon Gerardi", LocalDate.parse("10/10/1990", formatter), "12345678910"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*2*/, "Charles Pereira", LocalDate.parse("08/05/1985", formatter), "12345678911"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*3*/, "Marina Oliveira", LocalDate.parse("30/03/1970", formatter), "12345678912"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*4*/, "Rafael Lazzari", LocalDate.parse("01/07/1990", formatter), "12345678916"));
        listaPessoas.add(new Pessoa(COUNTER.incrementAndGet() /*5*/, "Ana", LocalDate.parse("01/07/1990", formatter), "12345678917"));
    }
    
    public boolean idExists(Integer id) {
    	return  listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst().isPresent();
    }
    public Pessoa getByid(Integer id) {
    	return  listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst().get();
    }
    public Pessoa create(Pessoa pessoa){
        pessoa.setIdPessoa(COUNTER.incrementAndGet());
        listaPessoas.add(pessoa);
    	return pessoa;
    }

    public List<Pessoa> list() {
        return listaPessoas;
    }

    public Pessoa update(Integer id,
                         Pessoa pessoaAtualizar){
    	if(idExists(id) == false)new RegraDeNegocioException("já existe uma pessoa com esse nome");
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst().get();
        pessoaRecuperada.setCpf(pessoaAtualizar.getCpf());
        pessoaRecuperada.setNome(pessoaAtualizar.getNome());
        pessoaRecuperada.setDataNascimento(pessoaAtualizar.getDataNascimento());
        return pessoaRecuperada;
    }

    public Pessoa delete(Integer id){
    	if(idExists(id) == false)new RegraDeNegocioException("já existe uma pessoa com esse nome");
        Pessoa pessoaRecuperada = listaPessoas.stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst().get();
        listaPessoas.remove(pessoaRecuperada);
		return pessoaRecuperada;
    }

    public List<Pessoa> listByName(String nome) {
        return listaPessoas.stream()
                .filter(pessoa -> pessoa.getNome().toUpperCase().contains(nome.toUpperCase()))
                .collect(Collectors.toList());
    }
}
