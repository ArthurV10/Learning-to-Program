package application;
import java.util.Date;
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
        banco.inserirConta(contaDuplicada); // Falha (número duplicado)

        // Teste: Consultar cliente
        System.out.println("\n=== Teste: Consultar Cliente ===");
        Cliente consultaCliente = banco.consultarCliente("12345678900");
        System.out.println(consultaCliente != null ? "Cliente encontrado: " + consultaCliente.getNome() : "Cliente não encontrado.");

        Cliente clienteNaoExistente = banco.consultarCliente("11111111111");
        System.out.println(clienteNaoExistente != null ? "Cliente encontrado." : "Cliente não encontrado.");

        // Teste: Consultar conta
        System.out.println("\n=== Teste: Consultar Conta ===");
        Conta consultaConta = banco.consultarConta("123");
        System.out.println(consultaConta != null ? "Conta encontrada: " + consultaConta.getNumero() : "Conta não encontrada.");

        Conta contaNaoExistente = banco.consultarConta("999");
        System.out.println(contaNaoExistente != null ? "Conta encontrada." : "Conta não encontrada.");

        // Teste: Associar conta a cliente
        System.out.println("\n=== Teste: Associar Conta a Cliente ===");
        banco.associarContaCliente("123", "12345678900"); // Sucesso
        banco.associarContaCliente("123", "98765432100"); // Falha (associação incorreta)

        // Teste: Listar contas de um cliente
        System.out.println("\n=== Teste: Listar Contas de um Cliente ===");
        cliente1.listarContasCliente();
        cliente2.listarContasCliente();

        // Teste: Totalizar saldo de contas de um cliente
        System.out.println("\n=== Teste: Totalizar Saldo de um Cliente ===");
        System.out.println("Saldo total do cliente João Silva: " + cliente1.totalizarSaldoCliente());
        System.out.println("Saldo total do cliente Maria Oliveira: " + cliente2.totalizarSaldoCliente());

        // Teste: Transferência entre contas
        System.out.println("\n=== Teste: Transferência Entre Contas ===");
        conta1.transferir(conta2, 500.0f); // Sucesso
        System.out.println("Saldo conta1 (João): " + conta1.consultarSaldo());
        System.out.println("Saldo conta2 (Maria): " + conta2.consultarSaldo());

        conta1.transferir(conta2, 2000.0f); // Falha (saldo insuficiente)
    }
}
