package com.company;

public class Desenvolvimento extends Tarefa {

    public Desenvolvimento(String descritor, Data dataInicio, Data dataFim, double duracaoEstimada, double taxaExecucao) {
        super(descritor, dataInicio, dataFim, duracaoEstimada, taxaExecucao);
    }

    @Override
    public double getTaxaEsforco() {
        return 1;
    }
}
