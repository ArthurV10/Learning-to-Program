package application;

import entities.Conta;

public class Main {
    public static void main(String[] args) {
        // Criação de contas para teste
        Conta conta1 = new Conta(500);
        Conta conta2 = new Conta(300);

        // Testando saque
        System.out.println("Saque de 200 da Conta 1: " + conta1.sacar(200));
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println();

        System.out.println("Saque de 400 da Conta 1: " + conta1.sacar(400));
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println();

        // Testando depósito
        System.out.println("Depósito de 100 na Conta 1: " + conta1.depositar(100)); // Deve retornar true
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println();

        // Testando transferência
        System.out.println("Transferência de 150 da Conta 1 para Conta 2: " + conta1.transferir(conta2, 150)); // Deve retornar true
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da Conta 2: " + conta2.getSaldo());
        System.out.println();

        System.out.println("Transferência de 300 da Conta 1 para Conta 2: " + conta1.transferir(conta2, 300)); // Deve retornar false
        System.out.println("Saldo da Conta 1: " + conta1.getSaldo());
        System.out.println("Saldo da Conta 2: " + conta2.getSaldo());
        System.out.println();
    }
}
