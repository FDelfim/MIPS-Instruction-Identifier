package com.main;

import java.util.Scanner;
import java.io.File;

public class main{

    public static void main(String[] args){

        try{
            File file = new File("arquivo.txt");
            Scanner sc = new Scanner(file); 

            String texto[];

            while(sc.hasNextLine())
            {
                texto = sc.nextLine().split("\n");
                for(int i = 0; i < texto.length; i++)
                {
                    String op[] = texto[i].split(" ");
                    if(op.length == 1){
                        operacao operacao = new operacao(op[0]);
                        System.out.println(operacao.operacaoValida());
                    }
                    else{
                        operacao operacao = new operacao(op[0], op[1]);
                        System.out.println(operacao.operacaoValida());
                    }
                }
            }

        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
