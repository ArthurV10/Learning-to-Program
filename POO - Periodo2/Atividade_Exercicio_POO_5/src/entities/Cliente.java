package entities;

import java.util.Date;
import entities.Conta;

public class Cliente {
    int id;
    String nome;
    String cpf;
    Date dataNascimento;
    Conta[] contas;

    public Cliente (int id, String nome,String cpf,Date dataNascimento, Conta contas){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.contas.append(contas);
    }

    public
}
