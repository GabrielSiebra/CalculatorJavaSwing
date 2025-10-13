/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculator.controller;

import calculator.enums.EnumOperacao;
import java.lang.Math;

/**
 *
 * @author Gabriel
 */
public class CalculatorController {

    private Double total;
    private boolean totalInicializado;

    public CalculatorController() {
        zerar();
    }

    public Double realizaOperacao(EnumOperacao operacao, Double valor) {
        if (operacao.equals(EnumOperacao.RAIZ)) {
            if (!totalInicializado) {
                System.out.println("Erro: Insira um número antes de calcular a raiz quadrada.");
                return total;
            }
            if (total < 0) {
                System.out.println("Erro: Não é possível calcular a raiz quadrada de um número negativo.");
            } else {
                total = Math.sqrt(total);
            }
            return total;
        }
        
        if (operacao.equals(EnumOperacao.QUADRADO)) {
            total = Math.pow(valor, 2);
            return total;
        }
        
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
                case QUADRADO:
                    total = Math.sqrt(total);
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
    
