package com.company;
public class Design extends Tarefa {

    public Design(String descritor, Data dataInicio, double duracaoEstimada) {
        super(descritor, dataInicio, duracaoEstimada);
    }

    @Override
    public double getTaxaEsforco() {
        return 0.5;
    }
}
