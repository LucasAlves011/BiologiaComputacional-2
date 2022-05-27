package lcsq;

import geral.Fasta;
import geral.Funcoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static geral.Funcoes.concatEntrada;
import static geral.Funcoes.extractFasta;

public class Lcsq {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner( new File("src/main/java/lcsq/rosalind_lcsq (2).txt"));
        List<Fasta> lista = extractFasta(entrada);

        System.out.println(maiorSubsequence(lista.get(0).getData(),lista.get(1).getData()));


    }

    public static String maiorSubsequence(String inicial, String fim){
        int tInicial = inicial.length()+1;
        int tFim = fim.length()+1;
        int[][] tableDistance = new int[tInicial][tFim];

        for (int i=1; i < tInicial; i++)
            for (int j=1; j < tFim; j++) {
                if (inicial.charAt(i-1) == fim.charAt(j-1))
                    tableDistance[i][j] = tableDistance[i-1][j-1] +1;
                else
                    tableDistance[i][j] = Math.max(tableDistance[i-1][j],tableDistance[i][j-1]);
            }

        StringBuilder builder = new StringBuilder();

        int i =tInicial-1 ,j = tFim-1;
        while (i > 0 && j > 0) {
            if (tableDistance[i][j-1] == tableDistance[i - 1][j] )
                if (tableDistance[i][j-1] == tableDistance[i][j])
                    if (new Random().nextInt(2) == 0)
                        i--;
                    else
                        j--;
                else {
                    builder.append(inicial.charAt(i-1));
                    i--;
                    j--;
                }
            else if (tableDistance[i][j] == tableDistance[i - 1][j])
                i--;
            else
                j--;
        }

//        Funcoes.imprimirArray(tInicial,tFim,tableDistance);

        return builder.reverse().toString();
    }

}
