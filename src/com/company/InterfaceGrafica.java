package com.company;

import javax.swing.*;
import java.awt.*;

public class InterfaceGrafica extends JFrame {

    CentroInvestigacao test = new CentroInvestigacao();

    private JPanel panelPrincipal, panelProjeto;
    private JButton buttonCreate, buttonEnd, buttonAssociate;
    private JList listProjetos;


    //private String[] nomesProjetos = Projeto.     probs obsolete
    DefaultListModel nomesProjetos = new DefaultListModel();
    //TODO make method to add all project names to nomesProjetos

    private FlowLayout layout = new FlowLayout();

    public void fillList(DefaultListModel lista, int tamanho, String nome){
        for(int i = 0; i < tamanho; i++){
            lista.addElement(nome);
        }
    }

    fillList(nomesProjetos, test.projetos.size(), test.projetos.getNome());

    listProjetos = new JList(nomesProjetos);
    JScrollPane listScroller = new JScrollPane(listProjetos);






    public InterfaceGrafica() {
        //Detalhes do painel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(layout);

        //Detalhes da lista
        //call add project names to nomesProjetos here





        //Detalhes dos botoes
        buttonCreate = new JButton("Criar Projeto");
        buttonEnd = new JButton("Concluir Projeto");
        buttonAssociate = new JButton("Associar pessoa");



        //add everything
        panelPrincipal.add(listProjetos);
        panelPrincipal.add(buttonCreate);
        panelPrincipal.add(buttonEnd);
        panelPrincipal.add(buttonAssociate);

        this.add(panelPrincipal);

    }

    public static void main(String[] args){
        InterfaceGrafica frame = new InterfaceGrafica();
        frame.setTitle("Centro de Investigação - Projetos");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);    for now off, since were going to let it be resizable
        frame.setVisible(true);
    }
}
