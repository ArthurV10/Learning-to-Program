package entities;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class App {
    private final String nome;
    
    public App(String nome){
        this.nome = nome;
    }
    
    public void inserirConta(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        String numeroContaCriada = scanner.nextLine();
        System.out.print("Informe o saldo inicial: ");
        float saldoInicial = scanner.nextFloat();
        int id = banco.gerarId();
        banco.inserirConta(numeroContaCriada, saldoInicial, id);
    }

    public void consultarConta(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta contaConsultada = banco.consultarConta(scanner.nextLine());
        if (contaConsultada != null) {
            System.out.println("Conta: " + contaConsultada.getNumero() + ", Saldo: " + contaConsultada.consultarSaldo());
        } else {
            System.out.println("Conta não encontrada.");
        }
    }
                
    public void sacarDinheiro(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta numeroContaParaSacar = banco.consultarConta(scanner.nextLine());
        if (numeroContaParaSacar!= null) {
            System.out.print("Informe o valor para sacar: ");
            float valorSacar = scanner.nextFloat();
            numeroContaParaSacar.sacar(valorSacar);
        }
        else {
            System.out.println("Conta não encontrada.");
        }
    }
                    
    public void depositarDinheiro(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta numeroContaParaDeposito = banco.consultarConta(scanner.nextLine());
        if (numeroContaParaDeposito!= null) {
            System.out.print("Informe o valor para depositar: ");
            float valorSacar = scanner.nextFloat();
            numeroContaParaDeposito.depositar(valorSacar);
        }
        else {
            System.out.println("Conta não encontrada.");
        }
    }

    // falta remover a conta do antigo e adicionar no novo
    public void mudancaTitularidade(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        Conta numeroContaParaMudanca = banco.consultarConta(scanner.nextLine());
        if (numeroContaParaMudanca == null) {
            System.out.println("Conta não encontrada.");
        }
        else{
            System.out.print("Informe o CPF do cliente: ");
            Cliente novoCliente = banco.consultarCliente(scanner.nextLine());
            if (novoCliente != null){
                numeroContaParaMudanca.getCliente().removeAccount(numeroContaParaMudanca);
                numeroContaParaMudanca.setCliente(novoCliente);
                novoCliente.setConta(numeroContaParaMudanca);
            }
            else{
                System.out.println("Cliente não encontrada");
            }
        }
    }

    public void excluirConta(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta: ");
        String numeroContaExcluir = scanner.nextLine();
        banco.excluirContaPeloIndices(numeroContaExcluir);
    }

    public void excluirCliente(Banco banco, Scanner scanner){
        System.out.print("Informe o CPF do Cliente: ");
        String cpfClienteExcluir = scanner.nextLine();
        banco.excluirClientePeloIndices(cpfClienteExcluir);
    }

    public void transferencia(Banco banco, Scanner scanner){
        System.out.print("Informe o número da conta de origem: ");
        String numeroContaOrigem = scanner.nextLine();
        System.out.print("Informe o número da conta de destino: ");
        String numeroContaDestino = scanner.nextLine();
        System.out.print("Informe o valor a ser transferido: ");
        float valor = scanner.nextFloat();
        banco.transferirDinheiro(numeroContaOrigem, numeroContaDestino, valor);
    }
                 
    public void totalizar(Banco banco){
        System.out.println("Total de contas: " + banco.quantidadeContas());
        System.out.println("Total de saldos: R$ " + banco.saldoContasTotal());
        System.out.println("Média dos saldos: R$ " + banco.mediaSaldos());
    }

    public void inserirCliente(Banco banco, Scanner scanner){
        int id = banco.gerarId();
        System.out.print("Informe o nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF do Cliente: ");
        String cpfParaCadastro = scanner.nextLine();

        LocalDate dataNascimento = null;
        while (dataNascimento == null) {
            try {
                System.out.print("Informe a data de nascimento (dd/MM/yyyy): ");
                String dataInput = scanner.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                dataNascimento = LocalDate.parse(dataInput, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Tente novamente.");
            }
        }

        Cliente cliente = new Cliente(id, nome, cpfParaCadastro, dataNascimento);
        banco.inserirCliente(cliente);
    }
                    
    public void consultarCliente(Banco banco, Scanner scanner){
        System.out.println("Informe o CPF do Cliente: ");
        Cliente contaClienteConsultado = banco.consultarCliente(scanner.nextLine());
        if (contaClienteConsultado != null) {
            // Informar nome, cpf, dataNascimento
            System.out.println("Nome do Cliente: " + contaClienteConsultado.getNome() + "\n" +
                    "CPF do Cliente: " + contaClienteConsultado.getCpf() + "\n" +
                    "Data de Nascimento: " + contaClienteConsultado.getDataNascimento());

            // Listar contas do cliente
            List<Conta> contasDoCliente = contaClienteConsultado.listarContasCliente();

            if (contasDoCliente == null) {
                System.out.println("Cliente não encontrado.");
            }
        }
    }
                   
    public void associarContaCliente(Banco banco, Scanner scanner){
        System.out.print("Informe o numero da Conta do Cliente: ");
        String numeroDaContaAssociada = scanner.nextLine();
        System.out.print("Informe o CPF do Cliente: ");
        String cpfParaAssociarConta = scanner.nextLine();
        banco.associarContaCliente(numeroDaContaAssociada, cpfParaAssociarConta);
    }

    public void listarContasNulas(Banco banco){
        for (Conta conta : banco.getContas()){
        System.out.println("Todas as contas nulas: ");
            if (conta.getCliente() == null){
                System.out.println("Numero da Conta: " + conta.getNumero());
                System.out.printf("Id da Conta: %.2f\n",  conta.getId());
            }
            else {
                System.out.println("Não existem contas nulas: ");
            }
        }
    }
}