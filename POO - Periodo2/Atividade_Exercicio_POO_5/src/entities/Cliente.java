package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<Conta> contas; // Lista de contas associadas ao cliente

    public Cliente(int id, String nome, String cpf, Date dataNascimento, Conta conta) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contas = new ArrayList<>(); // Inicializa a lista de contas

        if (conta != null) {
            this.contas.add(conta); // Adiciona a conta inicial, se existir
        }
    }

    public String getNome(){
        return this.nome;
    }

    public int getId() {
        return this.id;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setConta(Conta contaCliente) {
        this.contas.add(contaCliente);
    }

    public List<Conta> listarContasCliente() {
        if (contas != null && !contas.isEmpty()) {
            for (int i = 0; i < this.contas.size(); i++) {
                System.out.println("Conta " + (i + 1) + ": " + contas.get(i).getNumero());
            }
            return this.contas;
        }
        System.out.println("Contas Inexistentes");
        return null;
    }

    public float totalizarSaldoCliente() {
        float valorTotal = 0;
        for (Conta contaCliente : this.contas) {
            valorTotal += contaCliente.consultarSaldo();
        }
        return valorTotal;
    }
}
