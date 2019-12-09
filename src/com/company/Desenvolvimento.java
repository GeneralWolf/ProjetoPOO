package com.company;

public class Desenvolvimento extends Tarefa {
    public Desenvolvimento(String descritor, Data dataInicio, Data dataFim, double duracaoEstimada, double taxaExecucao) {
        super(dataInicio, duracaoEstimada, taxaExecucao);
    }

    @Override
    public double getTaxaEsforco() {
        return 1;
    }
    @Override
    public String getDescritor(){
        return "Desenvolvimento";
    }
}
