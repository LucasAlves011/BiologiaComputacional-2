package geral;

//import splc.Splc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Funcoes {

    public static ArrayList<Fasta> extractFasta(Scanner entrada){
        StringBuilder builder = new StringBuilder();
        concatEntrada(entrada,builder);
        ArrayList<Fasta> listaFasta = new ArrayList<>();
        addFastaToList(builder,listaFasta);
        return listaFasta;
    }

    public static void addFastaToList(StringBuilder builder, List<Fasta> lista){
        String[] x =  String.valueOf(builder).split("\\|");
        for (int i=1; i < x.length; i+=2) {
            lista.add(new Fasta(x[i],x[i+1]));
        }
    }

    public static void concatEntrada(Scanner entrada, StringBuilder nome) {
        String buffer;
        while (entrada.hasNext()){
            buffer = entrada.nextLine();
            if (buffer.charAt(0) == '>')
                nome.append("|" + buffer + "|");
            else
                nome.append(buffer);
        }
    }

    public static void imprimirArray(int x, int y,int[][] table){
        for (int i=0; i < x; i++) {
            for (int j=0; j < y; j++)
                System.out.print(table[i][j]+ " ");
            System.out.print("\n");
        }
    }

    public static int returnMinor(int x,int ... numbers){
        int temp = x ;
        for (int p: numbers) if (p < temp) temp = p;
        return temp;
    }

    public static int returnBigger(int x, int ... numbers){
        int temp = x;
        for (int p: numbers) if (p > temp) temp = p;
        return temp;
    }

}
