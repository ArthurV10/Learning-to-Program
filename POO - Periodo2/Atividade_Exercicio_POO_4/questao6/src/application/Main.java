package application;
import entities.Saudacao;

public class Main {
    public static void main(String[] args) {
        Saudacao saudacao = new Saudacao("Bom dia, ", "João");
        System.out.println(saudacao.obterSaudacao());
    }
}