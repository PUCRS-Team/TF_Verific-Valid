package com.bcopstein.casosdeuso.repositorios;

import java.util.List;

import com.bcopstein.entidades.Bairro;

public interface IRepositorioBairros {
    Bairro recuperaPorNome(String nomeBairro);
    List<Bairro> recuperaListaBairros();
}