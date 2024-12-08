package application;
import entities.*;

import entities.Banco;
import entities.Conta;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Banco banco = new Banco();
        String opcao;

        do {
            System.out.println("\nBem-vindo\nDigite uma opção:");
            System.out.println("Contas:");
            System.out.println("1 - Inserir | 2 - Consultar | 3 - Sacar");
            System.out.println("4 - Depositar | 5 - Excluir | 6 - Transferir");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = input.nextLine();

            switch (opcao) {
                case "1":
                    inserir(banco, input);
                    break;
                case "2":
                    consultar(banco, input);
                    break;
                case "3":
                    sacar(banco, input);
                    break;
                case "4":
                    depositar(banco, input);
                    break;
                case "5":
                    excluir(banco, input);
                    break;
                case "6":
                    transferir(banco, input);
                    break;
                case "0":
                    System.out.println("Aplicação encerrada.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (!opcao.equals("0"));

        input.close();
    }

    private static void inserir(Banco banco, Scanner input) {
        System.out.println("\nCadastrar conta:");
        System.out.print("Digite o número da conta: ");
        String numero = input.nextLine();
        System.out.print("Digite o saldo inicial: ");
        float saldo = input.nextFloat();
        input.nextLine(); // Limpar buffer
        Conta conta = new Conta(numero, saldo);
        banco.inserirConta(conta);
    }

    private static void consultar(Banco banco, Scanner input) {
        System.out.print("\nConsultar conta - Digite o número da conta: ");
        String numero = input.nextLine();
        Conta conta = banco.consultar(numero);
        if (conta != null) {
            System.out.println("Conta encontrada: Saldo = " + conta.consultarSaldo());
        } else {
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    private static void sacar(Banco banco, Scanner input) {
        System.out.print("\nSacar - Digite o número da conta: ");
        String numero = input.nextLine();
        System.out.print("Digite o valor: ");
        float valor = input.nextFloat();
        input.nextLine(); // Limpar buffer
        banco.sacar(numero, valor);
    }

    private static void depositar(Banco banco, Scanner input) {
        System.out.print("\nDepositar - Digite o número da conta: ");
        String numero = input.nextLine();
        System.out.print("Digite o valor: ");
        float valor = input.nextFloat();
        input.nextLine(); // Limpar buffer
        banco.depositar(numero, valor);
    }

    private static void excluir(Banco banco, Scanner input) {
        System.out.print("\nExcluir conta - Digite o número da conta: ");
        String numero = input.nextLine();
        banco.excluir(numero);
    }

    private static void transferir(Banco banco, Scanner input) {
        System.out.print("\nTransferir - Digite o número da conta de origem: ");
        String numeroOrigem = input.nextLine();
        System.out.print("Digite o número da conta de destino: ");
        String numeroDestino = input.nextLine();
        System.out.print("Digite o valor: ");
        float valor = input.nextFloat();
        input.nextLine(); // Limpar buffer
        banco.transferir(numeroOrigem, numeroDestino, valor);
    }
}
