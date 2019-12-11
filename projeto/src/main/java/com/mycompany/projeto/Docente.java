/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;


public class Docente extends Pessoa{
    private int nrMecanografico;
    private String areaInvestigacao;
    public Docente(String nome, String email,int nrMecanografico, String areaInvestigacao){
        super(nome,email);
        this.nrMecanografico = nrMecanografico;
        this.areaInvestigacao = areaInvestigacao;
    }
    public String getArea(){
        return areaInvestigacao;
    }
    public int getNum(){
        return nrMecanografico;
    }
    @Override
    public double getCusto(){
        return 0;
    }
    
    @Override
    public int adicionaProjeto(Projeto projeto){
        super.projetos.add(projeto);
        projeto.associarPessoa(this);
        return 1;
    }
}
