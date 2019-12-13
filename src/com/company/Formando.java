/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;


public abstract class Formando extends Bolseiro{
    protected Pessoa orientador;
    public Formando(String nome, String email, Data inicioBolsa, Data fimBolsa){
    super(nome,email,inicioBolsa, fimBolsa);
    }
    public void setOrientador(Pessoa orientador){
        this.orientador = orientador;
    }
    public Pessoa getOrientador(){
        return this.orientador;
    }
}
