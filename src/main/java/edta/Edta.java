package edta;

import edit.Edit;
import geral.Fasta;
import geral.Funcoes;
import mylibraries.Colors;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Edta {
    public static final int MATCH = 1; // 0
    public static final int MISMATCH =  -3; // 1
    public static final int GAP = -4;
    // MATCH = 2 ,MISMATCH = -4,GAP = -1
    // MATCH = 1 ,MISMATCH = -1,GAP = -2

    public static void main(String[] args) throws IOException {
//        alinhamento("CAT","CONCAT");
//        alinhamento("PRETTY","PRTTEIN");
//        alinhamento("ACGGCTC","ATGGCCTC");
//        alinhamento("PLEASANTLY","MEANLY");
//        alinhamento("FASDGTGSCHRBRFCOFEDFH","NMGSDFCSDFSCOFEAA");
//        alinhamento("FWKCCAHANKAQDCCIIRDFQMETTYSDCRTFHQPYGWEILDTWHLPFLPGNHEPKFNEERCNRSAMIWHWTQKTDINKIFAKYRESTYSHQQWIGEKQYLCFQSEGVWWCSGWKTIMEGIVSQPYNQRQPMMCWSWQEQVHFQNRKIIKESFSMMGRTNHDINELPSRMWYYKMDHDNFEKRCIYEADWERGTMGMLAPATIGWNPTHDHSDCMHRVQWFQLLINRPAIPMHEEGGKNCREATQSLESCSDWKQLSCDGCPCSVYHERPSSFWDHITYYHDQTGTELQKVWECRGLMVYKFVEYVHRAQRSMGVRKAECIAKGAVPCDVTWNAEDISSKQSDRYICPKYYIKYMLCWIHNVHVREYCARDQCLFILCMNMYPQEHIHMSYKQYAWWLKERYKHFVDYLEMHQSHYFPKHEERITWHIERPRAPIMVNPPCTSLHRKWFLFHWLSEIHVDVAIMCSEDELFCHMAYENRCMCEYIKADQLLFSTPQGKLYASNTSLGKKQLVNFCQIMGMGWMCASVKQWNQMCNAKTKVACCAYTLQSCDHCPWWAWLAPNDYLKGQDCQSHDQRPNIDPCPWLRHTKLVCKEFPIWASKRMEKMIFGERHHFSRYDNGGNESAPGRQAFEFCSPKLCKRLHVTSYLPNVCQQGASHHRMWITTDCTCNKRILVPIWCPMATGDFQMAQMMVPPQAYEVRYLNFLMPACAIYTVYKFNASEVMDWCAKIFELAQWAMDDQMTAFCRGYQSNDKEM"
//               ,"AWMCCCRGCHHHANKAQDCSMCEHMETTYSDCRTFYHPPGIISGTFKEILDTWLGPREYELPFLGGPKRSKTDINKIFADYRESTYSHQQWIHEKQYLCFQSEGVWWCSGWKQMWISIMQENNSGVGGWGYQVSQTMMSFSMMNINGLPPRMVYYKMDHVYKWGYWNFEKRCIYEADWERGEAPATIGWNPTHDHSDCMHRVQWFQLLINRPAIPMCEVGATQSLEAWFDHCSDWKMFYIGGYDHITYYSNDMTGMIDIKDLVELFRLCARECRGLMVYKFVEYVHRAQRSMGSRKAECIMAWLGKGDVPCDVTKQSDRYICCTFIERKYIKYMLCWIHNVVIINFAISCARDNDTLSRSICLFNMYPQEHIHMSLKERPKHFVDNQQSSKEQNLEMHTKNCDDSHYEVRNVPKHEETWHIDIFTYKRMPIMVQPPCTEAHRKWCKNQQGVMMNFHIHVDVAIMCSEDELFCESKYFMAYENGEAEQLVCMMSFHWETIKAMQLLFSTPNIWHHAWPKGKLYNWPNQSNESLGKKQLVNFCQIMGMGWMCASSAPFRVHQKVGFATVRWVIECPQICNAREKVTIALDTKVACCAYTLYDRIYKFPDMPFEECIKDHCFWWAWLAPNDYLKQQDCQWPRTKSGPWGHVCKEDPIWASKRMEKMIFGERHHFSQYDNGGNFSAPGRQAFEFCHVTSYITNVCQQGASHHRMWITTDCECNKPIWDFEFASIRMYQCKLWEVRTVKMLNFLMPACAIYKRKSDSVLLAPKFSASEVMDWCAKIKELSQWYTDKQAMDDCIGYRSNDKEM");
        Scanner entrada = new Scanner(new File(   "src/main/java/edta/rosalind_edta (8).txt"));
        List<Fasta> fastas =Funcoes.extractFasta(entrada);

        alinhamento(fastas.get(0).getData(),fastas.get(1).getData());

//        comparar("KCCPTFFSTKPLNSQ-PK----EEWN-V-----KTQESCAFWAEGL----NNRGEKWVMRMQSGGGFCARAGTVTQPCQSWHEANHLVDQDSTQWIFLIDDSPKKT-CKDKPIS-KIPTNIHAAWSRPGLHPASLEP---VGLYWLAYG-RISWNY-NSCRTDNRCCQDKMVSAMDAGSMKADYYWPKVTAFVTSESPYDHWTEKNVERAWILNRWMQFGHSVPLV------ATRHIEWNNHTSWCMRAATDQPDIIWEQHNVLRASTCHETMR---HMMC-YITA----LCHLNS--PSDGYVEGEAARLWQPEVFRDMIKLPPVQRDYIN-LLTRARSLQDWTWTDYRCSKEWFFKDSEITTDMD-----H-----P---SSK----C-MMYIYMNTDT-------GSTKIS-VDW--AWQDETTECLHICPCPFIECLMEFWGHLKECSSRKTVAWWRHCEMMIQKPHMYSVMACRAAHNISSTGEHHMTMICHQIQIILNEYANLQTLKYGRTKRMNWFTYRMLFTSDENFFPISHLM-----IYAYNMVNWGET-RQKYFN-CE-EDPTTW-LSRKMTDSFIAGMWTYWWHFLKMEFWEDFRKDRLGGRIEPRVMSIQWWEWGRHLAILDYG-S--CMTNKLQYWEKAGWHEDPQ-NTPVWIYQNWWSSVSWGTCLLRKITFARMTFFLMPIMCCWYVQGTIPYSMDVMGWESWNLDLVAWWPWLQQRWGDYSEQTVCEGGKWYHDKMMVTMIPHGFRQEEVGGLWTNDCDTGGQGLQMNITHY----WRWHQR---R-WNQTRKMPAMAMKWDAYAIISPNLRVSVCCLCL"
//                ,"KCCPTFFSTKPLNSQ-PK----EEWN-V-----KTQESCAFWAEGL----NNRGEKWVMRMQSGGGFCARAGTVTQPCQSWHEANHLVDQDSTQWIFLIDDSPKKT-CKDKPIS-KIPTNIHAAWSRPGLHPASLEP---VGLYWLAYG-RISWNY-NSCRTDNRCCQDKMVSAMDAGSMKADYYWPKVTAFVTSESPYDHWTEKNVERAWILNRWM--QFGHSVPLVATRHIEWNNHTSWCMRAATDQPDIIWEQHNVLRASTCHETMR---HMMC-YITA----LCHLNS--PSDGYVEGEAARLWQPEVFRDMIKLPPVQRDYIN-LLTRARSLQDWTWTDYRCSKEWFFKDSEITTDMD-----H-----P---SSK----C-MMYIYMNTDT-------GSTKIS-VDW--AWQDETTECLHICPCPFIECLMEFWGHLKECSSRKTVAWWRHCEMMIQKPHMYSVMACRAAHNISSTGEHHMTMICHQIQIILNEYANLQTLKYGRTKRMNWFTYRMLFTSDENFFPISHLM-----IYAYNMVNWGET-RQKYFN-CE-EDPTTW-LSRKMTDSFIAGMWTYWWHFLKMEFWEDFRKDRLGGRIEPRVMSIQWWEWGRHLAILDYG-S--CMTNKLQYWEKAGWHEDPQ-NTPVWIYQNWWSSVSWGTCLLRKITFARMTFFLMPIMCCWYVQGTIPYSMDVMGWESWNLDLVAWWPWLQQRWGDYSEQTVCEGGKWYHDKMMVTMIPHGFRQEEVGGLWTNDCDTGGQGLQMNITHYWRWHQRRWNQTRKMP---AMAMKWDAYAIISPNLRVSVCCLCL"
//        );

    }

    public static void alinhamento(String string1, String string2) throws IOException {
        FileWriter p = new FileWriter(new File("src/main/java/edta/tabela.txt"));

        int t1 = string1.length() +1;
        int t2 = string2.length() + 1;

        int[][] tabela = new int[t1][t2];

        tabela[0][0] = 0;

        for (int i=1 ;i < t1; i++) tabela[i][0]= tabela[i-1][0] + GAP;

        for (int i=1 ;i < t2; i++) tabela[0][i]= tabela[0][i-1] + GAP;

        int[][] posi= new int[t1][t2];
        Return temp ;
        for (int i=1; i < t1 ; i++) {
            for (int j=1; j < t2; j++) {
                temp = returnBiggerPosi((tabela[i - 1][j - 1] + getScore(string1.charAt(i - 1), string2.charAt(j - 1)))
                        , (tabela[i][j - 1] + GAP), (tabela[i - 1][j] + GAP));
                tabela[i][j]=temp.getResposta();
                posi[i][j] = temp.getPosi();
//                p.append(String.valueOf(tabela[i][j])).append(" ");
            }
//            p.append("\n");
        }
        StringBuilder A = new StringBuilder();
        StringBuilder B = new StringBuilder();

        char[] a = string1.toCharArray();
        char[] b = string2.toCharArray();

        /*int linha = a.length  , coluna =b.length ;
        while(true){
            if (linha == 0 && coluna == 0) break;
            if (linha <= 0 ^ coluna <= 0){
                if (linha == 0){
                    //ESQUERDA
                    B.append(b[coluna - 1]);
                    A.append("-");
                    coluna--;
                }else{
                    //CIMA
                    B.append("-");
                    A.append(a[linha - 1]);
                    linha--;
                }
            }else if (tabela[linha - 1][coluna - 1] + getScore(a[linha - 1], b[coluna - 1]) == tabela[linha][coluna]) {
                //DIAGONAL
                A.append(a[linha - 1]);
                B.append(b[coluna - 1]);
                coluna--;
                linha--;
            }
            else if (tabela[linha - 1][coluna] + GAP == tabela[linha][coluna]) {
                //CIMA
                B.append("-");
                A.append(a[linha - 1]);
                linha--;
            }
            else if (tabela[linha][coluna - 1] + GAP == tabela[linha][coluna]) {
                //ESQUERDA
                B.append(b[coluna - 1]);
                A.append("-");
                coluna--;
            }
        }*/

//        Funcoes.imprimirArray(t1,t2,tabela);

        int linha1 = a.length  , coluna1 =b.length ;
        while(true){
            if (linha1 == 0 && coluna1 == 0) break;
            if (linha1 <= 0 ^ coluna1 <= 0){
                if (linha1 == 0){
                    //ESQUERDA
                    B.append(b[coluna1 - 1]);
                    A.append("-");
                    coluna1--;
                }else{
                    //CIMA
                    B.append("-");
                    A.append(a[linha1 - 1]);
                    linha1--;
                }
            }
            if (posi[linha1][coluna1] == 1){
                A.append(a[linha1 - 1]);
                B.append(b[coluna1 - 1]);
                coluna1--;
                linha1--;
            }else if (posi[linha1][coluna1] == 2){
                B.append(b[coluna1 - 1]);
                A.append("-");
                coluna1--;
            }else if (posi[linha1][coluna1] == 3){
                B.append("-");
                A.append(a[linha1 - 1]);
                linha1--;
            }
        }


        System.out.println(Edit.editDistance(string1,string2));
        System.out.println(A.reverse());
        System.out.println(B.reverse());

    }

    public static Return returnBiggerPosi(int a, int b, int c){
        Return retorno = new Return();
        retorno.resposta = a;
        retorno.posi=1; // diagonal
        if(a == b && b == c) {
            retorno.resposta =a;
            retorno.posi =1; //DIAGONAL
            return retorno;
        }
        else {
            if (b > a){
                retorno.resposta = b;
                retorno.posi =2; // ESQUERDA
            }
            else if( c > a){
                retorno.resposta = c;
                retorno.posi =3; //CIMA
            }
            return retorno;
        }
    }


    public static int getScore(char x, char y){
        if (x == y) return MATCH;
        else return MISMATCH;
    }

    public static void comparar(String s1,String s2){
        try{
            boolean[] m=new boolean[s1.length()];

            try {
                for (int i=0; i < s1.length(); i++)
                    m[i]=s1.charAt(i) == s2.charAt(i);
            }catch (Exception e){

            }

            for (int i=0; i < s1.length(); i++) {
                if (!m[i])System.out.print(Colors.RED+ s1.charAt(i) + Colors.RESET);
                else System.out.print(s1.charAt(i));
            }
            System.out.println();

            for (int i=0; i < s1.length(); i++) {
                if (!m[i]) System.out.print(Colors.RED  + s2.charAt(i) + Colors.RESET);
                else System.out.print(s2.charAt(i));
            }
        } catch (IndexOutOfBoundsException w ){
            System.out.print("ç");
        }
    }

}

