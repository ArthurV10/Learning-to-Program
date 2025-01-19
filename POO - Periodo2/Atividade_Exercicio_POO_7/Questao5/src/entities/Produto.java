package entities;

import java.time.LocalDate;

public class Produto {
    private int id;
    private String descricao;
    private int quantidade;
    private double valorUnitario;

    public Produto(int id, String descricao, int quantidade, double valorUnitario) {
        this.id = id;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
    }

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void repor(int quantidade) {
        this.quantidade += quantidade;
    }

    public void darBaixa(int quantidade) {
        if (this.quantidade >= quantidade) {
            this.quantidade -= quantidade;
        } else {
            System.out.println("Quantidade insuficiente em estoque.");
        }
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", descricao=" + descricao + ", quantidade=" + quantidade +
                ", valorUnitario=" + valorUnitario + "]";
    }
}

