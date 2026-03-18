package org.example.aula04;


import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 *  Receba uma lista de valores (`BigDecimal`)
 *  e utilize Streams para selecionar apenas as transações
 *  acima de R$ 500,00, imprimindo cada uma delas no console.
 *
 * Exemplo:
 *
 * Entrada: [100.00, 600.00, 450.00, 1200.00]
 * Saída:
 * 600.00
 * 1200.00
 */
public class FiltroDeTransacoes {

    public static void main(String[] args) {

        final BigDecimal quinhentos = BigDecimal.valueOf(500);

        Stream.of(100.00, 600.00, 450.00, 1200.00)
                .map(BigDecimal::valueOf)
                .map(Transacao::new)
                .filter(t -> t.valor().compareTo(quinhentos) > 0)
                .forEach(System.out::println);
    }

    record Transacao(BigDecimal valor){}
}
