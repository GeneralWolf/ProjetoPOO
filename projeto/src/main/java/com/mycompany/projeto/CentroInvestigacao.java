package com.mycompany.projeto;
import java.util.ArrayList;
import java.io.Serializable;

public class CentroInvestigacao implements Serializable{
    private String nome;
    private ArrayList<Pessoa> membros;
    private ArrayList<Projeto> projetos;

    public CentroInvestigacao() {
        this.membros = new ArrayList();
        this.projetos = new ArrayList();
    }
    public void setName(String nome){
        this.nome = nome;
        membros.forEach((membro) -> {
            membro.setEmail(membro.getEmail().split("@")[0]+"@"+nome.toLowerCase().replace(" ", "")+".pt");
        });
    }
    public String getName(){
        return nome;
    }
    public void addMembro(Pessoa pessoa){
        membros.add(pessoa);
    }
    public ArrayList<Pessoa> getMembros(){
        return membros;
    } 
    public void addProjeto(Projeto projeto){
        projetos.add(projeto);
    }
    public ArrayList<Projeto> getProjetos(){
        return projetos;
    }
}

//testetestestsets