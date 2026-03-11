package org.example.aula02;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Agora vamos ajustar para um outro formato
 * o exercício anterior que imprima os dias corridos
 * que faltam até a data destino.
 *
 * Exemplo
 *
 * Qual a data destino no formato (dd/MM/yyyy):
 * 01/01/2027
 * Faltam 297 dias para o dia 01/01/2027
 */
public class ContagemRegressivaDiasCorridos {

    static void main() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Qual a data destino no formato (dd/MM/yyyy):");
        var dataInformada = leitor.nextLine();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate dataFutura = LocalDate.parse(dataInformada, formatter);
        long diasFaltantes = ChronoUnit.HOURS.between(LocalDateTime.now(), dataFutura.atTime(0, 0));
        String resposta = "Faltam %s dias para o dia %s"
                .formatted(diasFaltantes, dataFutura.format(formatter));
        System.out.println(resposta);

    }
}
