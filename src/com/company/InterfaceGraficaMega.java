package com.company;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfaceGraficaMega extends JFrame {

    private JPanel panelPrincipal, panelProjeto;
    private JButton buttonCreate, buttonSelect, buttonAssociate;


    public DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
    protected JList<String> listProjetos = new JList<>(nomesProjetos);
    protected JScrollPane listScroller = new JScrollPane(listProjetos);


    private FlowLayout layout = new FlowLayout();

    public void fillListProj( ArrayList<Projeto> list){
        for(int i = 0; i < list.size(); i++){
            //lista.addElement(nome);
            nomesProjetos.addElement(list.get(i).getNome());
        }
    }

    public void fillSingleProj(Projeto proj){
        nomesProjetos.addElement(proj.getNome());
                System.out.println("fillSimple nome: " + proj.getNome());
    }

    public InterfaceGraficaMega(CentroInvestigacao ci) {
        //Detalhes do painel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(layout);

        //Detalhes da lista
        //DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
        //listProjetos = new JList<>(nomesProjetos);
        //JScrollPane listScroller = new JScrollPane(listProjetos);
        fillListProj(ci.projetos);

        //Detalhes dos botoes
        buttonCreate = new JButton("Criar Projeto");
        buttonSelect = new JButton("Concluir Projeto");
        buttonAssociate = new JButton("Associar pessoa");

        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InterfaceCriarProjeto2 frame2 = new InterfaceCriarProjeto2(ci);
                frame2.setTitle("Criar Projeto");
                frame2.setSize(480, 350);
                frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame2.setResizable(false);
                frame2.setVisible(true);
                //fillSingle(nomesProjetos, ci.projetos.get(ci.projetos.size() - 1));   //shit fuckin works
            }
        });

        //add everything
        panelPrincipal.add(listScroller);
        listScroller.setPreferredSize(new Dimension(700, 600));     //escolhe o tamanho da lista dos projetos
        panelPrincipal.add(buttonCreate);
        panelPrincipal.add(buttonSelect);
        panelPrincipal.add(buttonAssociate);

        this.add(panelPrincipal);
    }

}



