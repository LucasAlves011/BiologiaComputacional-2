package splc;

import geral.Aminoacido;
import geral.Fasta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static geral.Aminoacido.aminoacidos;
import static geral.Funcoes.addFastaToList;
import static geral.Funcoes.concatEntrada;

public class Splc {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner entrada = new Scanner(new File("src/main/java/splc/rosalind_splc (2).txt"));

        ArrayList<Fasta> listaFasta = new ArrayList<>();

        StringBuilder nome=new StringBuilder();

        String buffer;
        concatEntrada(entrada, nome);

        addFastaToList(nome,listaFasta);

        System.out.println(transcricao(algumaCoisa(listaFasta)));

    }

    public static String algumaCoisa(ArrayList<Fasta> listaFasta){
        String newEntrada = listaFasta.get(0).getData().replaceAll(listaFasta.get(1).getData(),"");
        for (int i=2; i < listaFasta.size(); i++)
            newEntrada = newEntrada.replaceAll(listaFasta.get(i).getData(),"");

        newEntrada = newEntrada.replaceAll("T","U");
        return newEntrada;
    }

    public static String transcricao(String newEntrada){
        StringBuilder codonBuilder = new StringBuilder();
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < newEntrada.length(); i += 3) {
            codonBuilder.append(newEntrada.charAt(i));
            codonBuilder.append(newEntrada.charAt(i + 1));
            codonBuilder.append(newEntrada.charAt(i + 2));
            output.append(aminoacidos.stream().filter(n -> n.getCodons().contains(String.valueOf(codonBuilder))).map(Aminoacido::getAbbreviation).toList().get(0));
            codonBuilder.delete(0,3);
        }
        return String.valueOf(output).replaceAll("\n","");
    }

//    public static void addFastaToList(StringBuilder builder, List<Fasta> lista){
//       String[] x =  String.valueOf(builder).split("\\|");
//        for (int i=1; i < x.length; i+=2) {
//            lista.add(new Fasta(x[i],x[i+1]));
//        }
//    }
}
