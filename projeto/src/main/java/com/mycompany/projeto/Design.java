package com.mycompany.projeto;
public class Design extends Tarefa {

    public Design(Projeto projeto,Data dataInicio, double duracaoEstimada) {
        super(projeto,dataInicio, duracaoEstimada);
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
