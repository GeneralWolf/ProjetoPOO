package com.mycompany.projeto;
public class Desenvolvimento extends Tarefa {
    public Desenvolvimento(Projeto projeto,Data dataInicio, double duracaoEstimada) {
        super(projeto,dataInicio, duracaoEstimada);
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
