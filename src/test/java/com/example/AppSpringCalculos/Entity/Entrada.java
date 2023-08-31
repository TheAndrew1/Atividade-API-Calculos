package com.example.AppSpringCalculos.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class Entrada {
    private List<Valor> valores;

    public void ordenarValores(){
        boolean ordenado = true;

        do {
            ordenado = true;

            for(int i = 0; i < (valores.size() - 1); i++){
                int aux;
                if (valores.get(i).getValor() > valores.get(i+1).getValor()){
                    aux = valores.get(i).getValor();
                    valores.get(i).setValor(valores.get(i+1).getValor());
                    valores.get(i+1).setValor(aux);

                    ordenado = false;
                }
            }
        }while (!ordenado);
    }
}