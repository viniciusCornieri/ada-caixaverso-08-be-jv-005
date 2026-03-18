package org.example.aula04;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

/**
 * Crie um programa que receba uma lista de saldos de contas (`BigDecimal`)
 * e utilize a API de Streams para realizar as seguintes verificações:
 * 1. Verifique se todas as contas na lista possuem saldo positivo.
 * 2. Verifique se existe pelo menos uma conta na lista
 * com saldo superior a R$ 10.000,00.
 *
 *
 * Exemplo:
 *
 * Entrada: [100.00, -50.00, 20000.00]
 * Saída:
 * Todas positivas? false
 * Alguma VIP (>10k)? true
 */
public class ValidacaoDeSaldos {

    public static void main(String[] args) {
        List<BigDecimal> valores =
                Stream.of(100.00, -50.00, 20000.00)
                .map(BigDecimal::valueOf)
                .toList();

        boolean todasPositivas =
                valores.stream()
                .allMatch((valor -> valor.compareTo(BigDecimal.ZERO) >= 0));

        boolean algumaVip =
                valores.stream()
                    .anyMatch((valor -> valor.compareTo(BigDecimal.valueOf(10_000)) >= 0));

        System.out.println("Todas positivas? " + todasPositivas);
        System.out.println("Alguma VIP (>10k)? " + algumaVip);
    }
}
