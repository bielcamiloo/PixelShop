package com.pixelshop.testes;

import com.pixelshop.modelo.JogoDigital;
import com.pixelshop.modelo.JogoFisico;
import com.pixelshop.modelo.Produto;
import com.pixelshop.modelo.Promovivel;

public class TestePromocaoInterface {
    public static void main(String[] args) {
        System.out.println("--- Teste da Interface Promovivel ---");

        Produto jogoFisico = new JogoFisico("Zelda: TOTK", 300.00, 8, "Nintendo Switch", true);
        Produto jogoDigital = new JogoDigital("Cyberpunk 2077", 120.00, 500, 70.0);

        System.out.println("Estado Inicial:");
        System.out.println(jogoFisico);
        System.out.println(jogoDigital);

        if (jogoFisico instanceof Promovivel) {
            ((Promovivel) jogoFisico).aplicarDesconto(10);
            System.out.println("\nDesconto de 10% aplicado ao Jogo Físico!");
        }

        if (jogoDigital instanceof Promovivel) {
            ((Promovivel) jogoDigital).aplicarDesconto(10);
        } else {
            System.out.println("\nJogo Digital não implementa Promovivel (Sem desconto).");
        }

        System.out.println("\nEstado Final:");
        System.out.println(jogoFisico);
        System.out.println(jogoDigital);
    }
}