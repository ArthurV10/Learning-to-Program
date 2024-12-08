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
        System.out.println("Cliente " + cpfCliente + " associado à conta " + numeroConta + " com sucesso.");
    }

}
