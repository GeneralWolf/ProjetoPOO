package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Projeto {
    private String nome;
    private String acronimo;
    private Data dataInicio;
    private Data dataFim;
    private int duracaoMeses;
    private ArrayList<Pessoa> participantes;
    private ArrayList<Tarefa> tarefas;
    private boolean acabado = false;

    public Projeto(String nome, String acronimo, Data dataInicio, Data dataFim, int duracaoMeses){
        this.nome = nome;
        this.acronimo = acronimo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.duracaoMeses = duracaoMeses;
    }

    public void associarPessoa(Pessoa pessoa){
        if(!acabado) {
            participantes.add(pessoa);
        }
        else{
            System.out.println("O projeto apenas está disponível para consulta");
        }
    }

    public double taxaProgressao(){
        //TODO usa a percentagem completada de cada tarefa
    }

    public void printTarefas(){
        for(int i = 0; i < tarefas.size(); i++){
            System.out.println(i + ". " + tarefas.get(i).descritor + "\tProgresso: " + tarefas.get(i).taxaExecucao + "\n");
        }
    }

    public void adicionarTarefa(String descritor, Data dataInicio, Data dataFim, double duracaoEstimada, double taxaExecucao){
        if(!acabado) {
            String opcao;
            int opcaoN;
            Scanner escolha = new Scanner(System.in);
            System.out.println("Que tipo de tarefa?\n1.Desenvolvimento\n2.Design\n3.Documentação");
            opcao = escolha.nextLine();


            tarefas.add(new Tarefa(descritor, dataInicio, dataFim, duracaoEstimada, taxaExecucao));
        }
        else{
            System.out.println("O projeto apenas está disponível para consulta");
        }
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
        double custo = 0;
        for(int i = 0; i < participantes.size(); i++){
            custo += participantes.get(i).getCusto();
        }
        return custo;
    }

    public void finalizarProjeto(){
        this.acabado = true;
    }

}
