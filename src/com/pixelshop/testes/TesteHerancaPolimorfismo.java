package com.pixelshop.testes;

import com.pixelshop.modelo.JogoDigital;
import com.pixelshop.modelo.JogoFisico;
import com.pixelshop.modelo.Produto;

public class TesteHerancaPolimorfismo {
    public static void main(String[] args) {
        System.out.println("--- Teste de Herança, Polimorfismo e Equals ---");

        Produto p1 = new JogoFisico("God of War", 199.90, 10, "PS5", true);
        Produto p2 = new JogoDigital("God of War", 150.00, 999, 45.5);
        Produto p3 = new JogoFisico("Elden Ring", 249.90, 5, "Xbox Series X", false);

        System.out.println("p1 é igual a p2 (mesmo nome)? " + p1.equals(p2));
        System.out.println("p1 é igual a p3? " + p1.equals(p3));

        System.out.println("Total de produtos criados no sistema: " + Produto.getTotalProdutosCadastrados());
    }
}
