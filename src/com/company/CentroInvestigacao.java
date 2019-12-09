package com.company;
import com.company.*;

import java.util.ArrayList;

public class CentroInvestigacao {
    public ArrayList<Pessoa> membros;
    public ArrayList<Projeto> projetos;


    //test check
    //String nome, String acronimo, Data dataInicio, /*Data dataFim,*/ int duracaoMeses

    //TODO check this shit out again
    /*
    public String[] getProjetos(){
        projetos.add(new Projeto("hello", "hll", new Data(23, 12, 2222), 5));
        String[] nomesProj = new String[projetos.size()];
        for (int i = 0; i < projetos.size(); i++) {
            nomesProj[i] = projetos.get(i).getNome();
            System.out.println(nomesProj[i]);
        }
        return nomesProj;
    }
*/

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

//testetestestsets