package hamm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hamm {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner entrada = new Scanner(new File("src/hamm/rosalind_hamm.txt"));

        String string1 = entrada.nextLine();
        String string2 = entrada.nextLine();

        int contador = 0;
        for (int i=0; i < string1.length(); i++) {
            if (string1.charAt(i) != string2.charAt(i))
                contador++;
        }
        System.out.println(contador);

    }
}
