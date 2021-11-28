package com.bcopstein;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.bcopstein.entidades.Passageiro;

import org.junit.jupiter.api.Test;

public class PassageiroTest {
    
    @Test
    public void  novoPassageiroTest(){
        Passageiro passageiro = Passageiro.novoPassageiro("01784522034", "Mario Quintana"); //cria o objeto passageiro.
        assertEquals("Mario Quintana", passageiro.getNome());  //teste do nome.
        assertEquals("01784522034", passageiro.getCPF()); // teste do cpf.
        assertEquals(8, passageiro.getPontuacaoAcumulada()); //teste de pontuação acumulada.
        assertEquals(1, passageiro.getQtdadeAvaliacoes()); // teste de avaliação do motorista.
        assertEquals(8, passageiro.getPontuacaoMedia()); //teste da pontuação média.
    }

    @Test
    public void  passageiroExistenteTest(){
        Passageiro passageiro = Passageiro.passageiroExistente("01781232034", "Francisco da Silva",20,10); //cria o objeto passageiro.
        assertEquals("Francisco da Silva", passageiro.getNome());  //teste do nome.
        assertEquals("01781232034", passageiro.getCPF()); // teste do cpf.
        assertEquals(20, passageiro.getPontuacaoAcumulada()); //teste de pontuação acumulada.
        assertEquals(10, passageiro.getQtdadeAvaliacoes()); // teste de avaliação do motorista.
        assertEquals(2, passageiro.getPontuacaoMedia()); //teste da pontuação média.
    }

    @Test
    public void infoPontuacaoTest(){
        Passageiro passageiro = Passageiro.novoPassageiro("17834233412","João Pedro");
        passageiro.infoPontuacao(30);
        assertEquals(38, passageiro.getPontuacaoAcumulada());
        assertEquals(2, passageiro.getQtdadeAvaliacoes());
    }

    @Test
    public void toStringTest() {
        Passageiro passageiro = Passageiro.passageiroExistente("01784522031", "Silvio", 40, 17);

        String expected = "Passageiro [cpf=" + "01784522031" + ", nome=" + "Silvio" + ", pontuacaoAcumulada=" + 40
        + ", qtdadeAvaliacoes=" + 17 + "]";

        assertEquals(expected, passageiro.toString());
    }
}
