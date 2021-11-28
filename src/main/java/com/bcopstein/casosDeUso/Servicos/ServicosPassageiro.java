package com.bcopstein.casosdeuso.servicos;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.bcopstein.casosdeuso.repositorios.IRepositorioBairros;
import com.bcopstein.casosdeuso.repositorios.IRepositorioPassageiros;
import com.bcopstein.casosdeuso.politicas.CustoViagem;
import com.bcopstein.casosdeuso.politicas.ICalculoCustoViagem;
import com.bcopstein.entidades.Bairro;
import com.bcopstein.entidades.Passageiro;
import com.bcopstein.entidades.Roteiro;
import com.bcopstein.entidades.Viagem;

public class ServicosPassageiro {
    private IRepositorioBairros repBairros;
    private IRepositorioPassageiros repPassageiros;
    private CustoViagem custoViagem;

    public ServicosPassageiro(IRepositorioBairros repBairros, IRepositorioPassageiros repPassageiros,
            ICalculoCustoViagem ccv) {
        this.repBairros = repBairros;
        this.repPassageiros = repPassageiros;
        this.custoViagem = new CustoViagem(ccv);
    }

    public List<String> getListaBairros(){
        return repBairros.recuperaListaBairros()
                .stream()
                .map(b->b.getNome())
                .collect(Collectors.toList());
    }

    public List<String> getPassageirosCadastrados(){
        return repPassageiros.listaPassageiros()
                .stream()
                .map(p->p.getNome())
                .collect(Collectors.toList());
    }

    public Roteiro criaRoteiro(String bairroOrigem,String bairroDestino){
        Collection<Bairro> todosBairros = repBairros.recuperaListaBairros();
        Bairro bOrigem = repBairros.recuperaPorNome(bairroOrigem);
        Bairro bDestino = repBairros.recuperaPorNome(bairroDestino);
        return new Roteiro(bOrigem,bDestino,todosBairros);
    }

    public Viagem criaViagem(int id,Roteiro roteiro,String cpfPassageiro){
        LocalDateTime data = LocalDateTime.now();
        Passageiro passageiro = repPassageiros.recuperaPorCPF(cpfPassageiro);
        double valorCobrado = custoViagem.custoViagem(roteiro, passageiro);
        return new Viagem(id,data,roteiro,passageiro,valorCobrado);
    }
}