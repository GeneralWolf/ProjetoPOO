package com.mycompany.projeto;

public class Documentacao extends Tarefa {
    public Documentacao(Data dataInicio, double duracaoEstimada, double taxaExecucao) {
        super(dataInicio,duracaoEstimada, taxaExecucao);
    }

    @Override
    public double getTaxaEsforco() {
        return 0.25;
    }
    @Override
    public String getDescritor(){
        return "Documentacao";
    }
}
