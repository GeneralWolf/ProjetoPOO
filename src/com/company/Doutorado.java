/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;


public class Doutorado extends Bolseiro {
    public Doutorado(String nome, String email, Data inicioBolsa, Data fimBolsa){
        super(nome,email,inicioBolsa, fimBolsa);
    }
    @Override
    public double getCusto(){
        return 1200;
    }
}
