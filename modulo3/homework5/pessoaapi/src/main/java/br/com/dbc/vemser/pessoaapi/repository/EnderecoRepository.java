package br.com.dbc.vemser.pessoaapi.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;

@Repository
public class EnderecoRepository {
    private static List<Endereco> listaEnderecos = new ArrayList<>();
    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),1,"comercial", "logadouro", "1015", "12345678", "porto Alegre", "RS", "Pais"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),2,"comercial", "logadouro", "2040", "12345678", "porto Alegre", "RS", "Pais"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),3,"residencial", "logadouro", "3080", "12345678", "porto Alegre", "RS", "Pais"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),4,"comercial", "logadouro", "9999", "12345678", "porto Alegre", "RS", "Pais"));
        listaEnderecos.add(new Endereco(COUNTER.incrementAndGet(),5,"comercial", "logadouro", "8125", "12345678", "porto Alegre", "RS", "Pais"));
    }
    
    public boolean idExists(Integer id) {
    	return  listaEnderecos.stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findFirst().isPresent();
    }
    
    public Endereco create(Endereco endereco) {
    	endereco.setId(COUNTER.incrementAndGet());
        listaEnderecos.add(endereco);
        return endereco;
    }

    public List<Endereco> list() {
        return listaEnderecos;
    }

    public Endereco update(long id,
                         Endereco enderecoAtualizar) throws Exception {
    	System.out.println(id);
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getId()==id)
                .findFirst()
                .orElseThrow(() -> new Exception("contato não econtrada"));
        enderecoRecuperado.setCidade(enderecoAtualizar.getCidade());
        enderecoRecuperado.setNumero(enderecoAtualizar.getNumero());
        enderecoRecuperado.setTipoEndereco(enderecoAtualizar.getTipoEndereco());
        return enderecoRecuperado;
    }

    public void delete(long id) throws Exception {
        Endereco enderecoRecuperado = listaEnderecos.stream()
                .filter(endereco -> endereco.getId()==id)
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não econtrada"));
        listaEnderecos.remove(enderecoRecuperado);
    }

    public List<Endereco> listByIdPessoa(long id) {
        return listaEnderecos.stream()
                .filter(endereco -> endereco.getIdPessoa()==id)
                .collect(Collectors.toList());
    }
}
