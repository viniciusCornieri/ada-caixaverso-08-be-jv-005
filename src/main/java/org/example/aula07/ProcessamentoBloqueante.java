package org.example.aula07;

import lombok.SneakyThrows;

import java.time.Duration;
import java.time.Instant;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProcessamentoBloqueante {

    public static void main(String[] args) {
        Instant inicio = Instant.now();
        ConsultaCPF consultaCPF = new ConsultaCPF();
        ConsultaCambio consultaCambio = new ConsultaCambio();

        try (ExecutorService executorService = Executors.newFixedThreadPool(1)) {
            Future<String> cpfConsultado = executorService.submit(() -> consultaCPF.consultar(UUID.randomUUID()));
            Future<String> cambioConsultado = executorService.submit(() -> consultaCambio.consultar("Reais"));
            String cpf = cpfConsultado.get();
            System.out.println("Apos retorno do CPF");
            String cambio = cambioConsultado.get();
            System.out.println("Cambio: %s, cpf: %s".formatted(cambio, cpf));
            System.out.println("Consultas realizadas em %sms".formatted(Duration.between(inicio, Instant.now()).toMillis()));
        } catch (Exception e) {
            System.out.println("Falha no processamento do CPF");
        }

    }


    public static class ConsultaCPF {

        @SneakyThrows
        public String consultar(UUID usuario) {
            System.out.println("Consultando CPF ...");
            Thread.sleep(5000L);
            System.out.println("CPF consultado ...");
            return "CPF do usuário";
        }
    }

    public static class ConsultaCambio {

        @SneakyThrows
        public String consultar(String moeda) {
            System.out.println("Consultando taxa de Câmbio ...");
            Thread.sleep(1000L);
            System.out.println("Cambio consultado ...");

            return "Moeda com cambio X";
        }
    }
}
