package com.bcopstein.casosdeuso.politicas;

import java.io.Console;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;

public class CalculoCustoViagemBasico implements ICalculoCustoViagem {
    private Roteiro roteiro;
    private Passageiro passageiro;

    @Override
    public void defineRoteiro(Roteiro roteiro) {
        if(roteiro != null)
            this.roteiro = roteiro;
        else 
            System.out.print("roteiro inválido");
    }

    @Override
    public void definePassageiro(Passageiro passageiro){
        if(passageiro != null)
            this.passageiro = passageiro;
        else 
            System.out.print("passageiro inválido");
    }

	public Roteiro getRoteiro() {
		return roteiro;
	}

	public Passageiro getPassageiro() {
		return passageiro;
	}
    
    @Override
    public double calculoCustoBasico() {
        assert roteiro != null : "roteiro inválido";
        Collection<Bairro> bairros = roteiro.bairrosPercoridos();
        bairros = bairros != null ? bairros : new LinkedList<>(); 

        return bairros
        .stream()
        .filter(Objects::nonNull)
        .mapToDouble(Bairro::getCustoTransporte)
        .sum();
    }

    @Override
    public double descontoPontuacao() {
        return 0.0;
    }

    @Override
    public double descontoPromocaoSazonal() {
        return 0.0;
    }

    @Override
    public double custoViagem() {
        return calculoCustoBasico() - 
                descontoPontuacao() -
                descontoPromocaoSazonal();
    }
}