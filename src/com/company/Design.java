package com.company;
public class Design extends Tarefa {

    public Design(String descritor, Data dataInicio, double duracaoEstimada, double taxaExecucao) {
        super(descritor, dataInicio, duracaoEstimada, taxaExecucao);
    }

    @Override
    public double getTaxaEsforco() {
        return 0.5;
    }
}
