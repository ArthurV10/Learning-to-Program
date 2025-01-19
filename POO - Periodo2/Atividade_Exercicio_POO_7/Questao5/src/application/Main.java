package application;
import entities.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();

        Produto produto1 = new Produto(1, "Arroz", 50, 5.50);
        ProdutoPerecivel produto2 = new ProdutoPerecivel(2, "Leite", 20, 3.50, LocalDate.of(2025, 1, 10));
        ProdutoPerecivel produto3 = new ProdutoPerecivel(3, "Queijo", 15, 12.00, LocalDate.of(2024, 12, 31));

        // Incluir produtos
        estoque.incluir(produto1);
        estoque.incluir(produto2);
        estoque.incluir(produto3);

        // Consultar produtos
        System.out.println("Consultando produto ID 2: " + estoque.consultar(2));

        // Repor estoque
        estoque.repor(1, 10);

        // Dar baixa
        estoque.darBaixa(3, 5);

        // Listar produtos perecíveis vencidos
        System.out.println("Produtos vencidos:");
        for (ProdutoPerecivel vencido : estoque.listarPereciveisVencidos()) {
            System.out.println(vencido);
        }
    }
}
