package com.bcopstein;


import java.util.ArrayList;
import java.time.LocalDateTime;
import com.bcopstein.entidades.*;

import org.junit.jupiter.api.BeforeEach;
import com.bcopstein.entidades.geometria.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class ViagemTest {
    private Viagem viagem;
    private ArrayList<Bairro> bairros;
    private Roteiro roteiro;
    private Passageiro passageiro;
    private LocalDateTime time;


    @BeforeEach
    public void setup(){
        bairros = new ArrayList<Bairro>();
        bairros.add(Bairro.novoBairroRetangular("Centro", new Ponto(20,60), 30, 20, 7));
        bairros.add(Bairro.novoBairroRetangular("Centro Historico", new Ponto(10,20), 30, 20, 2));
        bairros.add(Bairro.novoBairroRetangular("Partenon", new Ponto(20,30), 30, 50, 11));
        bairros.add(Bairro.novoBairroRetangular("Cruzeiro", new Ponto(70,50), 30, 50, 20));

        roteiro = new Roteiro(bairros.get(0), bairros.get(3), bairros);
        passageiro = Passageiro.novoPassageiro("01784522031", "Pedro");
        time = LocalDateTime.now();
        viagem = new Viagem(3, time, roteiro, passageiro, 100);
        }

        @Test
        public void viagemTest(){
            assertEquals(time, viagem.getDataHora());
            assertEquals(3, viagem.getId());
            assertEquals(roteiro, viagem.getRoteiro());
            assertEquals(100, viagem.getValorCobrado());
        }
}