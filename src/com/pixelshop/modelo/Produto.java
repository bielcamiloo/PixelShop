package com.pixelshop.modelo;

public class Produto {

        // --- Atributos Privados (Encapsulamento) ---
        private String nome;
        private double preco;
        private int quantidadeEstoque;

        // --- Construtor ---
        public Produto(String nome, double precoInicial, int quantidadeInicial) {
            this.nome = nome;

            // Validação do preço inicial: se negativo, atribui 0.0
            if (precoInicial < 0) {
                this.preco = 0.0;
            } else {
                this.preco = precoInicial;
            }

            // Validação da quantidade inicial: se negativo, atribui 0
            if (quantidadeInicial < 0) {
                this.quantidadeEstoque = 0;
            } else {
                this.quantidadeEstoque = quantidadeInicial;
            }
        }

        // --- Getters ---
        public String getNome() {
            return this.nome;
        }

        public double getPreco() {
            return this.preco;
        }

        public int getQuantidadeEstoque() {
            return this.quantidadeEstoque;
        }

        // --- Setters com Validação (Retornam boolean) ---
        public boolean setPreco(double preco) {
            // O preço deve ser maior que zero
            if (preco > 0) {
                this.preco = preco;
                return true;
            } else {
                System.out.println("Erro: O preço deve ser maior que zero!");
                return false;
            }
        }

        public boolean setQuantidadeEstoque(int quantidade) {
            // O estoque não pode ser negativo
            if (quantidade >= 0) {
                this.quantidadeEstoque = quantidade;
                return true;
            } else {
                System.out.println("Erro: A quantidade de estoque não pode ser negativa!");
                return false;
            }
        }

        // --- Métodos Operacionais ---
        public boolean adicionarEstoque(int qtd) {
            // Adiciona quantidade se o valor for maior que zero
            if (qtd > 0) {
                this.quantidadeEstoque += qtd;
                return true;
            } else {
                System.out.println("Erro: Quantidade a adicionar deve ser maior que zero!");
                return false;
            }
        }

        public boolean removerEstoque(int qtd) {
            // Remove se o valor for maior que zero E houver saldo suficiente
            if (qtd > 0 && qtd <= this.quantidadeEstoque) {
                this.quantidadeEstoque -= qtd;
                return true;
            } else {
                System.out.println("Erro: Quantidade inválida ou estoque insuficiente!");
                return false;
            }
        }
}

