package org.example.aula02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * A ISO-8601 é o padrão universal,
 * mas no mundo real frequentemente recebemos datas de outros sistemas,
 * planilhas de Excel ou arquivos CSVs como texto puro.
 * Crie um programa que leia essa String e a converta para um objeto LocalDate.
 *
 * Exemplo
 *
 * Informe a sua data:
 * 01/01/2026
 * Data informada: 2026-01-01
 */
public class LeitorDeDatas {

    public static void main(String [] args) {

        Scanner leitor = new Scanner(System.in);
        System.out.println("Informe a sua data no formato (dd/MM/yyyy):");
        var dataInformada = leitor.nextLine();
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate data = LocalDate.parse(dataInformada, formatter);
        System.out.println(data.plusDays(10).format(formatter));

    }
}
