package com.mycompany.projeto;

public class Documentacao extends Tarefa {
    public Documentacao(Projeto projeto, Data dataInicio, double duracaoEstimada) {
        super(projeto,dataInicio,duracaoEstimada);
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
