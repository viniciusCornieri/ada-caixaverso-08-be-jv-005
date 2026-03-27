package org.example.aula07;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ComparadorCambioCadeia {

    public static void main(String[] args) {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            CompletableFuture<Double> dolar = CompletableFuture.supplyAsync(ComparadorCambioCadeia::consultaValorMoeda, executorService);
            CompletableFuture<Double> euro = CompletableFuture.supplyAsync(ComparadorCambioCadeia::consultaValorMoeda, executorService);
            try {
                dolar.thenCombine(euro, ComparadorCambioCadeia::processarMoedas)
                        .thenApply(String::toUpperCase)
                        .thenAccept(System.out::println);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static String processarMoedas(double dolar, double euro) {
        System.out.printf("Dolar: %.2f | Euro: %.2f%n",dolar, euro);
        if (euro == dolar) {
            return "Ambas as moedas tem o mesmo valor.";
        }

        String maisCaro = "";
        if (euro > dolar) {
            maisCaro = "euro";
        } else {
            maisCaro = "dolar";
        }
        return "A moeda %s está mais caro".formatted(maisCaro);
    }


    public static Double consultaValorMoeda() {
        Random random = new Random();
        Long tempoDeChamada = random.nextLong(3, 10);
        System.out.println("Efetuando chamada para consultar valor da Moeda");
        try {
            Thread.sleep(tempoDeChamada* 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Chamada feita com sucesso");
        return random.nextDouble(5.00, 6.50);
    }
}
