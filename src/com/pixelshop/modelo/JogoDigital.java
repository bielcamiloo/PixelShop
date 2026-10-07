package com.pixelshop.modelo;

public class JogoDigital extends Produto {
    private double tamanhoGB;

    public JogoDigital(String nome, double precoInicial, int quantidadeInicial, double tamanhoGB) {
        super(nome, precoInicial, quantidadeInicial);
        this.tamanhoGB = tamanhoGB;
    }

    public double getTamanhoGB() {
        return tamanhoGB;
    }

    @Override
    public String toString() {
        return String.format("[Jogo Digital] %s | Tamanho: %.2f GB", super.toString(), tamanhoGB);
    }
}