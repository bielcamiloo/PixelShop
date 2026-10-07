package com.pixelshop.modelo;

public class JogoFisico extends Produto implements Promovivel {
        private String plataforma;
        private boolean possuiManualImpresso;

        public JogoFisico(String nome, double precoInicial, int quantidadeInicial, String plataforma, boolean possuiManualImpresso) {
            super(nome, precoInicial, quantidadeInicial);
            this.plataforma = plataforma;
            this.possuiManualImpresso = possuiManualImpresso;
        }

        public String getPlataforma() {
            return plataforma;
        }

        public boolean isPossuiManualImpresso() {
            return possuiManualImpresso;
        }

        @Override
        public void aplicarDesconto(double porcentagem) {
            if (porcentagem > 0 && porcentagem <= 100) {
                this.preco -= this.preco * (porcentagem / 100.0);
            }
        }

        @Override
        public String toString() {
            return String.format("[Jogo Físico] %s | Plataforma: %s | Manual Impresso: %s",
                    super.toString(), plataforma, possuiManualImpresso ? "Sim" : "Não");
        }
    }

