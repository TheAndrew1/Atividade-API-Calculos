package com.example.AppSpringCalculos.Service;

import com.example.AppSpringCalculos.Entity.Entrada;
import com.example.AppSpringCalculos.Entity.Saida;
import com.example.AppSpringCalculos.Entity.Valor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class ApiService {
    public Saida calcular(Entrada entrada){
        Saida saida = new Saida();

        saida.setMedia(calcularMedia(entrada));
        saida.setQuantidade(entrada.getValores().size());

        return saida;
    }

    public double calcularMedia(Entrada valores){
        double soma = 0;
        int tamanho = valores.getValores().size();

        for(Valor valor : valores.getValores()){
            soma += valor.getValor();
        }

        double media = soma/tamanho;

        return media;
    }
}
