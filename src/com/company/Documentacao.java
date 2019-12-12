package com.company;

public class Documentacao extends Tarefa {
    public Documentacao(String descritor, Data dataInicio, double duracaoEstimada) {
        super(descritor, dataInicio,duracaoEstimada);
    }

    @Override
    public double getTaxaEsforco() {
        return 0.25;
    }
}
