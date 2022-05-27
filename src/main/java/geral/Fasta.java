package geral;

public class Fasta {
    private String nome;
    private String data;

    public Fasta() {
    }

    public Fasta(String nome, String data) {
        this.nome=nome;
        this.data=data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data=data;
    }

    @Override
    public String toString() {
        return '\n'+nome+ '\n' + data;
    }
}
