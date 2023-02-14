/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author aluno
 */
public class Arquivos {

    public static void ler(String caminho) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(caminho));
        String linha = "";
        String regVariavel = "\\$((t|s)[0-9])";
        String expressaoSoma = "add " + regVariavel + "," + regVariavel + "," + regVariavel;
        String expressaoSubtracao = "sub " + regVariavel + "," + regVariavel + "," + regVariavel;
        String expressaoCarrega = "lw " + regVariavel + ",[0-9]{1,7}\\(" + regVariavel + "\\)";
        String expressaoSalva = "sw " + regVariavel + ",[0-9]{1,7}\\(" + regVariavel + "\\)";
        String linhaVazia = "s*";

        linha = buffRead.readLine();
        while (true) {
            if (linha == null) {
                break;
            }

            if (linha.matches(expressaoSoma)) {
                System.out.println(linha + ": Operação de adição");
            } else if (linha.matches(expressaoSubtracao)) {
                System.out.println(linha + ": Operação de subtração");
            } else if (linha.matches("memory\\[*[0-9]\\]")) {
                System.out.println(linha + ": Operação de memória");
            } else if (linha.matches(expressaoCarrega)){
                System.out.println(linha + ": Operação carregar");
            } else if (linha.matches(expressaoSalva)){
                System.out.println(linha + ": Operação salvar");
            } else if (linha.matches(linhaVazia)){
                
            }else{
                System.out.println(linha + ": Operação inválida.");
            }
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
}
