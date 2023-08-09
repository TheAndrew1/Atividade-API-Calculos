package com.example.AppSpringCalculos.Entity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Saida {
    @Getter @Setter
    private double media;
    @Getter @Setter
    private double devioPadrao;
    @Getter @Setter
    private int quantidade;
    @Getter @Setter
    private int mediana;
}