package com.company;

abstract public class Tarefa {
    protected String descritor;     //TODO para dar para diferenciar as tarefas e para depois ter algo para por na interface
    protected Data dataInicio;
    protected Data dataFim;
    protected double duracaoEstimada;
    protected double taxaExecucao;
    protected Pessoa responsavel;

    /**
     *
     * @param dataInicio Data de início da tarefa
     * @param duracaoEstimada   Duração estimada para a tarefa
     * @param taxaExecucao  Taxa de execução da tarefa
     */
    public Tarefa(Data dataInicio, double duracaoEstimada, double taxaExecucao){
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.duracaoEstimada = duracaoEstimada;
        this.taxaExecucao = taxaExecucao;
    }

    /**
     *
     * @return trabalhador responsável pela tarefa
     */
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
     * @param taxaExecucao nova taxa de execução da tarefa
     */
    public void setTaxaExecucao(double taxaExecucao){
        this.taxaExecucao = taxaExecucao;
    }

    /**
     *
     * @return taxa de execução da tarefa
     */
    public double getTaxaExecucao(){
        return taxaExecucao;
    }
/**
 *
 * @return taxa de esforço associada à tarefa
 */
    abstract public double getTaxaEsforco();

    abstract public String getDescritor();

}
