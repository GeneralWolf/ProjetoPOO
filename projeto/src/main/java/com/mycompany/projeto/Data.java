package com.mycompany.projeto;

import java.io.Serializable;

public class Data implements Serializable{
    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public int getDia(){
        return this.dia;
    }

    public int getMes(){
        return this.mes;
    }

    public int getAno(){
        return this.ano;
    }
    public static int getDiferencaMeses(Data a, Data b){
        return  (Math.abs(a.getAno()-b.getAno())+1)*12 - Math.abs(a.getMes() -b.getMes());
    }
    public String toString(){
        return dia + "/" + mes + "/" + ano;
    }
}
