package com.example.AppSpringCalculos;

import com.example.AppSpringCalculos.Entity.Entrada;
import com.example.AppSpringCalculos.Entity.Valor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class testeApiService {
    @Test
    public void testarOrdenacao(){
        Entrada entrada = new Entrada(List.of(new Valor(1), new Valor(20), new Valor(3), new Valor(4), new Valor(14), new Valor(6), new Valor(7),
                new Valor(8), new Valor(9), new Valor(10), new Valor(11), new Valor(12), new Valor(13), new Valor(5), new Valor(15), new Valor(17),
                new Valor(16), new Valor(18), new Valor(19), new Valor(2)));
    }
}
