/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;
import java.util.ArrayList;

public abstract class Pessoa {
    protected String nome;
    protected String email;
    protected ArrayList<Projeto> projetos;
    protected ArrayList<Tarefa> tarefas;
    
    /**
     * 
     * @param nome nome do trabalhador
     * @param email email do trabalhador
     */
    public Pessoa(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    
    /**
     * 
     * @return lista dos projetos de qual o trabalhador faz parte
     */
    public ArrayList<Projeto> returnProjetos(){
        return projetos;
    }
    
    /**
     * 
     * @return lista de tarefas associadas ao trabalhador
     */
    public ArrayList<Tarefa> returnTarefas(){
        return tarefas;
    }
    
    /**
     * 
     * @return ordenado do trabalhador
     */
    public abstract double getCusto();
    
    /**
     * Associa uma tarefa ao trabalhador
     * @param tarefa tarefa a associar
     * @return 1 se a tarefa foi associada com sucesso ou 0 se o trabalhador está sobrecarregado.
     */
    public int adicionaTarefa(Tarefa tarefa){
        double esf = 0;
        for(int i=0;i<tarefas.size();i++){
            esf = esf + tarefas.get(i).getTaxaEsforco();
        }
        if(esf + tarefa.getTaxaEsforco() <=1){
            tarefas.add(tarefa);
            tarefa.setResponsavel(this);
            return 1;
        }
        else{return 0;}
    }
    
    /**
     * Adiciona o trabalhador a um projeto.
     * @param projeto projeto ao qual o trabalhador vai ser adicionado
     * @return 1 se o trabalhador foi adicionado com sucesso ou 0 se o trabalhador não pode ser adicionado a mais projetos.
     */
    public abstract int adicionaProjeto(Projeto projeto);
}
