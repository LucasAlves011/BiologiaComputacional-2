package Sseq;

import geral.Fasta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static geral.Funcoes.*;

public class Sseq {
    public static void main(String[] args) throws FileNotFoundException {

//        Scanner entrada = new Scanner(new File("src/main/java/Sseq/entrada.txt"));
//        Scanner entrada = new Scanner(new File("src/main/java/Sseq/testeRosaling.txt"));
        Scanner entrada = new Scanner(new File("src/main/java/Sseq/rosalind_sseq.txt"));
        StringBuilder nome = new StringBuilder();
        String buffer;

        ArrayList<Fasta> lista = new ArrayList<Fasta>();

        while (entrada.hasNext()){
            buffer = entrada.nextLine();
            if (buffer.charAt(0) == '>')
                nome.append("|" + buffer + "|");
            else
                nome.append(buffer);
        }

        addFastaToList(nome,lista);

        int index = 0;
        ArrayList<Integer> indexs = new ArrayList<>();

        String dados = lista.get(0).getData(); //MAIOR
        String subcadeia = lista.get(1).getData(); //MENOR

        for (int i=0; i < dados.length(); i++) {
            if (index < subcadeia.length() && dados.charAt(i) == subcadeia.charAt(index) ){
                indexs.add(i+1);
                index++;
            }
        }

        for (int i=0; i < indexs.size(); i++) {
            System.out.print(indexs.get(i) + " ");
        }
    }

}
