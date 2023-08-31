package com.example.AppSpringCalculos.Service;

import com.example.AppSpringCalculos.Entity.Saida;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
    public Saida calcular(Entrada entrada){
        Saida saida = new Saida();

        saida.setQuantidade(entrada.getValores().size());
        saida.setMedia(this.calcularMedia(entrada, saida.getQuantidade()));
        saida.setMediana(this.calcularMediana(entrada, saida.getQuantidade()));
        saida.setDesvioPadrao(this.calcularDesvioPadrao(entrada, saida));

        return saida;
    }

    private double calcularMedia(Entrada entrada, int quantidade){
        double soma = 0;

        for(Valor valor : entrada.getValores()){
            soma += valor.getValor();
        }

        return soma/quantidade;
    }

    private double calcularMediana(Entrada entrada, int quantidade){
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

    private Entrada ordenarEntrada(Entrada entrada, int quantidade){
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

    private double calcularDesvioPadrao(Entrada entrada, Saida saida){
        double desvioPadrao;
        double somatorioDiferencas = 0;

        for(Valor valor : entrada.getValores()){
            somatorioDiferencas += Math.pow(valor.getValor() - saida.getMedia(), 2);
        }

        desvioPadrao = Math.sqrt(somatorioDiferencas/saida.getQuantidade());

        return desvioPadrao;
    }
}
