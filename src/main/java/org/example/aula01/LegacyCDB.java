package org.example.aula01;

import java.math.BigDecimal;
import java.util.Date;

public class LegacyCDB {

    private final String identificador;
    private final Date dataDeCriacao;
    private final BigDecimal valor;
    private final int prazoEmDias;
    private boolean estaAtivo;

    public LegacyCDB(String identificador, Date dataDeCriacao, BigDecimal valor, int prazoEmDias) {
        this.identificador = identificador;
        this.dataDeCriacao = dataDeCriacao;
        this.valor = valor;
        this.prazoEmDias = prazoEmDias;
        this.estaAtivo = true;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Date getDataDeCriacao() {
        return dataDeCriacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getPrazoEmDias() {
        return prazoEmDias;
    }

    public Date getDataVencimento() {
        Date dataDeVencimento = dataDeCriacao;
        long prazoEmHoras = prazoEmDias * 24L;
        long prazoEmMinutos = prazoEmHoras * 60L;
        long prazoEmSegundos = prazoEmMinutos * 60L;
        long prazoEmMillisegundos = prazoEmSegundos * 1000L;
        dataDeVencimento.setTime(dataDeCriacao.getTime() + prazoEmMillisegundos);
        System.out.println("DataVencimento: " + dataDeVencimento);
        return dataDeVencimento;
    }

    public boolean estaEncerrado(Date dataAtual){
        return dataAtual.after(getDataVencimento());
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
