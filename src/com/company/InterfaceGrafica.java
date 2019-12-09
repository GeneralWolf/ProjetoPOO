package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame {

    private JPanel panelPrincipal, panelProjeto;
    private JButton buttonCreate, buttonEnd, buttonAssociate;
    private JList<String> listProjetos;

    private FlowLayout layout = new FlowLayout();

    public static void fillList(DefaultListModel<String> lista, int tamanho, ArrayList<Projeto> list){
        for(int i = 0; i < tamanho; i++){
            //lista.addElement(nome);
            lista.addElement(list.get(i).getNome());
        }
    }

    public InterfaceGrafica(CentroInvestigacao ci) {
        //Detalhes do painel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(layout);

        //Detalhes da lista
        //call add project names to nomesProjetos here
        DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
        listProjetos = new JList<>(nomesProjetos);
        JScrollPane listScroller = new JScrollPane(listProjetos);
        fillList(nomesProjetos, ci.projetos.size(), ci.projetos);
    //TODO o metodo de meter os nomes dos projetos tem de ser metida aqui

        //Detalhes dos botoes
        buttonCreate = new JButton("Criar Projeto");
        buttonEnd = new JButton("Concluir Projeto");
        buttonAssociate = new JButton("Associar pessoa");



        //add everything
        panelPrincipal.add(listScroller);
        panelPrincipal.add(buttonCreate);
        panelPrincipal.add(buttonEnd);
        panelPrincipal.add(buttonAssociate);

        this.add(panelPrincipal);

    }

/*
    //TODO tset purposes only, will be transfered to main class after
    public static void main(String[] args){
        InterfaceGrafica frame = new InterfaceGrafica();



        frame.setTitle("Centro de Investigação - Projetos");
        frame.setSize(1000, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);    for now off, since were going to let it be resizable
        frame.setVisible(true);
    }

 */
}
