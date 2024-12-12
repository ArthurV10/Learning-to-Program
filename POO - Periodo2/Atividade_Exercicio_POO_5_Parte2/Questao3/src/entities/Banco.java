package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>(); // Inicialização da lista de clientes
    }

    public void inserirConta(String numero, float saldo, int id) {
        Conta contaInserida = new Conta(numero, saldo, id);
        if (contas.contains(contaInserida)){
            System.out.println("Erro: Conta com número ou ID já cadastrada: " + numero);
            return; // Impede duplicação de contas
        }
        contas.add(contaInserida);
    }

    public void inserirCliente(Cliente cliente){
        if (clientes.contains(cliente)){
            System.out.println("Erro: Cliente com ID ou CPF já cadastrado: " + cliente.getNome());
            return; // Impede duplicação de clientes
        }
        clientes.add(cliente);
    }

    public List<Conta> getContas(){
        return this.contas;
    }

    public List<Cliente> getClientes(){
        return this.clientes;
    }

    public Conta consultar(String numero) {
        for (Conta conta : getContas()) {
            if (conta.getNumero().equals(numero)) {
                return conta;
            }
        }
        return null;
    }
    
    public Conta consultarConta(String numeroConta) {
        for (Conta conta : getContas()) {
            if (conta.getNumero().equals(numeroConta)) {
                return conta;
            }
        }
        return null;
    }

    public Cliente consultarCliente(String cpfCliente) {
        for (Cliente cliente : getClientes()) {
            if (cliente.getCpf().equals(cpfCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public void associarContaCliente(String numeroConta, String cpfCliente) {
        // Consulta a conta e o cliente
        Conta contaEncontrada = consultarConta(numeroConta);
        Cliente clienteEncontrado = consultarCliente(cpfCliente);
    
        // Verifica se a conta existe
        if (contaEncontrada == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
    
        // Verifica se o cliente existe
        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }
    
        // Verifica se a conta já tem um cliente associado
        if (contaEncontrada.getCliente() != null) {
            System.out.println("A conta já está associada a um cliente.");
            return;
        }
    
        // Associa o cliente à conta
        contaEncontrada.setCliente(clienteEncontrado);
        clienteEncontrado.setConta(contaEncontrada);
        System.out.println("Cliente " + cpfCliente + " associado à conta " + numeroConta + " com sucesso.");
    }
    

        // Consultar por Indice
        public Conta getContaPorIndice(int indice) {
            return this.contas.get(indice);
        }

        //Atualizar Conta
        public void atualizarConta(Conta conta){
            int indice = this.contas.indexOf(conta);
            if(indice!= -1){
                this.contas.set(indice, conta);
                System.out.println("Conta atualizada com sucesso.");
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        // Sacar Dinheiro
        public void sacarDinheiro(Conta conta, int valor){
            if(conta.consultarSaldo() >= valor){
                conta.sacar(valor);
                System.out.println("Saque realizado com sucesso!");
            }
            else{
                System.out.println("Não foi possivel realizar saque!");
            }
        }

        // Depositar Dinheiro
        public void depositarDinheiro(Conta conta, int valor){
            conta.depositar(valor);
            System.out.println("Deposito realizado com sucesso!");
        }

        // Transferir Dinheiro
        public void transferirDinheiro(String numeroContaOrigem, String numeroContaDestino, float valor){
            Conta contaOrigem = consultar(numeroContaOrigem);
            Conta contaDestino = consultar(numeroContaDestino);

            if ((contaOrigem != null) && (contaDestino != null)){
                if(contaOrigem.consultarSaldo() >= valor){
                    contaOrigem.sacar(valor);
                    contaDestino.depositar(valor);
                    System.out.println("Transferência realizada com sucesso!");
                }
                else{
                    System.out.println("Não foi possivel realizar a transferência!");
                }
            }
            else{
                System.out.println("Contas não encontradas.");
            }
        }

        // Transferencias Multiplas entre Contas
        public void transferirDinheiroMultiplas(String numeroContaOrigem ,List<String> numeroContasParaTransferencia, int valor){
            Conta contaOrigem = consultar(numeroContaOrigem);
            for (String numeroConta: numeroContasParaTransferencia) {
                Conta contaDestino = consultar(numeroConta);
                if ((contaOrigem!= null) && (contaDestino!= null)){
                    if(contaOrigem.consultarSaldo() >= valor){
                        contaOrigem.sacar(valor);
                        contaDestino.depositar(valor);
                        System.out.println("Transferência realizada com sucesso para a conta " + numeroConta);
                    }
                    else{
                        System.out.println("Não foi possivel realizar a transferência para a conta " + numeroConta + "!");
                    }
                }
            }
        }

        public int quantidadeContas(){
            return this.contas.size();
        }

        public int saldoContasTotal(){
            int total = 0;
            for (Conta conta : this.contas) {
                total += conta.consultarSaldo();
            }
            return total;
        }

        public float mediaSaldos(){
            return saldoContasTotal()/quantidadeContas();
        }

        public int consultarContaPorIndices(String numeroConta){
            int index = -1;
            Conta verificarConta = consultar(numeroConta);
            if (verificarConta != null){
                for (int i = 0; i < this.contas.size(); i++) {
                    if (this.contas.get(index).getNumero() == numeroConta){
                        index = i;
                        break;
                    }
                }
            }
            return index;
        }

        public void excluirConta(String numero){
            int indexExcluir = consultarContaPorIndices(numero);
            if (indexExcluir != -1) {
                for (int i = indexExcluir; i < this.contas.size();i++){
                    this.contas.set(i, this.contas.get(i+1));
                }
            this.contas.remove(this.contas.size()-1);
            }
        }
        
        public void excluirContaPeloIndices(String numero) {
            int indexExcluir = consultarContaPorIndices(numero);
            if (indexExcluir != -1) {
                this.contas.remove(indexExcluir);
            }
        }

        public int gerarId(){
            Random random = new Random();
            return random.nextInt(100000000, 900000000);
        }

        public void exibirMenu() {
            System.out.println("\nBem-vindo ao Banco!");
            System.out.println("Digite uma opção:");
            System.out.println("=========================================================\nContas");
            System.out.println("|| 1 - Inserir      || 2 - Consultar || 3 - Sacar      ||");
            System.out.println("|| 4 - Depositar    || 5 - Excluir   || 6 - Transferir ||");
            System.out.println("|| 7 - Totalizações ||");
            System.out.println("=========================================================\nClientes:");
            System.out.println("|| 8 - Inserir      || 9 - Consultar || 10 - Associar  ||");
            System.out.println("|| 0 - Sair         ||\n");
        }
        

        public void menuConta() {
            Scanner scanner = new Scanner(System.in);
            int opcao;
            do {
                exibirMenu();
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcao) {
                    case 1:
                        System.out.print("Informe o número da conta: ");
                        String numeroContaCriada = scanner.nextLine();
                        System.out.print("Informe o saldo inicial: ");
                        float saldoInicial = scanner.nextFloat();
                        int id = gerarId();
                        inserirConta(numeroContaCriada, saldoInicial, id);
                        break;
                    case 2:
                        System.out.print("Informe o número da conta: ");
                        Conta contaConsultada = consultarConta(scanner.nextLine());
                        if (contaConsultada != null) {
                            System.out.println("Conta: " + contaConsultada.getNumero() + ", Saldo: " + contaConsultada.consultarSaldo());
                        } else {
                            System.out.println("Conta não encontrada.");
                        }
                        break;
                    case 3:
                        System.out.print("Informe o número da conta: ");
                        Conta numeroContaParaSacar = consultarConta(scanner.nextLine());
                        if (numeroContaParaSacar!= null) {
                            System.out.print("Informe o valor para sacar: ");
                            float valorSacar = scanner.nextFloat();
                            numeroContaParaSacar.sacar(valorSacar);
                        }
                        else {
                            System.out.println("Conta não encontrada.");
                        }
                            break;

                    case 4:
                        System.out.print("Informe o número da conta: ");
                        Conta numeroContaParaDeposito = consultarConta(scanner.nextLine());
                        if (numeroContaParaDeposito!= null) {
                            System.out.print("Informe o valor para depositar: ");
                            float valorSacar = scanner.nextFloat();
                            numeroContaParaDeposito.depositar(valorSacar);
                        }
                        else {
                            System.out.println("Conta não encontrada.");
                        }
                            break;

                    case 5:
                        System.out.print("Informe o número da conta: ");
                        String numeroContaExcluir = scanner.nextLine();
                        excluirContaPeloIndices(numeroContaExcluir);
                            break;
                            
                    case 6:
                        System.out.print("Informe o número da conta de origem: ");
                        String numeroContaOrigem = scanner.nextLine();
                        System.out.print("Informe o número da conta de destino: ");
                        String numeroContaDestino = scanner.nextLine();
                        System.out.print("Informe o valor a ser transferido: ");
                        float valor = scanner.nextFloat();
                        transferirDinheiro(numeroContaOrigem, numeroContaDestino, valor);
                            break;

                    case 7:
                        System.out.println("Total de contas: " + quantidadeContas());
                            break;

                    case 8:
                        id = gerarId();
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
                        inserirCliente(cliente);
                        break;

                        case 9:
                        System.out.println("Informe o CPF do Cliente: ");
                        Cliente contaClienteConsultado = consultarCliente(scanner.nextLine());
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
                        break;
                        

                    case 10:
                        System.out.print("Informe o numero da Conta do Cliente: "); 
                        String numeroDaContaAssociada = scanner.nextLine();
                        System.out.print("Informe o CPF do Cliente: ");
                        String cpfParaAssociarConta = scanner.nextLine();
                        associarContaCliente(numeroDaContaAssociada, cpfParaAssociarConta);
                            break;

                    case 0:
                        System.out.println("Saindo do menu...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
        }
}
