package application;
import entities.Equipamento;

public class Main {
    public static void main(String[] args) {
       Equipamento lampada = new Equipamento(false);

        System.out.println("Estados da Lampada:");

       //Liga o equipamento
        lampada.liga();
        System.out.println("Aparelho esta ligado? = " + lampada.estaLigado());
        System.out.println();

        //Desliga o aparelho
        lampada.desliga();
        System.out.println("Aparelho esta ligado? = " + lampada.estaLigado());
        System.out.println();

        //Inverte o estado atual do aparelho
        lampada.inverte();
        System.out.println("Aparelho esta ligado? = " + lampada.estaLigado());
    }
}