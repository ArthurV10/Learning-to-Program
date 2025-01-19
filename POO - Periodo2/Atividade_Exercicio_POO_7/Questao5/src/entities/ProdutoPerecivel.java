package entities;

import java.time.LocalDate;

public class ProdutoPerecivel extends Produto {
    private LocalDate dataValidade;

    public ProdutoPerecivel(int id, String descricao, int quantidade, double valorUnitario, LocalDate dataValidade) {
        super(id, descricao, quantidade, valorUnitario);
        this.dataValidade = dataValidade;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public boolean estaValido() {
        return !LocalDate.now().isAfter(dataValidade);
    }

    @Override
    public void repor(int quantidade) {
        if (estaValido()) {
            super.repor(quantidade);
        } else {
            System.out.println("Não é possível repor um produto vencido.");
        }
    }

    @Override
    public void darBaixa(int quantidade) {
        if (estaValido()) {
            super.darBaixa(quantidade);
        } else {
            System.out.println("Não é possível dar baixa em um produto vencido.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", dataValidade=" + dataValidade;
    }
}

