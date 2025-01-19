package entities;

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

    public void inserirConta(String numero, double saldo, int id) {
        Conta contaInserida = new Conta(numero, saldo, id);
        if (contas.contains(contaInserida)){
            System.out.println("Erro: Conta com número ou ID já cadastrada: " + numero);
            return; // Impede duplicação de contas
        }
        contas.add(contaInserida);
    }

    public void inserirPoupanca(String numero, double saldo, int id) {
        Poupanca contaInserida = new Poupanca(numero, saldo, id);
        if (contas.contains(contaInserida)){
            System.out.println("Erro: Conta com número ou ID já cadastrada: " + numero);
            return; // Impede duplicação de contas
        }
        contas.add(contaInserida);
    }

    public void inserirImposto(String numero, double saldo, int id){
        Imposto contaInserida = new Imposto(numero, saldo, id);
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
        public void sacarDinheiro(Conta conta, int valor) {
            if (conta instanceof Imposto) {
                double imposto = ((Imposto) conta).getTaxaImposto() * valor;
                double totalSaque = valor + imposto;
        
                if (conta.consultarSaldo() >= totalSaque) {
                    conta.sacar(totalSaque);
                    System.out.println("Saque com imposto realizado com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente para saque com imposto.");
                }
            } else {
                if (conta.consultarSaldo() >= valor) {
                    conta.sacar(valor);
                    System.out.println("Saque realizado com sucesso!");
                } else {
                    System.out.println("Não foi possível realizar o saque!");
                }
            }
        }
        

        // Depositar Dinheiro
        public void depositarDinheiro(Conta conta, int valor){
            conta.depositar(valor);
            System.out.println("Deposito realizado com sucesso!");
        }

        // Transferir Dinheiro
        public void transferirDinheiro(String numeroContaOrigem, String numeroContaDestino, double valor){
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

        public void transferirDinheiroMultiplas(String numeroContaOrigem, int valor) {
            Conta contaOrigem = consultar(numeroContaOrigem);
            
            if (contaOrigem == null) {
                System.out.println("Conta de origem inválida!");
                return;
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a quantidade de contas para transferência: ");
            int qtdContas = scanner.nextInt();
            
            String[] contasDestino = new String[qtdContas];
            
            for (int i = 0; i < qtdContas; i++) {
                System.out.print("Digite o número da conta de destino " + (i + 1) + ": ");
                contasDestino[i] = scanner.next();
            }
            
            if (contaOrigem.consultarSaldo() < valor * qtdContas) {
                System.out.println("Saldo insuficiente para realizar todas as transferências!");
                return;
            }
            
            for (String numeroConta : contasDestino) {
                Conta contaDestino = consultar(numeroConta);
                
                if (contaDestino == null) {
                    System.out.println("Conta de destino inválida: " + numeroConta);
                    continue;
                }
                
                contaOrigem.sacar(valor);
                contaDestino.depositar(valor);
                System.out.println("Transferência realizada com sucesso para a conta " + numeroConta);
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

        public double mediaSaldos(){
            return saldoContasTotal()/quantidadeContas();
        }

        public int consultarContaPorIndices(String numeroConta){
            int index = -1;
            Conta verificarConta = consultar(numeroConta); 
            if (verificarConta != null){ 
                for (int i = 0; i < this.contas.size(); i++) {
                    if (this.contas.get(i).getNumero().equals(numeroConta)){
                        index = i;
                        break; 
                    } 
                } 
            } return index; 
        }

        public int consultarClientePorIndices(String cpf){
            int index = -1;
            Cliente verificarCliente = consultarCliente(cpf);
            if (verificarCliente != null) {
                for (int i = 0; i < this.clientes.size(); i++){
                    if (this.clientes.get(index).getCpf().equals(cpf)){
                        index = i;
                        break;
                    };
                }
            } return index;
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
                System.out.println("Conta removida com sucesso."); 
            } 
            else { System.out.println("Conta não encontrada."); 
            } 
        }

        public void excluirClientePeloIndices(String numero){
            int indexExcluir = consultarClientePorIndices(numero);
            if (indexExcluir != -1) {
                for (int i = indexExcluir; i < this.clientes.size(); i++){
                    this.clientes.set(i, this.clientes.get(i+1));
                }
                this.clientes.remove(this.clientes.size()-1);
            }
        }

        public void renderJuros(String numero) {
            Conta conta = consultar(numero);
            if (conta != null) {
                if (conta instanceof Poupanca) {
                    Poupanca poupanca = (Poupanca) conta; // Cast para Poupança
                    poupanca.renderJuros(); // Invoca o método renderJuros
                } else {
                    System.out.println("A conta encontrada não é uma poupança.");
                }
            } else {
                System.out.println("Conta não encontrada.");
            }
        }

        public int gerarId(){
            Random random = new Random();
            return random.nextInt(100000000, 900000000);
        }

        public void exibirMenu() {
            System.out.println("\nBem-vindo ao Banco!");
            System.out.println("Digite uma opção:");
            System.out.println("===============================================================================\n* Contas:");
            System.out.println("|| 01 - Inserir              || 02 - Consultar          || 03 - Sacar        ||");
            System.out.println("|| 04 - Depositar            || 05 - Excluir            || 06 - Transferir   ||");
            System.out.println("|| 07 - Totalizações         || 08 - Mudar Titularidade || 09 - Render Juros ||");
            System.out.println("||===========================================================================||\n* Clientes:");
            System.out.println("|| 10 - Inserir              || 11 - Consultar          || 12 - Associar     ||");
            System.out.println("|| 13 - Excluir              || 14 - Contas Nulas       ||                   ||");
            System.out.println("||===========================================================================||\n* Extras:");
            System.out.println("|| 20 - Ler e Gravar Arquivo ||                         ||                   ||");
            System.out.println("|| 0  - Sair                 ||                         ||                   ||");
            System.out.println("===============================================================================");
        }
        

        public void menuConta(App aplicativo, Banco banco) {
            Scanner scanner = new Scanner(System.in);
            int opcao;
            do {
                exibirMenu();
                System.out.print("Opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
    
                switch (opcao) {
                    case 1:
                        aplicativo.inserirContaPoupanca(banco, scanner);
                        break;

                    case 2:
                        aplicativo.consultarConta(banco, scanner);
                        break;

                    case 3:
                        aplicativo.sacarDinheiro(banco, scanner);
                            break;

                    case 4:
                        aplicativo.depositarDinheiro(banco, scanner);
                            break;

                    case 5:
                        aplicativo.excluirConta(banco, scanner);
                            break;
                            
                    case 6:
                        aplicativo.transferencia(banco, scanner);
                            break;

                    case 7:
                        aplicativo.totalizar(banco);
                            break;
                    case 8:
                        aplicativo.mudancaTitularidade(banco, scanner);
                        break;

                    case 9:
                        aplicativo.renderJuros(banco, scanner);
                        break;
                    case 10:
                        aplicativo.inserirCliente(banco, scanner);
                        break;

                    case 11:
                        aplicativo.consultarCliente(banco, scanner);
                        break;
                        
                    case 12:
                        aplicativo.associarContaCliente(banco, scanner);
                        break;
                    
                    case 13:
                        aplicativo.excluirCliente(banco, scanner);
                        break;

                    case 14:
                        aplicativo.listarContasNulas(banco);

                    // case 20:
                    //     aplicativo.lerGravarArquivo(banco, scanner);
                    case 0:
                        System.out.println("Saindo do menu...");
                        break;

                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
            scanner.close();    
        }
}
