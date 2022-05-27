package perm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Perm {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner entrada  = new Scanner(new File("src/main/java/perm/testePerm.txt"));
        int numero = entrada.nextInt();


        System.out.println(fatorial(numero));
    }

    public static int fatorial(int numero){
        if (numero > 1)
           return numero * fatorial(numero -1);
        else
            return numero;
    }
}
