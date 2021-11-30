package com.bcopstein.casosdeuso.politicas;

import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;

public class CalculoCustoViagemRelampago extends CalculoCustoViagemBasico {
    @Override
    public double descontoPontuacao() {
        double custobasico = calculoCustoBasico();
        Passageiro passageiro = getPassageiro();
        assert passageiro != null : "passageiro inválido";

        if (passageiro.getPontuacaoMedia() > 5.0 &&
            passageiro.getQtdadeAvaliacoes() > 30){
            return custobasico * 0.05;
        }else{
            return 0.0;
        }
    }

    @Override
    public double descontoPromocaoSazonal() {
        Roteiro roteiro =  getRoteiro();
        assert roteiro != null : "roteiro inválido";

        int qtdadeBairros = roteiro.bairrosPercoridos().size();

        double cb = calculoCustoBasico();
        if (qtdadeBairros > 3){
            return cb*0.05;
        }else{
            return 0.0;
        }
    }  
}