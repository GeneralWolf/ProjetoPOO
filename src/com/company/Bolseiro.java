/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


public abstract class Bolseiro extends Pessoa {
    protected Data inicioBolsa;
    protected Data fimBolsa;
    public Bolseiro(String nome, String email, Data inicioBolsa, Data fimBolsa){
    super(nome,email);
    this.inicioBolsa = inicioBolsa;
    this.fimBolsa = fimBolsa;
    }
    @Override
    public int adicionaProjeto(Projeto projeto){
        if(super.returnProjetos().size()<1){
            super.projetos.add(projeto);
            projeto.associarPessoa(this);
            return 1;
        }
        else{return 0;}
    }
}
