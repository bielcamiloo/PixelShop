package com.pixelshop.testes;

import com.pixelshop.modelo.Produto;

public class TesteCriacaoProduto {
    public static void main(String[] args) {
        // Instancia dois produtos
        Produto p1 = new Produto("Controle sem Fio", 250.00, 10);
        Produto p2 = new Produto("Jogo RPG", 150.00, 5);

        // Altera o preço usando o setter validado
        p1.setPreco(230.00);

        // Imprime os dados utilizando os getters
        System.out.println("--- Dados do Produto 1 ---");
        System.out.println("Nome: " + p1.getNome());
        System.out.println("Preço: R$ " + p1.getPreco());
        System.out.println("Estoque: " + p1.getQuantidadeEstoque());

        System.out.println("\n--- Dados do Produto 2 ---");
        System.out.println("Nome: " + p2.getNome());
        System.out.println("Preço: R$ " + p2.getPreco());
        System.out.println("Estoque: " + p2.getQuantidadeEstoque());
    }
}
