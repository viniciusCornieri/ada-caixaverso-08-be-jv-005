package org.example.aula02;

import java.time.*;

/**
 * -> Para o nosso sistema de negociação de ETFs,
 * precisamos identificar a data e o horário atual exatos
 * de onde estão localizadas as principais bolsas de valores do mundo.
 * Capture o momento atual do sistema e imprima no console a data
 * e a hora correspondentes a cada um dos seguintes fusos horários:
 *
 * Exemplo
 *
 * Bolsa de Nova York (EUA): 2026-03-07T20:04:58.685116772-05:00[America/New_York]
 * Bolsa de Londres (Inglaterra):
 * 2026-03-07T20:04:58.685116772Z[Europe/London]
 * Bolsa de Tóquio (Japão):
 * 2026-03-07T20:04:58.685116772+09:00[Asia/Tokyo]
 * Bolsa B3 em São Paulo (Brasil):
 * 2026-03-07T20:04:58.685116772-03:00[America/Sao_Paulo]
 */
public class RelogioMundial {

    public static void main(String[] args) {
//        System.out.println(OffsetDateTime.now());
//        System.out.println(ZonedDateTime.now());
        ZoneId zonaAmericaSP = ZoneId.of("America/Sao_Paulo");
        LocalDateTime agora = LocalDateTime.now();
        Instant agoraInstant = Instant.now();

        ZonedDateTime agoraBrasil = agora.atZone(zonaAmericaSP);
//        ZonedDateTime agoraNovaYork = ZonedDateTime.now(ZoneId.of("America/New_York"));
//        ZonedDateTime agoraLondres = ZonedDateTime.now(ZoneId.of("Europe/London"));
//        ZonedDateTime agoraTokio = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

//        ZonedDateTime agoraNovaYork = agoraBrasil.withZoneSameInstant(ZoneId.of("America/New_York"));
//        ZonedDateTime agoraLondres = agoraBrasil.withZoneSameInstant(ZoneId.of("Europe/London"));
//        ZonedDateTime agoraTokio = agoraBrasil.withZoneSameInstant(ZoneId.of("Asia/Tokyo"));

        ZonedDateTime agoraNovaYork = agoraInstant.atZone(ZoneId.of("America/New_York"));
        ZonedDateTime agoraLondres = agoraInstant.atZone(ZoneId.of("Europe/London"));
        ZonedDateTime agoraTokio = agoraInstant.atZone(ZoneId.of("Asia/Tokyo"));
        System.out.println(agoraTokio.toInstant().toEpochMilli());
        System.out.println("Bolsa de Nova York (EUA):       " + agoraNovaYork);
        System.out.println("Bolsa de Londres (Inglaterra):  " + agoraLondres);
        System.out.println("Bolsa de Tóquio (Japão):        " + agoraTokio);
        System.out.println("Bolsa B3 em São Paulo (Brasil): " + agoraBrasil);

        System.out.println(OffsetDateTime.now(ZoneOffset.UTC));
    }
}
