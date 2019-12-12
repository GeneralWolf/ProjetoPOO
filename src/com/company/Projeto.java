package com.company;
import java.util.ArrayList;
import java.util.Scanner;

//TODO adicionar funçao para remover pessoa

public class Projeto {
    private String nome;
    private String acronimo;
    private Data dataInicio;
    private Data dataFim;
    private int duracaoMesesPrevista;
    private ArrayList<Pessoa> participantes;
    private ArrayList<Tarefa> tarefas;
    private boolean acabado = false;
    private Scanner escolha = new Scanner(System.in);


     public Projeto(String nome, String acronimo, Data dataInicio, int duracaoMesesPrevista){
        this.nome = nome;
        this.acronimo = acronimo;
        this.dataInicio = dataInicio;
        this.duracaoMesesPrevista = duracaoMesesPrevista;
        participantes =new ArrayList<Pessoa>(50);
        tarefas = new ArrayList<Tarefa>(50);
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
        double part = 1.0/tarefas.size();
        double total = 0;
        for(int i = 0; i < tarefas.size(); i++){
            total += part * tarefas.get(i).getTaxaExecucao();
        }
        if(total == 1){
            acabado = true;
        }
        return total * 100;
    }

    public void printTarefas(){
        for(int i = 0; i < tarefas.size(); i++){
            System.out.println(i + ". " + tarefas.get(i).getDescritor() + "\tProgresso: " + tarefas.get(i).taxaExecucao + "\n");
        }
    }

    public void adicionarTarefa(Tarefa tar){
        tarefas.add(tar);
    }

    public void apagarTarefa() {
        String opcao;   //*isto
        int opcaoN;     //*isto
        if (!acabado) {
            printTarefas();
            System.out.println("Escolha o número da tarefa a eliminar\n");  //*isto
            opcao = escolha.nextLine(); //*isto
            opcao = escolha.nextLine(); //*isto
            try {
                //TODO probs temporario já que probs vai ser implementado usando a interface grafica, mas para testing purposes está aqui**
                opcaoN = Integer.parseInt(opcao);   //*isto
                tarefas.remove(opcaoN);
            } catch (NumberFormatException ex) {
                System.out.println("Escreva um número por favor");  //*isto
            }
        } else {
            System.out.println("O projeto apenas está disponível para consulta");
        }
    }

    public void printTarefasNIniciadas(){
        int counter = 0;
        for(int i = 0; i < tarefas.size(); i++){
            if(tarefas.get(i).taxaExecucao == 0){
                System.out.println(i + ". " + tarefas.get(i).getDescritor() + "\n");
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
                System.out.println(i + ". " + tarefas.get(i).getDescritor() + "\tProgresso: " + tarefas.get(i).taxaExecucao + "\n");
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
                System.out.println(i + ". " + tarefas.get(i).getDescritor() + "\n");
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Nenhuma tarefa foi concluída");
        }
    }
/**
 *
 * @return custo total do projeto com base nos ordenados dos trabalhadores associados e na sua duração.
 */
    public double custoTotal(){
        double custo = 0;
        for(int i = 0; i < participantes.size(); i++){
            custo += participantes.get(i).getCusto();
        }
        return custo;
    }

    //TODO probs ha maneira melhor de escolher a dataFim sem ser como argumento da função, mas vê-se depois
    public void finalizarProjeto(Data dataFim){
        this.acabado = true;
        this.dataFim = dataFim;
    }

    public String getNome(){
        return this.nome;
    }

    public ArrayList<Tarefa> getTarefas(){
        return this.tarefas;
    }

    public ArrayList<Pessoa> getPessoas(){
        return this.participantes;
    }

}
