package com.mycompany.projeto;

import java.io.Serializable;
import java.time.LocalDateTime;

abstract public class Tarefa implements Serializable{
    private Projeto projeto;
    private Data dataInicioT;
    private Data dataFimT;
    private double duracaoEstimada;
    private double taxaExecucao;
    private Pessoa responsavel;

    /**
     * 
     * @param dataInicio Data de início da tarefa
     * @param duracaoEstimada   Duração estimada para a tarefa
     * @param projeto   Projeto a associar a tarefa.
     */
    public Tarefa(Projeto projeto, Data dataInicio, double duracaoEstimada){
        this.projeto = projeto;
        this.dataInicioT = dataInicio;
        this.duracaoEstimada = duracaoEstimada;
    }

    /**
     * 
     * @return trabalhador responsável pela tarefa 
     */
    public double getDuracao(){
        return duracaoEstimada;
    }
    
    public void setProjeto(Projeto projeto){
        this.projeto = projeto;
        projeto.tarefas.add(this);
    }
    public Projeto getProjeto(){
        return projeto;
    }
    public Pessoa getResponsavel(){
        return responsavel;
    }
    /**
     * Seleciona um trabalhador como responsável pela tarefa
     * @param responsavel trabalhador a ser selecionado
     * @return 1 se o trabalhador foi selecionado com sucesso ou 0 se o trabalhador já não pode ser responsável por mais tarefas.
     */
    public int setResponsavel(Pessoa responsavel){
        if(responsavel.adicionaTarefa(this)==1){
            this.responsavel = responsavel;
            return 1;
        }
        else{return 0;}
    }

    /**
     * Altera a taxa de execução da tarefa.
     * @param taxaExecucao nova taxa de execução da tarefa em percentagem
     * @return 1 se a percentagem é válida ou 0 se a percentagem é inválida
     */
    public int setTaxaExecucao(double taxaExecucao){
        if(taxaExecucao<=100 && taxaExecucao>=0){
            this.taxaExecucao = taxaExecucao;
            if(projeto.taxaProgressao()==100){
                LocalDateTime now = LocalDateTime.now();
                Data d = new Data(now.getDayOfMonth(),now.getMonthValue(),now.getYear());
                projeto.setFim(d);
            }
            return 1;
        }
        else{
            return 0;
        }
    }

    /**
     * 
     * @return taxa de execução da tarefa 
     */
    public double getTaxaExecucao(){
        return taxaExecucao;
    }
    
    public Data getDataFim(){
        if (getTaxaExecucao()==100){
            return this.dataFimT;
        }
        else{
            return dataInicioT;
        }
    }
    
    public void setDuracaoPrevista(double dur){
        this.duracaoEstimada = dur;
        double m = dur;
        for(Tarefa tarefa:projeto.getTarefas()){
            if (tarefa.getDuracao()>m){
                m = tarefa.getDuracao();
            }
        }
        projeto.setDuracao(dur);
    }
    
    public Data getDataInicio(){
        return this.dataInicioT;
    }
            
    abstract public String getDescritor();
/**
 * 
 * @return taxa de esforço associada à tarefa 
 */
    abstract public double getTaxaEsforco();

}
