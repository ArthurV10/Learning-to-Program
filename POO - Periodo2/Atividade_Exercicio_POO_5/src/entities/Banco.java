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

    public void inserir(Conta conta) {
        this.contas.add(conta);
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
        boolean cpfExistente = false;
        for (Cliente c : this.clientes){
            if (cliente.getCpf().equals(cliente.getCpf())){
               cpfExistente = true;
               break;
            }
            if(!cpfExistente){
                getClientes().add(cliente);
            }
        }
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
