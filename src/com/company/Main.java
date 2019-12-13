package com.company;

import javax.swing.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
/*
        File data = new File("data");
        CentroInvestigacao centro = new CentroInvestigacao();


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
        */

        File data = new File("data");
        CentroInvestigacao centro = new CentroInvestigacao();
        if (data.isFile()) {
            FileInputStream fileIn = new FileInputStream(data);
            ObjectInputStream objs = new ObjectInputStream(fileIn);
            try {
                centro = (CentroInvestigacao) objs.readObject();
            } catch (ClassNotFoundException e) {
                System.out.print("Erro ao converter o ficheiro de objetox");
            }
        } else {
            centro = Startup.startupReader("Startup.txt");
            centro.setName("Centro Tudo Truta");
            File file = new File("Startup.txt");
            if (!file.isFile()) {
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream("data");
            ObjectOutputStream objs = new ObjectOutputStream(fileOut);
            objs.writeObject(centro);

        }
        for (Pessoa membro : centro.getMembros()) {
            System.out.print("Nome: " + membro.getNome() + "\tEmail: " + membro.getEmail() + "\n");
        }


        //TODO gotta declare your projects here my bois
        //TODO dps é automatizar isto de acordo com os ficheiros
        centro.adicionaProjeto(new Projeto("Test1", "t1", new Data(23, 42, 1000), 8));
        centro.adicionaProjeto(new Projeto("bot1", "b1", new Data(25, 12, 2019), 1));

/*
        InterfaceGrafica frame = new InterfaceGrafica(centro);
        frame.setTitle("Centro de Investigação - Projetos");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);    for now off, since were going to let it be resizable
        frame.setVisible(true);
*/

        ///////////////////testing////////////////////
        InterfaceGraficaMega frame2 = new InterfaceGraficaMega(centro);
        frame2.setTitle("Criar Projeto");
        frame2.setSize(480, 350);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setVisible(true);

    }
}



