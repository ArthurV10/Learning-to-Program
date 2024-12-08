package application;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import entities.*;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        // Criando clientes
        Cliente cliente1 = new Cliente(1, "João Silva", "12345678900", new Date(), null);
        Cliente cliente2 = new Cliente(2, "Maria Oliveira", "98765432100", new Date(), null);

        // Teste: Inserir clientes
        System.out.println("=== Teste: Inserir Clientes ===");
        banco.inserirCliente(cliente1); // Sucesso
        banco.inserirCliente(cliente2); // Sucesso

        // Criando contas
        Conta conta1 = new Conta("123", 1000.0f, cliente1.getId());
        conta1.setCliente(cliente1);

        Conta conta2 = new Conta("456", 2000.0f, cliente2.getId());
        conta2.setCliente(cliente2);

        Conta conta3 = new Conta("789", 1500.0f, cliente1.getId());
        conta3.setCliente(cliente1);

        // Teste: Inserir contas
        System.out.println("\n=== Teste: Inserir Contas ===");
        banco.inserirConta(conta1); // Sucesso
        banco.inserirConta(conta2); // Sucesso
        banco.inserirConta(conta3); // Sucesso

        // Teste: Transferência entre contas
        System.out.println("\n=== Teste: Transferência Entre Contas ===");
        banco.transferir("123", "456", 500.0f); // Sucesso
        System.out.println("Saldo conta1 (João): " + conta1.consultarSaldo());
        System.out.println("Saldo conta2 (Maria): " + conta2.consultarSaldo());

        banco.transferir("123", "456", 2000.0f); // Falha (saldo insuficiente)

        // Teste: Transferência para múltiplas contas
        System.out.println("\n=== Teste: Transferência para Múltiplas Contas ===");
        List<Conta> contasDestino = new ArrayList<>();
        contasDestino.add(conta2);
        contasDestino.add(conta3);
        banco.transferirParaMultiplas("123", contasDestino, 300.0f); // Sucesso ou falha dependendo do saldo

        // Exibir saldo após transferências múltiplas
        System.out.println("Saldo conta1 (João): " + conta1.consultarSaldo());
        System.out.println("Saldo conta2 (Maria): " + conta2.consultarSaldo());
        System.out.println("Saldo conta3 (João): " + conta3.consultarSaldo());

        // Teste: Quantidade de contas
        System.out.println("\n=== Teste: Quantidade de Contas ===");
        System.out.println("Quantidade de contas no banco: " + banco.quantidadeDeContas());

        // Teste: Total de dinheiro no banco
        System.out.println("\n=== Teste: Total de Dinheiro no Banco ===");
        System.out.println("Total de dinheiro no banco: " + banco.totalDeDinheiro());

        // Teste: Média de saldo das contas
        System.out.println("\n=== Teste: Média de Saldo ===");
        System.out.println("Média de saldo das contas: " + banco.mediaDeSaldo());

        // Teste: Excluir conta
        System.out.println("\n=== Teste: Excluir Conta ===");
        banco.excluir("123");
        System.out.println("Conta 123 excluída.");
        System.out.println("Quantidade de contas no banco após exclusão: " + banco.quantidadeDeContas());

        // Teste: Consultar por índice
        System.out.println("\n=== Teste: Consultar Conta por Índice ===");
        Conta contaIndice = banco.consultarPorIndice(0);
        System.out.println(contaIndice != null ? "Conta encontrada no índice 0: " + contaIndice.getNumero() : "Nenhuma conta encontrada no índice 0.");
    }
}
