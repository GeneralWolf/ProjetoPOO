/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projeto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

/**
 *
 * @author Diogo
 */


public class Startup {
    /**
     * Devolve uma data aleatória através desde a data atual até um intervalo dado em anos.
     * @param inter intervalo em anos. Ex.: -3 devolve uma data aleatória dos últimos 3 anos; 3 devolve uma data aleatória dos próximos 3 anos.
     * @return data aleatória
     */
     public static Data randomData(int inter){
        LocalDateTime now = LocalDateTime.now();  
        Random r = new Random();
        LocalDateTime d = LocalDateTime.of(1970, Month.JANUARY, 1, 0, 0);
        do{
            int dia = r.ints(1,31).findAny().getAsInt();
            int mes = r.ints(1,12).findAny().getAsInt();
            int ano = 1970;
            if(inter>0){
                ano = r.ints(now.getYear(),now.getYear()+inter).findAny().getAsInt();
            } 
            else if (inter<0){
                ano = r.ints(now.getYear()+inter,now.getYear()).findAny().getAsInt();
            }
            try{
                d = LocalDateTime.of(ano, mes, dia, 0, 0);
                
            }
            catch(Exception e){
            }   
        }
        while(d.isAfter(now)&& inter<0 || d.isBefore(now)&& inter >0);
        Data data = new Data(d.getDayOfMonth(),d.getMonthValue(),d.getYear());
        return data;
    }
    /**
     * Cria um centro de investigação através de um documento .txt
     * @param fich documento .txt com o nome do centro e uma lista de pessoas
     * @return centro de investigação originado
     */
    public static CentroInvestigacao startupReader(String fich){
        File f = new File(fich);
        CentroInvestigacao c= new CentroInvestigacao();
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String l = br.readLine();
            c.setName(l);
            while(l!=null){
                l =br.readLine();
                String split[];
                try{
                    split = l.split("\t");
                }
                catch(Exception e){
                    break;
                }
                if(split[0].equals("D")){
                    Docente docente = new Docente(split[1],split[2]+"@"+c.getName().toLowerCase().replace(" ", "")+".pt",Integer.parseInt(split[3]),split[4]);
                    c.addMembro(docente);
                }
                else if(split[0].equals("L")){
                    Licenciado lic = new Licenciado(split[1],split[2]+"@"+c.getName().toLowerCase().replace(" ", "")+".pt",randomData(-3),randomData(3));
                    c.addMembro(lic);
                }
                else if(split[0].equals("M")){
                    Mestre mest = new Mestre(split[1],split[2]+"@"+c.getName().toLowerCase().replace(" ", "")+".pt",randomData(-3),randomData(3));
                    c.addMembro(mest);
                }   
                else if(split[0].equals("Dt")){
                    Doutorado dout = new Doutorado(split[1],split[2]+"@"+c.getName().toLowerCase().replace(" ", "")+".pt",randomData(-3),randomData(3));
                    c.addMembro(dout);
                }
            }
            return c;
        }catch (FileNotFoundException e1){
            System.out.print("Ficheiro startup.txt não encontrado.");
            System.exit(0);
        }
        catch(IOException e2){
            System.out.print("Ficheiro startup.txt corrompido.");
            System.exit(0);
        }
        return c;
    }
}
