package com.mycompany.projeto;
import java.io.*;
import javax.swing.*;        
public class Main {
    
    public static void main(String[] args) throws IOException {
        File data = new File("data");
        CentroInvestigacao centro = new CentroInvestigacao();
        if (data.isFile()){
            FileInputStream fileIn = new FileInputStream(data);
            ObjectInputStream objs = new ObjectInputStream(fileIn);
            try{
                centro = (CentroInvestigacao) objs.readObject();
            }
            catch(ClassNotFoundException e){
                System.out.print("Erro ao converter o ficheiro de objetox");
            }
        }
        else{
            centro = Startup.startupReader("startup.txt");
            centro.setName("Centro Tudo Truta");
            File file = new File("startup.txt");
            if (! file.isFile()){
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream("data");
            ObjectOutputStream objs = new ObjectOutputStream(fileOut);
            objs.writeObject(centro);
       
        }
        for(Pessoa membro:centro.getMembros()){
            System.out.print("Nome: "+membro.getNome()+"\tEmail: "+membro.getEmail()+"\n");
        }
        
        
        //TODO gotta declare your projects here my bois
        //TODO dps é automatizar isto de acordo com os ficheiros
        centro.addProjeto(new Projeto("Test1", "t1", new Data(23,42,1000), 8));
        centro.addProjeto(new Projeto("bot1", "b1", new Data(25, 12, 2019), 1));

/*
        InterfaceGrafica frame = new InterfaceGrafica(centro);
        frame.setTitle("Centro de Investigação - Projetos");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);    for now off, since were going to let it be resizable
        frame.setVisible(true);
*/

        ///////////////////testing////////////////////
        InterfaceCriarProjeto frame2 = new InterfaceCriarProjeto();
        frame2.setTitle("Criar Projeto");
        frame2.setSize(480, 350);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);
        frame2.setVisible(true);

    }
}
