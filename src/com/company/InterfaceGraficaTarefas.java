package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class InterfaceGraficaTarefas extends JFrame{

    private JPanel panelTar;
    private JButton buttonCriar, buttonElim, buttonAtribuir, buttonTaxa, buttonCusto, buttonRemovePessoa;

    private DefaultListModel<String> tarefas = new DefaultListModel<String>();
    private JList<String> listTarefas = new JList<>(tarefas);
    private JScrollPane listScroller1 = new JScrollPane(listTarefas);

    private DefaultListModel<String> pessoas = new DefaultListModel<String>();
    private JList<String> listPessoas = new JList<>(pessoas);
    private JScrollPane listScroller2 = new JScrollPane(listPessoas);

    public void fillListPessoas(ArrayList<Pessoa> list){
        for(int i = 0; i < list.size(); i++){
            //lista.addElement(nome);
            pessoas.addElement(list.get(i).getNome());
        }
    }

    public void fillSinglePess(Pessoa pess){
        pessoas.addElement(pess.getNome());
                System.out.println("fillSimplePess nome: " + pess.getNome());
    }

    public void fillListTarefas(ArrayList<Tarefa> list){
        for(int i = 0; i < list.size(); i++){
            //lista.addElement(nome);
            pessoas.addElement(list.get(i).getDescritor());
        }
    }

    public void fillSingleTarefa(Tarefa tar){
        pessoas.addElement(tar.getDescritor());
                System.out.println("fillSimplePess descritor: " + tar.getDescritor());
    }

    public InterfaceGraficaTarefas(Projeto proj){
        super();

        //def panel
        panelTar = new JPanel();
        panelTar.setLayout(null);

        //def buttons
        buttonCriar = new JButton("Criar Tarefa");
        buttonCriar.setBounds(420, 20, 250, 30);
        buttonElim = new JButton("Eliminar Tarefa");
        buttonElim.setBounds(420, 70, 250, 30);
        buttonAtribuir = new JButton("Atribuir Tarefa");
        buttonAtribuir.setBounds(420, 120, 250, 30);
        buttonTaxa = new JButton("Atualizar a execução de uma tarefa");
        buttonTaxa.setBounds(420, 170, 250, 30);
        buttonCusto = new JButton("Ver o custo de um projeto");
        buttonCusto.setBounds(420, 220, 250, 30);
        buttonRemovePessoa = new JButton("Remover uma pessoa do projeto");
        buttonRemovePessoa.setBounds(420, 270, 250, 30);

        //def lists
        fillListPessoas(proj.getPessoas());
        fillListTarefas(proj.getTarefas());

        listTarefas.setBounds(20, 20, 380, 300);
        listPessoas.setBounds(20, 340, 380, 300);

        buttonCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                InterfaceCriarTarefa frame4 = new InterfaceCriarTarefa(proj);
                frame4.setTitle("Criar Tarefa");
                frame4.setSize(500, 320);
                frame4.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame4.setResizable(false);
                frame4.setVisible(true);
                //fillSingle(nomesProjetos, ci.projetos.get(ci.projetos.size() - 1));   //shit fuckin works
            }
        });

        //add everything
        panelTar.add(listTarefas);

        panelTar.add(listPessoas);

        panelTar.add(buttonCriar);
        panelTar.add(buttonElim);
        panelTar.add(buttonAtribuir);
        panelTar.add(buttonTaxa);
        panelTar.add(buttonCusto);
        panelTar.add(buttonRemovePessoa);

        panelTar.add(listTarefas);

        panelTar.add(listPessoas);

        this.add(panelTar);
    }
}
