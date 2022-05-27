package edit;

import geral.Funcoes;
import geral.Fasta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Edit {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner entrada = new Scanner(new File("src/main/java/edit/rosalind_edit.txt"));

        ArrayList<Fasta> listaFasta =  Funcoes.extractFasta(entrada);

        System.out.println(editDistance(listaFasta.get(0).getData(),listaFasta.get(1).getData()));

    }
    public static int editDistance(String inicial, String fim){

        int tInicial = inicial.length()+1;
        int tFim = fim.length()+1;
        int[][] tableDistance = new int[tInicial][tFim];

        tableDistance[0][0] = 0;

        for (int i=1; i < tFim; i++)
            tableDistance[0][i] = i;

        for (int i=1; i < tInicial; i++)
            tableDistance[i][0] = i;

        for (int i=1; i < tInicial; i++) {
            for (int j=1; j < tFim; j++) {
                if (inicial.charAt(i-1) == fim.charAt(j-1))
                    tableDistance[i][j] = tableDistance[i-1][j-1];
                else
                    tableDistance[i][j] = 1 + Funcoes.returnMinor(tableDistance[i-1][j],tableDistance[i][j-1],tableDistance[i-1][j-1]);
            }
        }
//        imprimirArray(tInicial,tFim,tableDistance);
        return tableDistance[tInicial-1][tFim-1];
    }
}
