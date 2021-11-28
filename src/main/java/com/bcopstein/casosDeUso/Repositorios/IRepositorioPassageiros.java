package com.bcopstein.casosdeuso.repositorios;

import java.util.List;

import com.bcopstein.entidades.Passageiro;

public interface IRepositorioPassageiros {
    List<Passageiro> listaPassageiros();
    Passageiro recuperaPorCPF(String cpf);
    void atualizaPassageiro(Passageiro passageiro);
}