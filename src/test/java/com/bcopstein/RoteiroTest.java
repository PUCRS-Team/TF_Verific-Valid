package com.bcopstein;
import java.util.ArrayList;
import java.util.Collection;

import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.geometria.Area;
import com.bcopstein.entidades.geometria.Ponto;
import com.bcopstein.entidades.geometria.Reta;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RoteiroTest {
    private ArrayList<Bairro> bairros;
    private Roteiro aux;

    @BeforeEach
    public void setup(){
        bairros = new ArrayList<>();
        bairros.add(Bairro.novoBairroRetangular("Centro", new Ponto(20,60), 30, 20, 7));
        bairros.add(Bairro.novoBairroRetangular("Centro Historico", new Ponto(10,20), 30, 20, 2));
        bairros.add(Bairro.novoBairroRetangular("Partenon", new Ponto(20,30), 30, 50, 11));
        bairros.add(Bairro.novoBairroRetangular("Cruzeiro", new Ponto(70,50), 30, 50, 20));

    }

    @Test
    public void roteiro_Test() {
        aux = new Roteiro(bairros.get(0), bairros.get(3), bairros);
        Reta roteiro = new Reta ( new Ponto (35,50), new Ponto (85,25));
        assertEquals(roteiro, aux.getRota());
    }

   @Test
    public void testaRotaPercorrida(){
        Roteiro Test_bairros = new Roteiro(bairros.get(0), bairros.get(2), bairros);
        Collection<Bairro> bairrosPercoBairros = new ArrayList<>();
        bairrosPercoBairros.add(bairros.get(0));
        bairrosPercoBairros.add(bairros.get(1));
        bairrosPercoBairros.add(bairros.get(2));

        Collection<Bairro> bairrosTest = Test_bairros.bairrosPercoridos();
        assertEquals(bairrosPercoBairros, bairrosTest);
    }


}
