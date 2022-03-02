package com.dbc.aula6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeworkStream {
    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagi�rio"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagi�rio"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

        //1- listar todas as pessoas
        lista.forEach(System.out::println);

        //2- filtrar todas as pessoas com salario maior do que 5 mil
        
        lista.stream()
        .filter(p -> p.getSalario() > 5000.0)
        .forEach(System.out::println);
        
        //3- filtrar todas as pessoas que s�o desenvolvedoras e organizar por sal�rio crescente

        lista.stream()
        .filter(p -> p.getCargo().equals("Desenvolvedor"))
        .sorted(Comparator.comparing(Pessoa::getSalario))
        .forEach(System.out::println);
        
        //4- fazer a m�dia salarial de todos
        
        System.out.println(
        		lista.stream()
        		.mapToDouble(Pessoa::getSalario)
        		.average());
        
        //5- verificar na lista (utilizando o m�todo anyMatch) se tem algu�m que ganha mais do que 20 mil
        
        System.out.println(
        		lista.stream()
        		.anyMatch(p -> p.getSalario() > 20000.0));
        
        //6 - retornar uma lista de todos os ids das pessoas
        
        List<Integer> intStream = 
        		lista.stream()
        		.map(Pessoa::getId)
        		.toList();
        
        //7 - criar uma nova classe Salario com ID e Sal�rio, utilizando a fun��o "map" do stream, retornar uma lista desse novo objeto
        
        List<Salario> salarios = 
        		lista.stream()
        		.map(p -> new Salario(p.getId(),p.getSalario()))
        		.toList();
        salarios.forEach(System.out::println);
        
        //8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores
        
        Map<Integer, String> map = 
        		lista.stream()
        		.collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        
        //9- com o mapa da quest�o 8, retornar o nome com o id=2
        System.out.println(map.get(2));
    }

    static class Pessoa {
        private int id;
        private String nome;
        private double salario;
        private String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

		@Override
		public String toString() {
			return "Pessoa [id=" + id + ", nome=" + nome + ", salario=" + salario + ", cargo=" + cargo + "]";
		}
    }
    
    static class Salario{
    	private int id;
    	private double salario;
    	
		public Salario(int id, double salario) {
			this.id = id;
			this.salario = salario;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public double getSalario() {
			return salario;
		}
		public void setSalario(double salario) {
			this.salario = salario;
		}
		@Override
		public String toString() {
			return "Salario [id=" + id + ", salario=" + salario + "]";
		}
		
		
    }
}