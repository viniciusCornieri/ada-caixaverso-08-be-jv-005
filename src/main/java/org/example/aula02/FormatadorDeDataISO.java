package org.example.aula02;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * A ISO-8601 e RFC-3339 definem uma convenção de formatação
 * para datas muito utilizada em sistemas.
 * Crie um programa que imprima a data atual nesse formato
 *
 * 2026-03-10T19:20:30.123456789
 */
public class FormatadorDeDataISO {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        var formatador = DateTimeFormatter.ofPattern("EEEE");
        System.out.println(now.format(formatador));

    }
}
