package org.example.aula03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class GeradorDeProtocoloDiario {

    public static String gerar() {
        LocalDateTime now = LocalDateTime.now();
        //10/03/2026 às 20:00:10 - 20260310200010
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String dataFormatada = now.format(formatador);
        Random randomizador = new Random();
        int numeroAleatorio = randomizador.nextInt(0, 10000);
//            String protocolo = String.format("PROT-%s-%d", dataFormatada, numeroAleatorio);
        return "PROT-%s-%04d".formatted(dataFormatada, numeroAleatorio);
    }
}
