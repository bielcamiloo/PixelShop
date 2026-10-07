package com.pixelshop;

import com.pixelshop.modelo.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Produto> estoque = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        consultarEstoque();
                        break;
                    case 3:
                        realizarEntradaEstoque();
                        break;
                    case 4:
                        realizarSaidaEstoque();
                        break;
                    case 5:
                        aplicarDescontoPromocional();
                        break;
                    case 6:
                        exibirTotalizadorGlobal();
                        break;
                    case 0:
                        System.out.println("Encerrando o sistema PixelShop...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, insira um número válido.");
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
            System.out.println();
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=========================================");
        System.out.println("      PIXELSHOP - MENU DE GESTÃO         ");
        System.out.println("=========================================");
        System.out.println("1. Cadastrar novo produto");
        System.out.println("2. Consultar dados e valor total em estoque");
        System.out.println("3. Realizar entrada de estoque");
        System.out.println("4. Realizar saída de estoque");
        System.out.println("5. Aplicar descontos promocionais em lote");
        System.out.println("6. Exibir totalizador global de produtos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarProduto() {
        System.out.println("\n--- Cadastrar Novo Produto ---");
        System.out.println("1. Jogo Físico");
        System.out.println("2. Jogo Digital");
        System.out.print("Escolha o tipo de produto: ");
        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();

        for (Produto p : estoque) {
            Produto aux = (tipo == 1) ?
                    new JogoFisico(nome, 0, 0, "", false) :
                    new JogoDigital(nome, 0, 0, 0);

            if (p.equals(aux)) {
                System.out.println("Erro: Já existe um produto cadastrado com esse nome!");
                return;
            }
        }

        System.out.print("Preço inicial: R$ ");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.print("Quantidade em estoque: ");
        int qtd = Integer.parseInt(scanner.nextLine());

        if (tipo == 1) {
            System.out.print("Plataforma: ");
            String plataforma = scanner.nextLine();
            System.out.print("Possui manual impresso? (s/n): ");
            boolean manual = scanner.nextLine().trim().equalsIgnoreCase("s");

            estoque.add(new JogoFisico(nome, preco, qtd, plataforma, manual));
            System.out.println("Jogo Físico cadastrado com sucesso!");
        } else if (tipo == 2) {
            System.out.print("Tamanho do arquivo (GB): ");
            double tamanhoGB = Double.parseDouble(scanner.nextLine());

            estoque.add(new JogoDigital(nome, preco, qtd, tamanhoGB));
            System.out.println("Jogo Digital cadastrado com sucesso!");
        } else {
            System.out.println("Tipo de produto inválido!");
        }
    }

    private static void consultarEstoque() {
        System.out.println("\n--- Consulta do Estoque ---");
        if (estoque.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        double valorTotalEstoque = 0;
        for (Produto p : estoque) {
            System.out.println(p);
            valorTotalEstoque += (p.getPreco() * p.getQuantidadeEstoque());
        }
        System.out.printf("\nValor total do estoque: R$ %.2f\n", valorTotalEstoque);
    }

    private static void realizarEntradaEstoque() {
        System.out.println("\n--- Entrada de Estoque ---");
        Produto p = buscarProdutoPorNome();
        if (p != null) {
            System.out.print("Quantidade a adicionar: ");
            int qtd = Integer.parseInt(scanner.nextLine());
            if (p.adicionarEstoque(qtd)) {
                System.out.println("Estoque atualizado com sucesso!");
            }
        }
    }

    private static void realizarSaidaEstoque() {
        System.out.println("\n--- Saída de Estoque ---");
        Produto p = buscarProdutoPorNome();
        if (p != null) {
            System.out.print("Quantidade a remover: ");
            int qtd = Integer.parseInt(scanner.nextLine());
            if (p.removerEstoque(qtd)) {
                System.out.println("Estoque reduzido com sucesso!");
            }
        }
    }

    private static void aplicarDescontoPromocional() {
        System.out.println("\n--- Aplicar Desconto Promocional em Lote ---");
        System.out.print("Informe a % de desconto para produtos elegíveis: ");
        double porcentagem = Double.parseDouble(scanner.nextLine());

        int afetados = 0;
        for (Produto p : estoque) {
            if (p instanceof Promovivel) {
                ((Promovivel) p).aplicarDesconto(porcentagem);
                afetados++;
            }
        }
        System.out.printf("Desconto aplicado com sucesso em %d item(ns)!\n", afetados);
    }

    private static void exibirTotalizadorGlobal() {
        System.out.println("\n--- Totalizador Global de Produtos ---");
        System.out.println("Total de produtos criados no sistema: " + Produto.getTotalProdutosCadastrados());
    }

    private static Produto buscarProdutoPorNome() {
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        for (Produto p : estoque) {
            if (p.getNome().equalsIgnoreCase(nome)) {
                return p;
            }
        }
        System.out.println("Produto não encontrado.");
        return null;
    }
}