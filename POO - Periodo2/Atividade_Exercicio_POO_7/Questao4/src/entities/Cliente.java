package entities;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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

    public void removeAccount(Conta conta) {
        if (this.contas.contains(conta)) {
            this.contas.remove(conta);
        }
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setData(Scanner scanner){
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
        this.dataNascimento = dataNascimento;
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

    public double totalizarSaldoCliente() {
        double valorTotal = 0;
        for (Conta contaCliente : this.contas) {
            valorTotal += contaCliente.consultarSaldo();
        }
        return valorTotal;
    }

    public String toString() {
        return "Nome: " + this.nome + ", CPF: " + this.cpf + ", Data Nascimento: " + this.dataNascimento;
    }
}
