package com.example.AppSpringCalculos.Service;

import com.example.AppSpringCalculos.Entity.Entrada;
import com.example.AppSpringCalculos.Entity.Saida;
import com.example.AppSpringCalculos.Entity.Valor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ApiService {
    public Saida calcular(Entrada entrada){
        Assert.isTrue(entrada.getValores().size() >= 20, "Deve conter mais de 20 valores!");

        Saida saida = new Saida();

        saida.setQuantidade(entrada.getValores().size());
        saida.setMedia(this.calcularMedia(entrada, saida.getQuantidade()));
        saida.setMediana(this.calcularMediana(entrada, saida.getQuantidade()));
        saida.setDesvioPadrao(this.calcularDesvioPadrao(entrada, saida));
        saida.setSoma(this.calcularSoma(entrada));
        saida.setMaximo(this.verificarMaximo(entrada));
        saida.setMinimo(this.verificarMinimo(entrada));

        return saida;
    }

    public double calcularMedia(Entrada entrada, int quantidade){
        double soma = 0;

        for(Valor valor : entrada.getValores()){
            soma += valor.getValor();
        }

        return soma/quantidade;
    }

    public double calcularMediana(Entrada entrada, int quantidade){
        double mediana;
        Entrada entradaOrdenada = this.ordenarEntrada(entrada, quantidade);

        if (quantidade % 2 == 0){
            mediana = ((double) entradaOrdenada.getValores().get((quantidade / 2) - 1).getValor() + entradaOrdenada.getValores().get((quantidade / 2)).getValor()) / 2;
        }
        else {
            mediana = entradaOrdenada.getValores().get(Math.floorDiv(quantidade, 2)).getValor();
        }

        return mediana;
    }

    public Entrada ordenarEntrada(Entrada entrada, int quantidade){
        boolean ordenado = true;

         do {
            ordenado = true;

            for(int i = 0; i < (quantidade - 1); i++){
                int aux;
                if (entrada.getValores().get(i).getValor() > entrada.getValores().get(i+1).getValor()){
                    aux = entrada.getValores().get(i).getValor();
                    entrada.getValores().get(i).setValor(entrada.getValores().get(i+1).getValor());
                    entrada.getValores().get(i+1).setValor(aux);

                    ordenado = false;
                }
            }
        }while (!ordenado);

        return entrada;
    }

    public double calcularDesvioPadrao(Entrada entrada, Saida saida){
        double desvioPadrao;
        double somatorioDiferencas = 0;

        for(Valor valor : entrada.getValores()){
            somatorioDiferencas += Math.pow(valor.getValor() - saida.getMedia(), 2);
        }

        desvioPadrao = Math.sqrt(somatorioDiferencas/saida.getQuantidade());

        return desvioPadrao;
    }

    public int calcularSoma(Entrada entrada) {
        int soma = 0;

        for(Valor valor : entrada.getValores()){
            soma += valor.getValor();
        }

        return soma;
    }

    public int verificarMaximo(Entrada entrada) {
        int max = entrada.getValores().get(0).getValor();

        for(Valor valor : entrada.getValores()){
            if (valor.getValor() > max){
                max = valor.getValor();
            }
        }

        return max;
    }

    public int verificarMinimo(Entrada entrada) {
        int min = entrada.getValores().get(0).getValor();

        for(Valor valor : entrada.getValores()){
            if (valor.getValor() < min){
                min = valor.getValor();
            }
        }

        return min;
    }
}
