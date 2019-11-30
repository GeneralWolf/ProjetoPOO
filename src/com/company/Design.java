package com.company;

public class Design extends Tarefa {

    public Design(String descritor, Data dataInicio, Data dataFim, double duracaoEstimada, double taxaExecucao) {
        super(descritor, dataInicio, dataFim, duracaoEstimada, taxaExecucao);
    }

    @Override
    public double getTaxaEsforco() {
        return 0.5;
    }
}
