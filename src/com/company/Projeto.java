package com.company;
import java.util.ArrayList;

public class Projeto {
    private String nome;
    private String acronimo;
    private Data dataInicio;
    private Data dataFim;
    private int duracaoMeses;
    private ArrayList<Pessoa> participantes;
    private ArrayList<Tarefa> tarefas;

    public Projeto(String nome, String acronimo, Data dataInicio, Data dataFim, int duracaoMeses){
        this.nome = nome;
        this.acronimo = acronimo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.duracaoMeses = duracaoMeses;
    }

    public void associarPessoa(Pessoa pessoa){

    }

    public double taxaProgressao(){
        //TODO usa a percentagem completada de cada tarefa
    }

    public void printTarefas(){
        for(int i = 0; i < tarefas.size(); i++){
            System.out.println(tarefas.get(i));
        }
    }

    public void adicionarTarefa(){

    }

    public void apagarTarefa(){

    }

    public ArrayList<Tarefa> printTarefasNIniciadas(){

    }

    public void printTarefasNConcluidas(){

    }

    public void printTarefasConcluidas(){

    }

    public double custoTotal(){

    }

    public void finalizarProjeto(){

    }

}
