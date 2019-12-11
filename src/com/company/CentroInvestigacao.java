package com.company;
import com.company.*;

import java.util.ArrayList;

public class CentroInvestigacao {
    public ArrayList<Pessoa> membros;
    public ArrayList<Projeto> projetos;

    public ArrayList<Projeto> getProjetos(){
        return this.projetos;
    }

    public void adicionaProjeto(Projeto p){
        projetos.add(p);
    }

    public void adicionaMembro(Pessoa p){
        membros.add(p);
    }

    CentroInvestigacao(){
        membros = new ArrayList<Pessoa>(150);
        projetos = new ArrayList<Projeto>(150);
    }

}
