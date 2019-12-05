/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;


public abstract class Formando extends Bolseiro{
    protected Pessoa orientador;
    public Formando(String nome, String email, Data inicioBolsa, Data fimBolsa, Pessoa orientador){
    super(nome,email,inicioBolsa, fimBolsa);
    this.orientador = orientador;
    }
    public void setOrientador(Pessoa orientador){
        this.orientador = orientador;
    }
    public Pessoa getOrientador(){
        return this.orientador;
    }
}
