package com.company;

import com.company.CentroInvestigacao;
import com.company.Data;

public class Main {

    public static void main(String[] args) {


        CentroInvestigacao test = new CentroInvestigacao();
        test.adicionaProjeto(new Projeto("Test1", "t1", new Data(23,42,1000), 8));

    }
}
