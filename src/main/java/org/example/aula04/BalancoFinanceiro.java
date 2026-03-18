package org.example.aula04;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.example.aula04.BalancoFinanceiro.TipoDeTransacao.CREDITO;
import static org.example.aula04.BalancoFinanceiro.TipoDeTransacao.DEBITO;

/**
 * Um banco moderno precisa consolidar o saldo final de seus clientes a partir de uma lista de transações.
 * Implemente um record `Transacao(BigDecimal valor, TipoTransacao tipo)` onde `TipoTransacao` é um `Enum`
 * com os valores `CREDITO` e `DEBITO`.
 * Sua tarefa é processar uma lista dessas transações e produzir o valor final do saldo,
 * considerando que cada tipo de transação afeta o saldo de forma diferente.
 *
 * Exemplo:
 *
 * Entrada:
 * Transacao[100.00, CREDITO]
 * Transacao[50.00, DEBITO]
 * Transacao[200.00, CREDITO]
 *
 * Saída: 250.00
 */
public class BalancoFinanceiro {

    public static void main(String[] args) {
        Transacao t1 = new Transacao(BigDecimal.valueOf(100), CREDITO);
        Transacao t2 = new Transacao(BigDecimal.valueOf(50), DEBITO);
        Transacao t3 = new Transacao(BigDecimal.valueOf(200), CREDITO);

        BigDecimal soma = Stream.of(t1, t2, t3)
                .map(Transacao::valorTransacional)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(soma);
    }

    record Transacao(BigDecimal valor, TipoDeTransacao tipoDeTransacao){

        BigDecimal valorTransacional() {
            if (tipoDeTransacao() == DEBITO) {
                return valor().negate();
            }

            return valor();
        }
    }

    enum TipoDeTransacao {
        DEBITO, CREDITO
    }
}
