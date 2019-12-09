package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfaceGrafica extends JFrame {

    private JPanel panelPrincipal, panelProjeto;
    private JButton buttonCreate, buttonEnd, buttonAssociate;
    private JList<String> listProjetos;

    private FlowLayout layout = new FlowLayout();

    public void fillList(DefaultListModel<String> lista, int tamanho, ArrayList<Projeto> list){
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
        DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
        listProjetos = new JList<>(nomesProjetos);
        JScrollPane listScroller = new JScrollPane(listProjetos);
        fillList(nomesProjetos, ci.projetos.size(), ci.projetos);

        //Detalhes dos botoes
        buttonCreate = new JButton("Criar Projeto");
        buttonEnd = new JButton("Concluir Projeto");
        buttonAssociate = new JButton("Associar pessoa");


        //add everything
        panelPrincipal.add(listScroller);
        listScroller.setPreferredSize(new Dimension(700, 600));     //escolhe o tamanho da lista dos projetos
        panelPrincipal.add(buttonCreate);
        panelPrincipal.add(buttonEnd);
        panelPrincipal.add(buttonAssociate);

        this.add(panelPrincipal);

    }

}
