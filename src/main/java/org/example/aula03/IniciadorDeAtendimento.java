package org.example.aula03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * -> Vamos iniciar criando um método para iniciar atendimento
 * que recebe como parâmetro um produtor de protocolo
 * ele não receberá nenhum parâmetro retornará a String de um novo protocolo.
 * Esse primeiro gerador de protocolo produzirá protocolos seguindo a seguinte regra:
 *
 *
 * Inicia com PROT-
 * Seguido da data e hora atual sem traços
 * Exemplo: Atendimento iniciado dia 10/03/2026 às 20:00:10 seria 20260310200010-
 * Seguido de um número inteiro aleatório de 0 a 9999.
 *
 * Exemplo:
 *
 * Iniciando atendimento com o protocolo PROT-20260310200010-775
 */
public class IniciadorDeAtendimento {

    public static void main(String[] args) {
        IniciadorDeAtendimento iniciadorDeAtendimento = new IniciadorDeAtendimento();

//        Supplier<String> protocoloSupplier = () -> {
//            LocalDateTime now = LocalDateTime.now();
//            //10/03/2026 às 20:00:10 - 20260310200010
//            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
//            String dataFormatada = now.format(formatador);
//            Random randomizador = new Random();
//            int numeroAleatorio = randomizador.nextInt(0, 10000);
////            String protocolo = String.format("PROT-%s-%d", dataFormatada, numeroAleatorio);
//            return "PROT-%s-%04d".formatted(dataFormatada, numeroAleatorio);
//        };

        Supplier<String> protocoloSupplier = GeradorDeProtocoloDiario::gerar;
//        Consumer<String> impressor = (entrada) -> System.out.println(entrada);
        Consumer<String> impressor = System.out::println;

        iniciadorDeAtendimento.atender(System.out::println, protocoloSupplier);
        iniciadorDeAtendimento.atender(System.out::println, protocoloSupplier);
        iniciadorDeAtendimento.atender(System.out::println, protocoloSupplier);
        iniciadorDeAtendimento.atender(impressor, GeradorDeProtocoloDiario::gerar);
        iniciadorDeAtendimento.atender(impressor, GeradorDeProtocoloDiario::gerar);
        iniciadorDeAtendimento.atender(impressor, GeradorDeProtocoloDiario::gerar);
    }

    public void atender(Consumer<String> impressor, Supplier<String> geradorDeProtocolo) {
        String protocolo = geradorDeProtocolo.get();
        impressor.accept("Iniciando atendimento com o protocolo " + protocolo);
    }
}
