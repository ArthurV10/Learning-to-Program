package application;

import java.util.*;
import entities.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando clientes
        Cliente cliente1 = new Cliente(1, "João Silva", "12345678900", new Date(), null);
        Cliente cliente2 = new Cliente(2, "Maria Oliveira", "98765432100", new Date(), null);
        Cliente clienteDuplicado = new Cliente(1, "Carlos Souza", "12345678900", new Date(), null); // Duplicado

        // Teste: Inserir clientes
        System.out.println("=== Teste: Inserir Clientes ===");
        banco.inserirCliente(cliente1); // Sucesso
        banco.inserirCliente(cliente2); // Sucesso
        banco.inserirCliente(clienteDuplicado); // Falha (ID e CPF duplicados)

        // Criando contas
        Conta conta1 = new Conta("123", 1000.0f, cliente1.getId());
        conta1.setCliente(cliente1);

        Conta conta2 = new Conta("456", 2000.0f, cliente2.getId());
        conta2.setCliente(cliente2);

        Conta contaDuplicada = new Conta("123", 3000.0f, cliente1.getId()); // Número duplicado

        // Teste: Inserir contas
        System.out.println("\n=== Teste: Inserir Contas ===");
        banco.inserirConta(conta1); // Sucesso
        banco.inserirConta(conta2); // Sucesso
        banco.inserirConta(contaDuplicada); // Falha (número duplicado ou ID duplicado)

        // Listando contas e clientes
        System.out.println("\n=== Lista de Contas ===");
        for (Conta conta : banco.getContas()) {
            System.out.println("Conta número: " + conta.getNumero() + ", Saldo: " + conta.consultarSaldo());
        }

        System.out.println("\n=== Lista de Clientes ===");
        for (Cliente cliente : banco.getClientes()) {
            System.out.println("Cliente: " + cliente.getNome() + ", CPF: " + cliente.getCpf());
        }

        // Teste: Sacar dinheiro
        System.out.println("\n=== Teste: Sacar Dinheiro ===");
        banco.sacarDinheiro(conta1, 500); // Sucesso
        banco.sacarDinheiro(conta1, 700); // Falha (saldo insuficiente)

        // Teste: Depositar dinheiro
        System.out.println("\n=== Teste: Depositar Dinheiro ===");
        banco.depositarDinheiro(conta1, 1000); // Sucesso

        // Teste: Transferência
        System.out.println("\n=== Teste: Transferência ===");
        banco.transferirDinheiro(conta1.getNumero(), conta2.getNumero(), 300); // Sucesso
        banco.transferirDinheiro(conta1.getNumero(), conta2.getNumero(), 2000); // Falha (saldo insuficiente)

        // Teste: Transferência múltipla
        System.out.println("\n=== Teste: Transferência Múltipla ===");
        banco.transferirDinheiroMultiplas(conta1.getNumero(), Arrays.asList(conta2.getNumero()), 200); // Sucesso para conta 2

        // Consultar saldo total e média
        System.out.println("\n=== Saldo Total e Média de Saldos ===");
        System.out.println("Saldo total: " + banco.saldoContasTotal());
        System.out.println("Média de saldos: " + banco.mediaSaldos());
    }
}