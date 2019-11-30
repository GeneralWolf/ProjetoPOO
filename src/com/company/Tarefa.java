package com.company;

abstract public class Tarefa {
    protected String descritor;     //TODO para dar para diferenciar as tarefas e para depois ter algo para por na interface
    protected Data dataInicio;
    protected Data dataFim;
    protected double duracaoEstimada;
    protected double taxaExecucao;
    protected Pessoa responsavel;

    public Tarefa(String descritor, Data dataInicio, Data dataFim, double duracaoEstimada, double taxaExecucao){
        this.descritor = descritor;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.duracaoEstimada = duracaoEstimada;
        this.taxaExecucao = taxaExecucao;
    }

    public Pessoa getResponsavel(){
        return responsavel;
    }

    public void setResponsavel(Pessoa responsavel){
        this.responsavel = responsavel;
    }

    public void setTaxaExacucao(double taxaExecucao){
        this.taxaExecucao = taxaExecucao;
    }

    public double getTaxaExecucao(){
        return taxaExecucao;
    }

    abstract public double getTaxaEsforco();

}
