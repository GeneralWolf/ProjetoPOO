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
            participantes.add(pessoa);
    }

    public double taxaProgressao(){
        //TODO usa a percentagem completada de cada tarefa
    }

    public void printTarefas(){
        for(int i = 0; i < tarefas.size(); i++){
            System.out.println(i + ". " + tarefas.get(i).descritor + "\tProgresso: " + tarefas.get(i).taxaExecucao + "\n");
        }
    }

    public void adicionarTarefa(){

    }

    public void apagarTarefa(){

    }

    public void printTarefasNIniciadas(){
        int counter = 0;
        for(int i = 0; i < tarefas.size(); i++){
            if(tarefas.get(i).taxaExecucao == 0){
                System.out.println(i + ". " + tarefas.get(i).descritor + "\n");
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Todas as tarefas já foram iniciadas");
        }
    }

    public void printTarefasNConcluidas(){
        int counter = 0;
        for(int i = 0; i < tarefas.size(); i++){
            if((tarefas.get(i).taxaExecucao != 100) && (tarefas.get(i).taxaExecucao != 0)){
                System.out.println(i + ". " + tarefas.get(i).descritor + "\tProgresso: " + tarefas.get(i).taxaExecucao + "\n");
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Nenhuma tarefa foi deixada a meio");
        }
    }

    public void printTarefasConcluidas(){
        int counter = 0;
        for(int i = 0; i < tarefas.size(); i++){
            if(tarefas.get(i).taxaExecucao == 100){
                System.out.println(i + ". " + tarefas.get(i).descritor + "\n");
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Nenhuma tarefa foi concluída");
        }
    }

    public double custoTotal(){

    }

    public void finalizarProjeto(){

    }

}
