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
    private String message;

    public CalculatorController() {
        zerar();
    }

    public Double realizaOperacao(EnumOperacao operacao, Double valor) {
        this.message = ""; 

        if (operacao.equals(EnumOperacao.RAIZ)) {
            if (valor < 0) {
                this.message = "Erro: Não é possível calcular a raiz quadrada de um número negativo.";
                return total;
            } else {
                total = Math.sqrt(valor);
                this.totalInicializado = true;
                return total;
            }
        }
                   
        if (operacao.equals(EnumOperacao.PORCENTAGEM)) {
            if(this.totalInicializado){
                Double valorCalculado = this.total * (valor/100.0);
                return valorCalculado;
            }else{
            this.total = valor / 100.0;
            this.totalInicializado = true;
            return this.total;
            }
        }
        
        
        if(operacao.equals(EnumOperacao.PRIMO)){
            boolean Primo = true;

            if (valor <= 1 || (valor % 1 !=0)) {
                Primo = false;
            } else if (valor == 2) {
                Primo = true;
            } else if (valor % 2 == 0) {
                Primo = false;
            } else {
                for (int i = 3; i <= Math.sqrt(valor); i += 2) {
                    if (valor % i == 0) {
                        Primo = false;
                        break;
                    }
                }
            }
            if (Primo) {
                this.message = "Esse número é primo!";
            } else {
                this.message = "Esse número não é primo!";
            }
            this.total = valor;
            this.totalInicializado = true;
            return this.total;
        }

        if (operacao.equals(EnumOperacao.QUADRADO)) {
            total = Math.pow(valor, 2);
            this.totalInicializado = true;
            return total;
        }
        
        if (operacao == null || !this.totalInicializado) {
            this.total = valor;
            this.totalInicializado = true;
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
                        this.message = "Erro: Divisão por zero não é permitida.";
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
        this.message = "";
    }
    
    public String getMessage() {
        String msg = this.message;
        this.message = "";
        return msg;
    }
}
    
