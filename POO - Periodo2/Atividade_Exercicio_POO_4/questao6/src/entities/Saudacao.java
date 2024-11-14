package entities;

public class Saudacao {
    private String saudacao;
    private String nome;

    public Saudacao(String saudacao, String nome) {
        this.saudacao = saudacao;
        this.nome = nome;
    }

    public String obterSaudacao() {
        return this.saudacao + this.nome;
    }
}

