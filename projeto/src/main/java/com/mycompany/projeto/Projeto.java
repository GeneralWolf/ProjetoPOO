package com.mycompany.projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Projeto implements Serializable {
    private String nome;
    private String acronimo;
    private Data dataInicio;
    private Data dataFim;
    private int duracaoMeses;
    private ArrayList<Pessoa> participantes;
    protected ArrayList<Tarefa> tarefas;
    private Scanner escolha = new Scanner(System.in);
    
   
     public Projeto(String nome, String acronimo, Data dataInicio, int duracaoMeses){
        this.participantes = new ArrayList();
        this.tarefas = new ArrayList();
        this.nome = nome;
        this.acronimo = acronimo;
        this.dataInicio = dataInicio;
        this.duracaoMeses = duracaoMeses;
    }
     /**
     * 
     * @param nome nome do projeto
     * @param acronimo  acrónimo do projeto
     * @param dataInicio data de início do projeto
     * @param dataFim   data em que o projeto foi concluído
     * @param duracaoMeses duração prevista em meses
     */
    public Projeto(String nome, String acronimo, Data dataInicio, Data dataFim, int duracaoMeses){
        this.nome = nome;
        this.acronimo = acronimo;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.duracaoMeses = duracaoMeses;
    }
    
    public String getNome(){
        return nome;
    }
    
    /**
     * 
     * @return taxa de progressão do projeto.
     */
     public double taxaProgressao(){
        //TODO usa a percentagem completada de cada tarefa
        if (tarefas.size() >0){
            double part = 1.0/tarefas.size();
            double total = 0;
            for(int i = 0; i < tarefas.size(); i++){
                total += part * tarefas.get(i).getTaxaExecucao();
            }
            return total * 100;
        }
        else{return 0;}
     }
     
     public void setDuracao(double dur){
         this.duracaoMeses = (int)dur;
     }
     /**
      * Adiciona um trabalhador ao projeto
      * @param pessoa Trabalhador a adicionar
      * @return 1 se o trabalhador foi adicionado com sucesso ou 0 se o proojeto já terminou ou o trabalhador não pode ser adicionado a mais projetos
      */
    public int associarPessoa(Pessoa pessoa){
        if(taxaProgressao()!=100 && pessoa.adicionaProjeto(this)==1) {
            participantes.add(pessoa);
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * 
     * @return lista das tarefas associadas ao projeto.
     */
    public ArrayList<Tarefa> getTarefas(){
        return tarefas;
    }

    /**
     * Associa uma nova tarefa ao projeto.
     * @param tarefa tarefa a associar
     */
    public void adicionarTarefa(Tarefa tarefa){
        if(this.taxaProgressao()!=100){
        tarefas.add(tarefa);
        tarefa.setProjeto(this);
        }
    }

    public void setFim(Data fim){
        this.dataFim = fim;
    }
    /**
     * 
     * @return lista com as tarefas associadas ao projeto ainda não concluídas
     */
    public ArrayList<Tarefa> getTarefasNConcluidas(){
        ArrayList<Tarefa> nconc = new ArrayList();
        for(int i = 0; i < tarefas.size(); i++){
            if((tarefas.get(i).getTaxaExecucao() != 100)){
                nconc.add(tarefas.get(i));
            }
        }
        return nconc;
    }
/**
 * 
 * @return lista das tarefas associadas ao projeto que já foram concluídas
 */
    public ArrayList<Tarefa> getTarefasConcluidas(){
        ArrayList<Tarefa> conc = new ArrayList();
        for(int i = 0; i < tarefas.size(); i++){
            if(tarefas.get(i).getTaxaExecucao() == 100){
               conc.add(tarefas.get(i)); 
            }
        }
        return conc;
    }
/**
 * 
 * @return custo total do projeto com base nos ordenados dos trabalhadores associados e na sua duração.
 */
    public double custoTotal(){
        double custo = 0;
        if(this.taxaProgressao()!=100){
            for(int i = 0; i < tarefas.size(); i++){
                custo += tarefas.get(i).getDuracao()*tarefas.get(i).getResponsavel().getCusto();
            }
            return custo;
        }
        else{
            for(int i = 0; i < tarefas.size(); i++){
                custo += Data.getDiferencaMeses(tarefas.get(i).getDataInicio(),tarefas.get(i).getDataFim());
            }
            return custo;
        }
    }

}
