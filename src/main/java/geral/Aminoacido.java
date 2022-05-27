package geral;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public @Data class Aminoacido {
    public static Aminoacido alaninas = new Aminoacido("Alalina",'A', List.of("GCU","GCC","GCA","GCG"));
   public static Aminoacido argininas = new Aminoacido("Arginina",'R', List.of("CGU","CGC","CGA","CGG","AGA","AGG"));
   public static Aminoacido asparaginas = new Aminoacido("Asparagina",'N', List.of("AAU","AAC"));
   public static Aminoacido acidosAsparticos = new Aminoacido("Ácido Aspártico",'D', List.of("GAU","GAC"));
   public static Aminoacido acidosGlutamicos = new Aminoacido("Ácido Glutâmico",'E', List.of("GAA","GAG"));
   public static Aminoacido cisteinas = new Aminoacido("Cisteína",'C', List.of("UGU","UGC"));
   public static Aminoacido glicinas = new Aminoacido("Glicina",'G', List.of("GGU","GGC","GGA","GGG"));
   public static Aminoacido glutaminas = new Aminoacido("Glutamina",'Q', List.of("CAA","CAG"));
   public static Aminoacido histidinas = new Aminoacido("Histidina",'H', List.of("CAU","CAC"));
   public static Aminoacido isoleucinas = new Aminoacido("Isoleucina",'I', List.of("AUU","AUC","AUA"));
   public static Aminoacido leucinas = new Aminoacido("Leucina",'L', List.of("UUA","UUG","CUU","CUC","CUA","CUG"));
   public static Aminoacido lisinas = new Aminoacido("Lisina",'K', List.of("AAA","AAG"));
   public static Aminoacido metioninas = new Aminoacido("Metionina",'M', List.of("AUG")); // CODON DE INICIAÇÃO
   public static Aminoacido fenilalaninas = new Aminoacido("Fenilalanina",'F', List.of("UUU","UUC"));
   public static Aminoacido prolinas = new Aminoacido("Prolinas",'P', List.of("CCU","CCC","CCA","CCG"));
   public static Aminoacido serinas = new Aminoacido("Serina",'S', List.of("UCU","UCC","UCA","UCG","AGU","AGC"));
   public static Aminoacido tirosinas = new Aminoacido("Tirosina",'Y', List.of("UAU","UAC"));
   public static Aminoacido treoninas = new Aminoacido("Treonina",'T', List.of("ACU","ACC","ACA","ACG"));
   public static Aminoacido triptofanos = new Aminoacido("Triptofano",'W', List.of("UGG"));
   public static Aminoacido valinas = new Aminoacido("Valina",'V', List.of("GUU","GUC","GUA","GUG"));
   public static Aminoacido codonsParada = new Aminoacido("Codons de Parada",'\n', List.of("UAA","UAG","UGA")); //CONDOS DE PARADA

    public static ArrayList<Aminoacido> aminoacidos = new ArrayList<>(List.of(alaninas, argininas, asparaginas, acidosAsparticos, acidosGlutamicos, cisteinas,
            glicinas,glutaminas,histidinas,isoleucinas,leucinas,lisinas,metioninas,fenilalaninas,prolinas,serinas,tirosinas,
            treoninas,treoninas,triptofanos,valinas,codonsParada));

    String name;
    char abbreviation;
    HashSet<String> codons = new HashSet<>();

    public Aminoacido(String name, char abbreviation, List<String> codons) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.codons.addAll(codons);
    }


    @Override
    public String toString() {
        return "Aminoacido{" +
                "name='" + name + '\'' +
                ", abbreviation=" + abbreviation +
                ", codons=" + codons +
                '}';
    }
}