package com.company;

abstract public class Tarefa {
    protected Data dataInicio;
    protected Data dataFim;
    protected double duracaoEstimada;
    protected double taxaExecucao;
    //protected double taxaEsforco;     //TODO tecnicamente nao é necessário já que a taxa de esforço está definida nas subclasses
    protected Pessoa responsavel;

    public Tarefa(Data dataInicio, Data dataFim, double duracaoEstimada, double taxaExecucao){
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

    public double setTaxaExacucao(double taxaExecucao){
        this.taxaExecucao = taxaExecucao;
    }

    public double getTaxaExecucao(){
        return taxaExecucao;
    }

    abstract public double getTaxaEsforco();

}
