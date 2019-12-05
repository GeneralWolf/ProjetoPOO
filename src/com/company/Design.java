package com.mycompany.projeto;
public class Design extends Tarefa {

    public Design(Data dataInicio, double duracaoEstimada, double taxaExecucao) {
        super(dataInicio, duracaoEstimada, taxaExecucao);
    }

    @Override
    public double getTaxaEsforco() {
        return 0.5;
    }
    @Override
    public String getDescritor(){
        return "Design";
    }
}
