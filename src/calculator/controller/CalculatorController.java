/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator.controller;

import calculator.enums.EnumOperacao;

/**
 *
 * @author Gabriel
 */
public class CalculatorController {

    private Double total;
    // 1. Adicionamos um controle para saber se o valor total já foi inicializado.
    private boolean totalInicializado;

    public CalculatorController() {
        zerar();
    }

    public Double realizaOperacao(EnumOperacao operacao, Double valor) {
        if (!totalInicializado) {
            total = valor;
            totalInicializado = true;
        } else {
            switch (operacao) {
                case SOMA:
                    total += valor;
                    break;
                case SUBTRACAO:
                    total -= valor;
                    break;
                case MULTIPLICACAO:
                    total *= valor;
                    break;
                case DIVISAO:
                    if (valor == 0) {
                        System.out.println("Erro: Divisão por zero não é permitida.");
                    } else {
                        total /= valor;
                    }
                    break;
            }
        }
        return total;
    }

    public Double getTotal() {
        return this.total;
    }

    public void zerar() {
        this.total = 0.0;
        this.totalInicializado = false;
    }
}
    
