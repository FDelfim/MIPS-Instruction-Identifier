package com.main;

import java.util.Scanner;
import java.io.File;

class main {
    public static void main(String args[]) {

        String reg = "\\$(t||s)[0-9]";
        String soma = "add " + reg + "," + reg + "," + reg;
        String sub = "sub " + reg + "," + reg + "," + reg;
        String sw = "sw " + reg + "," + "[0-10000]" + "(" + reg + ")";
        String lw = "lw " + reg + "," + "[0-10000]" + "(" + reg + ")";
        String memory = "memory\\[" + "[0-9]" + "\\]";

        try {
            File file = new File("arquivo.txt");
            Scanner sc = new Scanner(file);

            String texto[];

            while (sc.hasNextLine()) {
                texto = sc.nextLine().split("\n");
                for (int i = 0; i < texto.length; i++) {
                    if (texto[i].matches(soma)) {
                        System.out.println(texto[i] + " Operação de soma\n");
                    }
                    if (texto[i].matches(sub)) {
                        System.out.println(texto[i] + " Operação de subtração\n");
                    }
                    if (texto[i].matches(sw)) {
                        System.out.println(texto[i] + " Operação SW\n");
                    }
                    if (texto[i].matches(lw)) {
                        System.out.println(texto[i] + " Operação LW\n");
                    }
                    if (texto[i].matches(memory)) {
                        System.out.println(texto[i] + " Operação memory\n");
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}