package com.example.AppSpringCalculos.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Saida {
    private double media;
    private double desvioPadrao;
    private int quantidade;
    private double mediana;
    private int soma;
    private int maximo;
    private int minimo;
}