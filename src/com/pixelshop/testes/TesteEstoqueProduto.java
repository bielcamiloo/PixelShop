package com.pixelshop.testes;

import com.pixelshop.modelo.Produto;

public class TesteEstoqueProduto {
    public static void main(String[] args) {
        Produto produto = new Produto("Console Pixel", 2000.00, 5);

        System.out.println("Estoque inicial: " + produto.getQuantidadeEstoque());

        // Testando adicionar estoque
        produto.adicionarEstoque(3);
        System.out.println("Após adicionar 3: " + produto.getQuantidadeEstoque());

        // Testando remover com SUCESSO
        produto.removerEstoque(2);
        System.out.println("Após remover 2: " + produto.getQuantidadeEstoque());

        // Testando remover com FALHA (quantidade maior que o disponível)
        System.out.println("Tentando remover 10 unidades...");
        produto.removerEstoque(10);

        // Testando validação do setter de preço
        System.out.println("Tentando definir preço inválido (-50.0)...");
        produto.setPreco(-50.0);
    }
}
