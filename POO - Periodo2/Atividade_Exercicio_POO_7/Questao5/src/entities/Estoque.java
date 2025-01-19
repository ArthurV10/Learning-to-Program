package entities;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private List<Produto> produtos = new ArrayList<>();

    public boolean existe(int id, String descricao) {
        return produtos.stream().anyMatch(p -> p.getId() == id || p.getDescricao().equalsIgnoreCase(descricao));
    }

    public void incluir(Produto produto) {
        if (existe(produto.getId(), produto.getDescricao())) {
            System.out.println("Produto com ID ou descrição já existente.");
        } else {
            produtos.add(produto);
            System.out.println("Produto incluído com sucesso.");
        }
    }

    public Produto consultar(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void excluir(int id) {
        Produto produto = consultar(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void repor(int id, int quantidade) {
        Produto produto = consultar(id);
        if (produto != null) {
            produto.repor(quantidade);
            System.out.println("Reposição realizada com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public void darBaixa(int id, int quantidade) {
        Produto produto = consultar(id);
        if (produto != null) {
            produto.darBaixa(quantidade);
            System.out.println("Baixa realizada com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    public List<ProdutoPerecivel> listarPereciveisVencidos() {
        List<ProdutoPerecivel> vencidos = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto instanceof ProdutoPerecivel) {
                ProdutoPerecivel perecivel = (ProdutoPerecivel) produto;
                if (!perecivel.estaValido()) {
                    vencidos.add(perecivel);
                }
            }
        }
        return vencidos;
    }
}

