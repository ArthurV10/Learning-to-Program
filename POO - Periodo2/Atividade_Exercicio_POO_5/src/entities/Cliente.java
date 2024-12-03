package entities;

import java.util.Date;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private List<Conta> contas;

    public Cliente (int id, String nome,String cpf,Date dataNascimento, Conta contas){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return this.id;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setConta(Conta contaCliente){
        this.contas.add(contaCliente);
    }

    public List<Conta> listarContasCliente() {
        if (contas != null) {
            for (int i = 0; i < this.contas.size(); i++) {
                System.out.println("Conta " + (i + 1) + ": " + contas.get(i));
            }
            return this.contas;
        }
        System.out.println("Contas Inexistentes");
        return null;
    }

    public float totalizarSaldoCliente(){
        float valorTotal = 0;
        for (Conta contaCliente : this.contas){
            valorTotal += contaCliente.consultarSaldo();
        }
        return valorTotal;
    }
}

