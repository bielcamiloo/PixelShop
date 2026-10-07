package com.pixelshop.modelo;

import java.util.Objects;

public abstract class Produto {
    // Atributos protegidos para permitir acesso direto pelas subclasses
    protected String nome;
    protected double preco;
    protected int quantidadeEstoque;

    // Membro estático global para contagem de itens criados
    private static int totalProdutosCadastrados = 0;

    // Construtor
    public Produto(String nome, double precoInicial, int quantidadeInicial) {
        if (precoInicial < 0) {
            throw new IllegalArgumentException("O preço inicial não pode ser negativo.");
        }
        if (quantidadeInicial < 0) {
            throw new IllegalArgumentException("A quantidade inicial não pode ser negativa.");
        }

        this.nome = nome;
        this.preco = precoInicial;
        this.quantidadeEstoque = quantidadeInicial;

        // Incrementa o contador global
        totalProdutosCadastrados++;
    }

    // Getter do membro estático
    public static int getTotalProdutosCadastrados() {
        return totalProdutosCadastrados;
    }

    // Getters
    public String getNome() {
        return this.nome;
    }

    public double getPreco() {
        return this.preco;
    }

    public int getQuantidadeEstoque() {
        return this.quantidadeEstoque;
    }

    // Setters com validações (Mantidos do seu código original)
    public boolean setPreco(double preco) {
        if (preco > 0) {
            this.preco = preco;
            return true;
        } else {
            System.out.println("Erro: O preço deve ser maior que zero!");
            return false;
        }
    }

    public boolean setQuantidadeEstoque(int quantidade) {
        if (quantidade >= 0) {
            this.quantidadeEstoque = quantidade;
            return true;
        } else {
            System.out.println("Erro: A quantidade de estoque não pode ser negativa!");
            return false;
        }
    }

    // Métodos Operacionais
    public boolean adicionarEstoque(int qtd) {
        if (qtd > 0) {
            this.quantidadeEstoque += qtd;
            return true;
        } else {
            System.out.println("Erro: Quantidade a adicionar deve ser maior que zero!");
            return false;
        }
    }

    public boolean removerEstoque(int qtd) {
        if (qtd > 0 && qtd <= this.quantidadeEstoque) {
            this.quantidadeEstoque -= qtd;
            return true;
        } else {
            System.out.println("Erro: Quantidade inválida ou estoque insuficiente!");
            return false;
        }
    }

    // Sobrescrita do equals() para evitar duplicidades no sistema (com base no nome)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produto produto = (Produto) obj;
        return Objects.equals(nome.toLowerCase(), produto.nome.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }

    // Sobrescrita do toString() para exibição textual formatada
    @Override
    public String toString() {
        return String.format("Nome: %s | Preço: R$ %.2f | Estoque: %d", nome, preco, quantidadeEstoque);
    }
}