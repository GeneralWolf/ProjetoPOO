package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class InterfaceGraficaMega extends JFrame {

    protected JPanel panelPrincipal, panelProjeto;
    protected JButton buttonCreate, buttonSelect, buttonAssociate;
    protected CentroInvestigacao centro;
    protected Projeto projetoAtual;
    protected int indexProj, indexTar, indexPerson;

    protected DefaultListModel<String> nomesProjetos = new DefaultListModel<String>();
    protected JList<String> listProjetos = new JList<>(nomesProjetos);
    protected JScrollPane listScroller = new JScrollPane(listProjetos);

    private DefaultListModel<String> tarefas = new DefaultListModel<String>();
    private JList<String> listTarefas = new JList<>(tarefas);
    private JScrollPane listScroller1 = new JScrollPane(listTarefas);

    private DefaultListModel<String> pessoas = new DefaultListModel<String>();
    private JList<String> listPessoas = new JList<>(pessoas);
    private JScrollPane listScroller2 = new JScrollPane(listPessoas);


    public void fillListPessoas(ArrayList<Pessoa> list){
        for(int i = 0; i < list.size(); i++){
            pessoas.addElement(list.get(i).getNome());
        }
    }

    public void fillSinglePess(Pessoa pess){
        pessoas.addElement(pess.getNome());
    }

    public void fillListTarefas(ArrayList<Tarefa> list){
        for(int i = 0; i < list.size(); i++){
            tarefas.addElement(list.get(i).getDescritor());
        }
    }

    public void fillSingleTarefa(Tarefa tar){
        tarefas.addElement(tar.getDescritor());
    }

    public void fillListProj( ArrayList<Projeto> list){
        for(int i = 0; i < list.size(); i++){
            nomesProjetos.addElement(list.get(i).getNome());
        }
    }

    public void fillSingleProj(Projeto proj){
        nomesProjetos.addElement(proj.getNome());
    }

    public CentroInvestigacao getCentro(){
        return centro;
    }

    public InterfaceGraficaMega(CentroInvestigacao ci) {
        //Detalhes do painel
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(null);

        //Detalhes da lista
        fillListProj(ci.projetos);
        listScroller.setBounds(20, 20, 400, 300);

        //Detalhes dos botoes
        buttonCreate = new JButton("Criar Projeto");
        buttonCreate.setBounds(440, 20, 150, 30);
        buttonSelect = new JButton("Selecionar Projeto");
        buttonSelect.setBounds(440, 70, 150, 30);
        buttonAssociate = new JButton("Associar pessoa");
        buttonAssociate.setBounds(440, 120, 150 ,30);

        buttonCreate.addActionListener(new InterfaceCriarProjeto2());

        buttonSelect.addActionListener(new InterfaceGraficaTarefas());

        centro = ci;

        //add everything
        panelPrincipal.add(listScroller);
        listScroller.setPreferredSize(new Dimension(700, 600));     //escolhe o tamanho da lista dos projetos
        panelPrincipal.add(buttonCreate);
        panelPrincipal.add(buttonSelect);
        panelPrincipal.add(buttonAssociate);

        this.add(panelPrincipal);
        this.setTitle(centro.getName() + " - Gestor de Projetos");
        this.setSize(650, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private class InterfaceCriarProjeto2 extends JFrame implements ActionListener{
        private JPanel panelCriar;
        private JTextField textFieldNome, textFieldAcronimo, textFieldDia, textFieldMes, textFieldAno, textFieldDuracao;
        private JButton buttonCriar;
        private JLabel labelNome, labelAcronimo, labelDia, labelMes, labelAno, labelDuracao;
        private Projeto projeto;
        private JFrame frame2;
        @Override
        public void actionPerformed(ActionEvent ae) {
            this.panelCriar = new JPanel();
            frame2 = new JFrame();
            frame2.setTitle("Criar Projeto");
            frame2.setSize(480, 350);
            frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frame2.setResizable(false);
            frame2.setVisible(true);
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
            labelDuracao = new JLabel("Duração (meses):");
            labelDuracao.setBounds(20, 220, 120, 20);

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

            buttonCriar.addActionListener(new criarListener());

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
            frame2.add(panelCriar);
        }
        private class criarListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent ae) {
                try{
                    Projeto retTemp;
                    String nome = textFieldNome.getText();
                    String acronimo = textFieldAcronimo.getText();
                    String diaTemp = textFieldDia.getText();
                    int dia = Integer.parseInt(diaTemp);
                    String mesTemp = textFieldMes.getText();
                    int mes = Integer.parseInt(mesTemp);
                    String anoTemp = textFieldAno.getText();
                    int ano = Integer.parseInt(anoTemp);
                    String duracaoTemp = textFieldDuracao.getText();
                    int duracao = Integer.parseInt(duracaoTemp);

                    retTemp = new Projeto(nome, acronimo, new Data(dia, mes, ano), duracao);
                    centro.adicionaProjeto(retTemp);
                    fillSingleProj(retTemp);
                    frame2.setVisible(false);

                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    private class InterfaceGraficaTarefas extends JFrame implements ActionListener{

        private JPanel panelTar;
        private JButton buttonCriar, buttonElim, buttonAtribuir, buttonTaxa, buttonCusto, buttonRemovePessoa;
        private JTextField textFieldTaxa;
        private JFrame frameTar;

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            tarefas.clear();
            indexProj = listProjetos.getSelectedIndex();
            projetoAtual = centro.projetos.get(indexProj);

            frameTar = new JFrame();
            frameTar.setTitle("Gestão do projeto" + projetoAtual.getNome());
            frameTar.setSize(700, 700);
            frameTar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frameTar.setResizable(false);
            frameTar.setVisible(true);

            //def panel
            panelTar = new JPanel();
            panelTar.setLayout(null);

            //def textField
            textFieldTaxa = new JTextField();
            textFieldTaxa.setBounds(420, 220, 250, 30);

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
            buttonCusto.setBounds(420, 270, 250, 30);
            buttonRemovePessoa = new JButton("Remover uma pessoa do projeto");
            buttonRemovePessoa.setBounds(420, 320, 250, 30);

            buttonElim.addActionListener(new elimListener());
            buttonCriar.addActionListener(new InterfaceCriarTarefa());
            buttonTaxa.addActionListener(new updateListener());
            buttonCusto.addActionListener(new costListener());
            buttonRemovePessoa.addActionListener(new removePersonListener());
            buttonAtribuir.addActionListener(new atributePersonListener());

            //def lists
            fillListPessoas(projetoAtual.getPessoas());
            fillListTarefas(projetoAtual.getTarefas());

            listTarefas.setBounds(20, 20, 380, 300);
            listPessoas.setBounds(20, 340, 380, 300);

            //add.everything
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
            panelTar.add(textFieldTaxa);

            frameTar.add(panelTar);
        }

        private class elimListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                indexTar = listTarefas.getSelectedIndex();
                centro.projetos.get(indexProj).tarefas.remove(indexTar);
                tarefas.remove(indexTar);
            }
        }

        private class updateListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    indexTar = listTarefas.getSelectedIndex();
                    String taxaTemp = textFieldTaxa.getText();
                    double taxa = Double.parseDouble(taxaTemp);
                    centro.projetos.get(indexProj).tarefas.get(indexTar).setTaxaExecucao(taxa);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "O valor não é aceitável", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }catch(NullPointerException ex){
                    JOptionPane.showMessageDialog(null, "O campo está vazio!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        private class costListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                indexTar = listTarefas.getSelectedIndex();
                double custo = centro.projetos.get(indexProj).custoTotal();
                JOptionPane.showMessageDialog(null, custo, "Custo total: ", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        private class removePersonListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                indexPerson = listPessoas.getSelectedIndex();
                centro.projetos.get(indexProj).participantes.remove(indexPerson);
                pessoas.remove(indexPerson);
            }
        }

        private class atributePersonListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                indexPerson = listPessoas.getSelectedIndex();
                indexTar = listTarefas.getSelectedIndex();
                Pessoa resp = centro.projetos.get(indexProj).participantes.get(indexPerson);
                centro.projetos.get(indexProj).tarefas.get(indexTar).setResponsavel(resp);
            }
        }

    }

    private class InterfaceCriarTarefa extends JFrame implements ActionListener{

        private JPanel panelCriar;
        private JTextField textFieldDescritor, textFieldDia, textFieldMes, textFieldAno, textFieldDuracao;
        private JButton buttonCriarDesenvolvimento, buttonCriarDesign, buttonCriarDocumentacao;
        private JLabel labelDescritor, labelDia, labelMes, labelAno, labelDuracao;
        private JFrame frameCriar;

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            frameCriar = new JFrame();
            frameCriar.setTitle("Gestão do projeto" + projetoAtual.getNome());
            frameCriar.setSize(700, 700);
            frameCriar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frameCriar.setResizable(false);
            frameCriar.setVisible(true);

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

            buttonCriarDesenvolvimento.addActionListener(new DesenListener());
            buttonCriarDesign.addActionListener(new DesigListener());
            buttonCriarDocumentacao.addActionListener(new DocListener());

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
            frameCriar.add(panelCriar);
        }

        private class DesenListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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

                    tarTemp = new Desenvolvimento(descricao, new Data(dia, mes, ano), duracao);

                    projetoAtual.adicionarTarefa(tarTemp);
                    centro.projetos.get(indexProj).tarefas.add(tarTemp);
                    fillSingleTarefa(tarTemp);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        private class DesigListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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

                    projetoAtual.adicionarTarefa(tarTemp);
                    centro.projetos.get(indexProj).tarefas.add(tarTemp);
                    fillSingleTarefa(tarTemp);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        private class DocListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
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

                    projetoAtual.adicionarTarefa(tarTemp);
                    centro.projetos.get(indexProj).tarefas.add(tarTemp);
                    fillSingleTarefa(tarTemp);
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "Um dos valores numéricos inseridos não é aceitável!", "Valor inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

}


