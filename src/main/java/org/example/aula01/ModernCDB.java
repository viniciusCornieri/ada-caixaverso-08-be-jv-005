package org.example.aula01;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ModernCDB {

    private final String identificador;
    private final LocalDate dataDeCriacao;
    private final BigDecimal valor;
    private final int prazoEmDias;
    private boolean estaAtivo;

    public ModernCDB(String identificador, LocalDate dataDeCriacao, BigDecimal valor, int prazoEmDias) {
        this.identificador = identificador;
        this.dataDeCriacao = dataDeCriacao;
        this.valor = valor;
        this.prazoEmDias = prazoEmDias;
        this.estaAtivo = true;
    }

    public String getIdentificador() {
        return identificador;
    }

    public LocalDate getDataDeCriacao() {
        return dataDeCriacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getPrazoEmDias() {
        return prazoEmDias;
    }

    public LocalDate getDataVencimento() {
        return dataDeCriacao.plusDays(prazoEmDias);
    }

    public boolean estaEncerrado(LocalDate dataAtual){
        return dataAtual.isAfter(getDataVencimento());
    }

    public boolean fecharCdb(){
        return estaAtivo = false;
    }

    public boolean estaAtivo() {
        return estaAtivo;
    }

    @Override
    public String toString() {
        return "LegacyCDB{id: %s, dataCriacao: %s, valor: %s, prazoEmDias: %s, ativo: %s}"
                .formatted(identificador, dataDeCriacao, valor, prazoEmDias, estaAtivo);
    }
}
