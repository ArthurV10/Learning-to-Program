package entities;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Conta> contas;
    private List<Cliente> clientes;

    public Banco() {
        this.contas = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void inserirConta(Conta conta) {
        for (Conta c : this.contas) {
            if (c.getNumero().equals(conta.getNumero()) || c.getCliente().getId() == conta.getCliente().getId()) {
                System.out.println("Erro: Conta com número ou ID já cadastrada: " + conta.getNumero());
                return;
            }
        }

        Cliente clienteAssociado = consultarCliente(conta.getCliente().getCpf());
        if (clienteAssociado == null) {
            System.out.println("Erro: Cliente associado à conta não encontrado.");
            return;
        }

        this.contas.add(conta);
        clienteAssociado.setConta(conta);
        System.out.println("Conta " + conta.getNumero() + " adicionada com sucesso ao cliente " + clienteAssociado.getNome() + ".");
    }

    public List<Conta> getContas() {
        return this.contas;
    }

    public List<Cliente> getClientes() {
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
                return;
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

    public void excluir(String numero) {
        Conta conta = consultar(numero);
        if (conta != null) {
            this.contas.remove(conta);
            System.out.println("Conta " + numero + " excluída com sucesso.");
        } else {
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    public Conta consultarPorIndice(int indice) {
        if (indice >= 0 && indice < this.contas.size()) {
            return this.contas.get(indice);
        }
        return null;
    }

    public void sacar(String numero, float valor) {
        Conta conta = consultar(numero);
        if (conta != null) {
            conta.sacar(valor);
        } else {
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    public void depositar(String numero, float valor) {
        Conta conta = consultar(numero);
        if (conta != null) {
            conta.depositar(valor);
        } else {
            System.out.println("Erro: Conta não encontrada.");
        }
    }

    public void transferir(String numeroDebito, String numeroCredito, float valor) {
        Conta contaDebito = consultar(numeroDebito);
        Conta contaCredito = consultar(numeroCredito);
        if (contaDebito != null && contaCredito != null) {
            contaDebito.transferir(contaCredito, valor);
        } else {
            System.out.println("Erro: Conta de débito ou crédito não encontrada.");
        }
    }

    public void transferirParaMultiplas(String numeroDebito, List<Conta> contasDestino, float valor) {
        Conta contaDebito = consultar(numeroDebito);
        if (contaDebito != null) {
            for (Conta contaDestino : contasDestino) {
                if (contaDebito.consultarSaldo() >= valor) {
                    contaDebito.transferir(contaDestino, valor);
                } else {
                    System.out.println("Erro: Saldo insuficiente para transferir para a conta " + contaDestino.getNumero());
                }
            }
        } else {
            System.out.println("Erro: Conta de débito não encontrada.");
        }
    }

    public int quantidadeDeContas() {
        return this.contas.size();
    }

    public float totalDeDinheiro() {
        float total = 0;
        for (Conta conta : this.contas) {
            total += conta.consultarSaldo();
        }
        return total;
    }

    public float mediaDeSaldo() {
        if (quantidadeDeContas() == 0) {
            return 0;
        }
        return totalDeDinheiro() / quantidadeDeContas();
    }
}
