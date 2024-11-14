package application;

import entities.Jogador;

public class Main {
    public static void main(String[] args) {
        // Criação de dois jogadores
        Jogador jogador1 = new Jogador(10, 5, 100);
        Jogador jogador2 = new Jogador(8, 6, 90);

        System.out.println("Status inicial:");
        System.out.println("Jogador 1: " + jogador1);
        System.out.println("Jogador 2: " + jogador2);

        // Jogador 1 ataca Jogador 2
        jogador1.atacar(jogador2);
        System.out.println("\nApós o Jogador 1 atacar o Jogador 2:");
        System.out.println("Jogador 1: " + jogador1);
        System.out.println("Jogador 2: " + jogador2);

        // Jogador 2 ataca Jogador 1
        jogador2.atacar(jogador1);
        System.out.println("\nApós o Jogador 2 atacar o Jogador 1:");
        System.out.println("Jogador 1: " + jogador1);
        System.out.println("Jogador 2: " + jogador2);

        // Verificação final de qual jogador tem mais pontos
        if (jogador1.estaVivo() && jogador2.estaVivo()) {
            if (jogador1.verificarPontos() > jogador2.verificarPontos()) {
                System.out.println("\nJogador 1 tem mais pontos.");
            } else if (jogador2.verificarPontos() > jogador1.verificarPontos()) {
                System.out.println("\nJogador 2 tem mais pontos.");
            } else {
                System.out.println("\nAmbos os jogadores têm o mesmo número de pontos.");
            }
            if (jogador1.estaVivo()) {
            System.out.println("\nJogador 1 venceu (Jogador 2 está sem pontos).");
            } else if (jogador2.estaVivo()) {
            System.out.println("\nJogador 2 venceu (Jogador 1 está sem pontos).");
            } else {
            System.out.println("\nAmbos os jogadores estão sem pontos.");
            }
        }
    }
}
