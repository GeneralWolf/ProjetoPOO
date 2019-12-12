package com.company;

public class Desenvolvimento extends Tarefa {
    public Desenvolvimento(String descritor, Data dataInicio, double duracaoEstimada) {
        super(descritor, dataInicio, duracaoEstimada);
    }

    @Override
    public double getTaxaEsforco() {
        return 1;
    }
}
