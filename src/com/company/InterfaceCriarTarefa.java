package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceCriarTarefa extends InterfaceGraficaTarefas {

    private JPanel panelCriar;
    private JTextField textFieldDescritor, textFieldDia, textFieldMes, textFieldAno, textFieldDuracao;
    private JButton buttonCriarDesenvolvimento, buttonCriarDesign, buttonCriarDocumentacao;
    private JLabel labelDescritor, labelDia, labelMes, labelAno, labelDuracao;

    public InterfaceCriarTarefa(Projeto proj) {
        super(proj);

        panelCriar = new JPanel();
        panelCriar.setLayout(null);

        //labels
        labelDescritor = new JLabel("Descrição:");
        labelDescritor.setBounds(20,20,100,20);
        labelDia = new JLabel("Dia:");
        labelDia.setBounds(20, 60, 100, 20);
        labelMes = new JLabel("Mês:");
        labelMes.setBounds(20, 100, 100, 20);
        labelAno = new JLabel("Ano:");
        labelAno.setBounds(20, 140, 100, 20);
        labelDuracao = new JLabel("Duração prevista:");
        labelDuracao.setBounds(20, 180, 100, 20);

        //text fields
        textFieldDescritor = new JTextField();
        textFieldDescritor.setBounds(150, 20, 300, 20);
        textFieldDia = new JTextField();
        textFieldDia.setBounds(150, 60, 300, 20);
        textFieldMes = new JTextField();
        textFieldMes.setBounds(150, 100, 300, 20);
        textFieldAno = new JTextField();
        textFieldAno.setBounds(150, 140, 300, 20);
        textFieldDuracao = new JTextField();
        textFieldDuracao.setBounds(150, 180, 300, 20);

        //buttons
        buttonCriarDesenvolvimento = new JButton("Desenvolvimento");
        buttonCriarDesenvolvimento.setBounds(20, 220, 140, 30);
        buttonCriarDesign = new JButton("Design");
        buttonCriarDesign.setBounds(175, 220, 140, 30);
        buttonCriarDocumentacao = new JButton("Documentação");
        buttonCriarDocumentacao.setBounds(330, 220, 140, 30);

        buttonCriarDesenvolvimento.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    Tarefa tarTemp;
                    String descricao = textFieldDescritor.getText();
                            System.out.println(descricao);
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

                    tarTemp = new Desenvolvimento(descricao, new Data(dia, mes, ano), duracao);

                    proj.adicionarTarefa(tarTemp);
                    fillSingleTarefa(tarTemp);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonCriarDesign.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    Tarefa tarTemp;
                    String descricao = textFieldDescritor.getText();
                    String diaTemp = textFieldDia.getText();
                    int dia = Integer.parseInt(diaTemp);
                    String mesTemp = textFieldMes.getText();
                    int mes = Integer.parseInt(mesTemp);
                    String anoTemp = textFieldAno.getText();
                    int ano = Integer.parseInt(anoTemp);
                    String duracaoTemp = textFieldDuracao.getText();
                    int duracao = Integer.parseInt(duracaoTemp);

                    tarTemp = new Design(descricao, new Data(dia, mes, ano), duracao);

                    proj.adicionarTarefa(tarTemp);
                    fillSingleTarefa(tarTemp);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buttonCriarDocumentacao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    Tarefa tarTemp;
                    String descricao = textFieldDescritor.getText();
                    String diaTemp = textFieldDia.getText();
                    int dia = Integer.parseInt(diaTemp);
                    String mesTemp = textFieldMes.getText();
                    int mes = Integer.parseInt(mesTemp);
                    String anoTemp = textFieldAno.getText();
                    int ano = Integer.parseInt(anoTemp);
                    String duracaoTemp = textFieldDuracao.getText();
                    int duracao = Integer.parseInt(duracaoTemp);

                    tarTemp = new Documentacao(descricao, new Data(dia, mes, ano), duracao);

                    proj.adicionarTarefa(tarTemp);
                    fillSingleTarefa(tarTemp);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panelCriar.add(textFieldDescritor);
        panelCriar.add(textFieldDia);
        panelCriar.add(textFieldMes);
        panelCriar.add(textFieldAno);
        panelCriar.add(textFieldDuracao);
        panelCriar.add(labelDescritor);
        panelCriar.add(labelDia);
        panelCriar.add(labelMes);
        panelCriar.add(labelAno);
        panelCriar.add(labelDuracao);
        panelCriar.add(buttonCriarDesenvolvimento);
        panelCriar.add(buttonCriarDesign);
        panelCriar.add(buttonCriarDocumentacao);


        this.add(panelCriar);
    }
}
