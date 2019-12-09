package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InterfaceCriarProjeto extends JFrame {
    private JPanel panelCriar;
    private JTextField textFieldNome, textFieldAcronimo, textFieldDia, textFieldMes, textFieldAno, textFieldDuracao;
    private JButton buttonCriar;
    private JLabel labelNome, labelAcronimo, labelDia, labelMes, labelAno, labelDuracao;

    public InterfaceCriarProjeto(){
        super();

        panelCriar = new JPanel();
        panelCriar.setLayout(null);


        //labels
        labelNome = new JLabel("Nome:");

        labelAcronimo = new JLabel("Acronimo:");

        labelDia = new JLabel("Dia:");

        labelMes = new JLabel("Mês:");

        labelAno = new JLabel("Ano:");

        labelDuracao = new JLabel("Duração prevista:");


        //text fields
        textFieldNome = new JTextField();

        textFieldAcronimo = new JTextField();

        textFieldDia = new JTextField();

        textFieldMes = new JTextField();

        textFieldAno = new JTextField();

        textFieldDuracao = new JTextField();


        //buttons
        buttonCriar = new JButton("Criar");


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
