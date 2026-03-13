package org.example.aula03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;
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

        Supplier<String> protocoloSupplier = GeradorDeProtocoloDiario::gerar;

        iniciadorDeAtendimento.atender(protocoloSupplier);
        iniciadorDeAtendimento.atender(protocoloSupplier);
        iniciadorDeAtendimento.atender(() -> GeradorDeProtocoloDiario.gerar());
        iniciadorDeAtendimento.atender(GeradorDeProtocoloDiario::gerar);
        iniciadorDeAtendimento.atender(GeradorDeProtocoloDiario::gerar);

        GeradorDeProtocoloUUID geradorUUID = new GeradorDeProtocoloUUID();
        iniciadorDeAtendimento.atender(geradorUUID::gerar);
        iniciadorDeAtendimento.atender(geradorUUID::gerar);
        iniciadorDeAtendimento.atender(geradorUUID::gerar);
        iniciadorDeAtendimento.atender(geradorUUID::gerar);
        iniciadorDeAtendimento.atender(() -> UUID.randomUUID().toString());
        iniciadorDeAtendimento.atender(UUID.randomUUID()::toString);
        iniciadorDeAtendimento.atender(UUID.randomUUID()::toString);
        iniciadorDeAtendimento.atender(UUID.randomUUID()::toString);
        iniciadorDeAtendimento.atender(UUID.randomUUID()::toString);
    }

    public void atender(Supplier<String> geradorDeProtocolo) {
        String protocolo = geradorDeProtocolo.get();
        System.out.println("Iniciando atendimento com o protocolo " + protocolo);
    }
}
