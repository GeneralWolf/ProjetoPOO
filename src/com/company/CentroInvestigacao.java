package com.company;
import com.company.*;

import java.util.ArrayList;

public class CentroInvestigacao {
    private String nome;
    public ArrayList<Pessoa> membros;
    public ArrayList<Projeto> projetos;

    public ArrayList<Projeto> getProjetos(){
        return this.projetos;
    }

    public void adicionaProjeto(Projeto p){
        projetos.add(p);
                System.out.println("projeto adicionado\n");
    }

    public void adicionaMembro(Pessoa p){
        membros.add(p);
    }

    CentroInvestigacao(String nome){
        this.nome = nome;
        membros = new ArrayList<Pessoa>(150);
        projetos = new ArrayList<Projeto>(150);
    }

    public String getName(){
        return this.nome;
    }

}
