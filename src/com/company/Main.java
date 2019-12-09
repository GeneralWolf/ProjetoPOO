package com.company;

import com.company.CentroInvestigacao;
import com.company.Data;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        CentroInvestigacao centro = new CentroInvestigacao();
        //TODO gotta declare your projects here my bois
        //TODO dps é automatizar isto de acordo com os ficheiros
        centro.adicionaProjeto(new Projeto("Test1", "t1", new Data(23,42,1000), 8));
        centro.adicionaProjeto(new Projeto("bot1", "b1", new Data(25, 12, 2019), 1));


        InterfaceGrafica frame = new InterfaceGrafica(centro);


        frame.setTitle("Centro de Investigação - Projetos");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);    for now off, since were going to let it be resizable
        frame.setVisible(true);



        ///////////////////testing////////////////////
        InterfaceCriarProjeto frame2 = new InterfaceCriarProjeto();
        frame.setTitle("Criar Projeto");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);



    }
}
