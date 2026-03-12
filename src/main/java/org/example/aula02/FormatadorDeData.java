package org.example.aula02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Por padrão as datas estavam sendo impressas assim 2026-03-25,
 * porém no Brasil somos mais acostumados a visualizar datas no formato
 * 25/03/2026, vamos implementar essa visualização.
 */
public class FormatadorDeData {

    public static void main(String[] args) {

        LocalDate data = LocalDate.of(2026, 03, 15);
        System.out.println(data);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = data.format(formatter);
        System.out.println(dataFormatada);


    }
}
