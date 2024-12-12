package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>(); // Inicialização da lista de clientes
    }

    public void inserirConta(Conta conta) {
        // Verifica duplicação de número ou ID
        for (Conta c : this.contas) {
            if (c.getNumero().equals(conta.getNumero()) || c.getCliente().getId() == conta.getCliente().getId()) {
                System.out.println("Erro: Conta com número ou ID já cadastrada: " + conta.getNumero());
                return; // Impede duplicação de contas
            }
        }

        // Verifica se o cliente associado existe
        Cliente clienteAssociado = consultarCliente(conta.getCliente().getCpf());
        if (clienteAssociado == null) {
            System.out.println("Erro: Cliente associado à conta não encontrado.");
            return;
        }

        // Se as validações forem atendidas, adiciona a conta
        this.contas.add(conta);
        clienteAssociado.setConta(conta); // Associa a conta ao cliente
        System.out.println("Conta " + conta.getNumero() + " adicionada com sucesso ao cliente " + clienteAssociado.getNome() + ".");
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

    public void inserirCliente(Cliente cliente) {
        for (Cliente c : this.clientes) {
            if (c.getId() == cliente.getId() || c.getCpf().equals(cliente.getCpf())) {
                System.out.println("Erro: Cliente com ID ou CPF já cadastrado: " + cliente.getNome());
                return; // Impede duplicação de clientes
            }
        }
        this.clientes.add(cliente);
        System.out.println("Cliente " + cliente.getNome() + " adicionado com sucesso.");
    }


    public Cliente consultarCliente(String cpf) {
        for (Cliente cliente : getClientes()) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
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

    public void associarContaCliente(String numeroConta, String cpfCliente) {
        Conta contaEncontrada = consultarConta(numeroConta);
        Cliente clienteEncontrado = consultarCliente(cpfCliente);

        if (contaEncontrada.getCliente().getCpf() == cpfCliente){
            System.out.println("Conta existente encontrada: " + numeroConta);
            return;
        }

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
        public void transferirDinheiro(String numeroContaOrigem, String numeroContaDestino, int valor){
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
}
