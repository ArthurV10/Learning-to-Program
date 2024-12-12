package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private List<Conta> contas;

    public Cliente(int id, String nome, String cpf, LocalDate dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contas = new ArrayList<>();
    }

    public LocalDate getDataNascimento() {
        return this.dataNascimento;
    }   

    public String getNome() {
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
        if (contas != null) {
            for (int i = 0; i < this.contas.size(); i++) {
                System.out.println("Codigo Conta " + (i + 1) + ": " + contas.get(i).getNumero());
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

    public String toString() {
        return "Nome: " + this.nome + ", CPF: " + this.cpf + ", Data Nascimento: " + this.dataNascimento;
    }
}
