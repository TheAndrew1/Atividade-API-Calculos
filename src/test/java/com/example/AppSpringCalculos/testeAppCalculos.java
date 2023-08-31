package com.example.AppSpringCalculos;

import com.example.AppSpringCalculos.Entity.Entrada;
import com.example.AppSpringCalculos.Entity.Saida;
import com.example.AppSpringCalculos.Entity.Valor;
import com.example.AppSpringCalculos.Service.ApiService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testeAppCalculos {
    @Test
    public void testCalcularMedia(){
        ApiService apiService = new ApiService();
        
        Entrada entrada = new Entrada(List.of(new Valor(1), new Valor(20), new Valor(3), new Valor(4), new Valor(14), new Valor(6), new Valor(7),
                new Valor(8), new Valor(9), new Valor(10), new Valor(11), new Valor(12), new Valor(13), new Valor(5), new Valor(15), new Valor(17),
                new Valor(16), new Valor(18), new Valor(19), new Valor(2)));

        double media = apiService.calcularMedia(entrada, entrada.getValores().size());
        Assert.assertEquals(10.5, media, 0);
    }

    @Test
    public void testCalcularMediana(){
        ApiService apiService = new ApiService();

        Entrada entrada = new Entrada(List.of(new Valor(1), new Valor(20), new Valor(3), new Valor(4), new Valor(14), new Valor(6), new Valor(7),
                new Valor(8), new Valor(9), new Valor(10), new Valor(11), new Valor(12), new Valor(13), new Valor(5), new Valor(15), new Valor(17),
                new Valor(16), new Valor(18), new Valor(19), new Valor(2)));

        double mediana = apiService.calcularMediana(entrada, entrada.getValores().size());
        Assert.assertEquals(10.5, mediana, 0);
    }

    @Test
    public void testCalcularDesvioPadrao(){
        ApiService apiService = new ApiService();

        Entrada entrada = new Entrada(List.of(new Valor(1), new Valor(20), new Valor(3), new Valor(4), new Valor(14), new Valor(6), new Valor(7),
                new Valor(8), new Valor(9), new Valor(10), new Valor(11), new Valor(12), new Valor(13), new Valor(5), new Valor(15), new Valor(17),
                new Valor(16), new Valor(18), new Valor(19), new Valor(2)));

        Saida saida = new Saida(10.5, 0, 20, 10.5);

        double desvioPadrao = apiService.calcularDesvioPadrao(entrada, saida);
        Assert.assertEquals(5.766, desvioPadrao, 0);
    }
}
