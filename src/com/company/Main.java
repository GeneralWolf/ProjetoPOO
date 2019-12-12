package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        CentroInvestigacao centro = new CentroInvestigacao("TestENV");
        //TODO gotta declare your projects here my bois
        //TODO dps é automatizar isto de acordo com os ficheiros
        Projeto projTest = new Projeto("TesteTar", "TTar", new Data(1,1,1), 23);
        projTest.adicionarTarefa(new Desenvolvimento("Teste1", new Data(2,2,2), 23));
        projTest.adicionarTarefa(new Documentacao("TesteMaluco", new Data(3,4,4), 44));
        centro.adicionaProjeto(new Projeto("Test1", "t1", new Data(23, 42, 1000), 8));
        centro.adicionaProjeto(new Projeto("bot1", "b1", new Data(25, 12, 2019), 1));
        centro.adicionaProjeto(projTest);


        Projeto proj = new Projeto("Test3", "t3", new Data(4, 4, 44), 55);


        InterfaceGraficaMega frame = new InterfaceGraficaMega(centro);

/*
        ///////////////////testing////////////////////
        InterfaceCriarProjeto frame2 = new InterfaceCriarProjeto(centro);
        frame2.setTitle("Criar Projeto");
        frame2.setSize(480, 350);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setVisible(true);
*/
/*
        InterfaceGraficaTarefas frame3 = new InterfaceGraficaTarefas(proj);
        frame3.setTitle("Projeto protótipo");
        frame3.setSize(700, 700);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setResizable(false);
        frame3.setVisible(true);

    }
*/

    }
}
