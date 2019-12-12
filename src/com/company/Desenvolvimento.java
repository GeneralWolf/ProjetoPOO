package com.company;

public class Desenvolvimento extends Tarefa {
    public Desenvolvimento(String descritor, Data dataInicio, double duracaoEstimada, double taxaExecucao) {
        super(descritor, dataInicio, duracaoEstimada, taxaExecucao);
    }

    @Override
    public double getTaxaEsforco() {
        return 1;
    }
}
