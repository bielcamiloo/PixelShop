package com.pixelshop;

import com.pixelshop.modelo.Produto;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Armazenando produtos em variáveis de referência
        Produto produto1 = null;
        Produto produto2 = null;

        int opcao = 0;

        do {
            System.out.println("\n==================================");
            System.out.println("      PIXELSHOP - MENU DE GESTÃO  ");
            System.out.println("==================================");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Consultar dados e valor total em estoque");
            System.out.println("3. Realizar entrada (adição) de estoque");
            System.out.println("4. Realizar saída (remoção) de estoque");
            System.out.println("5. Alterar preço de um produto");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do teclado

            switch (opcao) {
                case 1:
                    System.out.print("Deseja cadastrar no Produto 1 ou 2? ");
                    int numProd = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço inicial: R$ ");
                    double preco = scanner.nextDouble();
                    System.out.print("Estoque inicial: ");
                    int qtd = scanner.nextInt();

                    if (numProd == 1) {
                        produto1 = new Produto(nome, preco, qtd);
                        System.out.println("Produto 1 cadastrado com sucesso!");
                    } else if (numProd == 2) {
                        produto2 = new Produto(nome, preco, qtd);
                        System.out.println("Produto 2 cadastrado com sucesso!");
                    } else {
                        System.out.println("Opção de produto inválida!");
                    }
                    break;

                case 2:
                    System.out.print("Consultar Produto (1 ou 2): ");
                    int pConsulta = scanner.nextInt();
                    Produto pSel = (pConsulta == 1) ? produto1 : (pConsulta == 2) ? produto2 : null;

                    if (pSel != null) {
                        double valorTotal = pSel.getPreco() * pSel.getQuantidadeEstoque();
                        System.out.println("\n--- Dados do Produto ---");
                        System.out.println("Nome: " + pSel.getNome());
                        System.out.println("Preço Unitário: R$ " + pSel.getPreco());
                        System.out.println("Estoque: " + pSel.getQuantidadeEstoque());
                        System.out.println("Valor Total em Estoque: R$ " + valorTotal);
                    } else {
                        System.out.println("Produto não cadastrado ou seleção inválida!");
                    }
                    break;

                case 3:
                    System.out.print("Adicionar estoque no Produto (1 ou 2): ");
                    int pAdd = scanner.nextInt();
                    Produto pAddObj = (pAdd == 1) ? produto1 : (pAdd == 2) ? produto2 : null;

                    if (pAddObj != null) {
                        System.out.print("Quantidade a adicionar: ");
                        int addQtd = scanner.nextInt();
                        if (pAddObj.adicionarEstoque(addQtd)) {
                            System.out.println("Estoque atualizado com sucesso!");
                        }
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 4:
                    System.out.print("Remover estoque do Produto (1 ou 2): ");
                    int pRem = scanner.nextInt();
                    Produto pRemObj = (pRem == 1) ? produto1 : (pRem == 2) ? produto2 : null;

                    if (pRemObj != null) {
                        System.out.print("Quantidade a remover: ");
                        int remQtd = scanner.nextInt();
                        if (pRemObj.removerEstoque(remQtd)) {
                            System.out.println("Estoque reduzido com sucesso!");
                        }
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 5:
                    System.out.print("Alterar preço do Produto (1 ou 2): ");
                    int pAlt = scanner.nextInt();
                    Produto pAltObj = (pAlt == 1) ? produto1 : (pAlt == 2) ? produto2 : null;

                    if (pAltObj != null) {
                        System.out.print("Novo preço: R$ ");
                        double novoPreco = scanner.nextDouble();
                        if (pAltObj.setPreco(novoPreco)) {
                            System.out.println("Preço alterado com sucesso!");
                        }
                    } else {
                        System.out.println("Produto não encontrado!");
                    }
                    break;

                case 6:
                    System.out.println("Saindo do sistema PixelShop... Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 6);

        scanner.close();
    }
}
