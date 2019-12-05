/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;


public class Licenciado extends Formando{
    public Licenciado(String nome, String email, Data inicioBolsa, Data fimBolsa, Pessoa orientador){
        super(nome,email,inicioBolsa, fimBolsa,orientador);
    }
    @Override
    public double getCusto(){
        return 800;
    }
}
