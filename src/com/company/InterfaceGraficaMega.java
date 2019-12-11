package com.company;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfaceGraficaMega extends JFrame {

    private JPanel panelPrincipal, panelProjeto;
    private JButton buttonCreate, buttonEnd, buttonAssociate;


    DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
    private JList<String> listProjetos = new JList<>(nomesProjetos);


    private FlowLayout layout = new FlowLayout();

    public void fillList(DefaultListModel<String> lista, int tamanho, ArrayList<Projeto> list){
        for(int i = 0; i < tamanho; i++){
            //lista.addElement(nome);
            lista.addElement(list.get(i).getNome());
        }
    }

    public void fillSingle(DefaultListModel<String> lista, Projeto proj){
        lista.addElement(proj.getNome());
    }



    public InterfaceGraficaMega(CentroInvestigacao ci) {
        //Detalhes do painel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(layout);

        //Detalhes da lista
        //DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
        //listProjetos = new JList<>(nomesProjetos);
        JScrollPane listScroller = new JScrollPane(listProjetos);
        fillList(nomesProjetos, ci.projetos.size(), ci.projetos);

        //Detalhes dos botoes
        buttonCreate = new JButton("Criar Projeto");
        buttonEnd = new JButton("Concluir Projeto");
        buttonAssociate = new JButton("Associar pessoa");

        buttonCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InterfaceCriarProjeto frame2 = new InterfaceCriarProjeto(ci);
                frame2.setTitle("Criar Projeto");
                frame2.setSize(480, 350);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setResizable(false);
                frame2.setVisible(true);
                //fillSingle(nomesProjetos, ci.projetos.get(ci.projetos.size() - 1));   //shit fuckin works
            }
        });

        //add everything
        panelPrincipal.add(listScroller);
        listScroller.setPreferredSize(new Dimension(700, 600));     //escolhe o tamanho da lista dos projetos
        panelPrincipal.add(buttonCreate);
        panelPrincipal.add(buttonEnd);
        panelPrincipal.add(buttonAssociate);

        this.add(panelPrincipal);
    }

    private JPanel panelCriar;
    private JTextField textFieldNome, textFieldAcronimo, textFieldDia, textFieldMes, textFieldAno, textFieldDuracao;
    private JButton buttonCriar;
    private JLabel labelNome, labelAcronimo, labelDia, labelMes, labelAno, labelDuracao;

    public void InterfaceCriarProjeto(CentroInvestigacao ci){
        //super();

        //panels
        panelCriar = new JPanel();
        panelCriar.setLayout(null);

        //labels
        labelNome = new JLabel("Nome:");
        labelNome.setBounds(20,20,100,20);
        labelAcronimo = new JLabel("Acronimo:");
        labelAcronimo.setBounds(20, 60, 100, 20);
        labelDia = new JLabel("Dia:");
        labelDia.setBounds(20, 100, 100, 20);
        labelMes = new JLabel("Mês:");
        labelMes.setBounds(20, 140, 100, 20);
        labelAno = new JLabel("Ano:");
        labelAno.setBounds(20, 180, 100, 20);
        labelDuracao = new JLabel("Duração prevista:");
        labelDuracao.setBounds(20, 220, 100, 20);

        //text fields
        textFieldNome = new JTextField();
        textFieldNome.setBounds(150, 20, 300, 20);
        textFieldAcronimo = new JTextField();
        textFieldAcronimo.setBounds(150, 60, 300, 20);
        textFieldDia = new JTextField();
        textFieldDia.setBounds(150, 100, 300, 20);
        textFieldMes = new JTextField();
        textFieldMes.setBounds(150, 140, 300, 20);
        textFieldAno = new JTextField();
        textFieldAno.setBounds(150, 180, 300, 20);
        textFieldDuracao = new JTextField();
        textFieldDuracao.setBounds(150, 220, 300, 20);

        //buttons
        buttonCriar = new JButton("Criar");
        buttonCriar.setBounds(20, 260, 430, 30);


        buttonCriar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("hello");
                try{
                    Projeto retTemp;
                    String nome = textFieldNome.getText();
                        System.out.println(nome);
                    String acronimo = textFieldAcronimo.getText();
                        System.out.println(acronimo);
                    String diaTemp = textFieldDia.getText();
                        System.out.println(diaTemp);
                    int dia = Integer.parseInt(diaTemp);
                    String mesTemp = textFieldMes.getText();
                        System.out.println(mesTemp);
                    int mes = Integer.parseInt(mesTemp);
                    String anoTemp = textFieldAno.getText();
                        System.out.println(anoTemp);
                    int ano = Integer.parseInt(anoTemp);
                    String duracaoTemp = textFieldDuracao.getText();
                        System.out.println(duracaoTemp);
                    int duracao = Integer.parseInt(duracaoTemp);

                    retTemp = new Projeto(nome, acronimo, new Data(dia, mes, ano), duracao);

                    ci.adicionaProjeto(retTemp);
                    fillSingle(nomesProjetos, retTemp);
                    System.out.println(retTemp.getNome());

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }//TODO talvez adicionar uma exceçao caso retTemp esteja vazio, idk
            }
        }); //////////////////////nao mexas na gramatica, isto esta definitivamente correto////////////////////////

        //Add everything
        panelCriar.add(labelNome);
        panelCriar.add(labelAcronimo);
        panelCriar.add(labelDia);
        panelCriar.add(labelMes);
        panelCriar.add(labelAno);
        panelCriar.add(labelDuracao);
        panelCriar.add(textFieldNome);
        panelCriar.add(textFieldAcronimo);
        panelCriar.add(textFieldDia);
        panelCriar.add(textFieldMes);
        panelCriar.add(textFieldAno);
        panelCriar.add(textFieldDuracao);
        panelCriar.add(buttonCriar);

        this.add(panelCriar);
    }



}



