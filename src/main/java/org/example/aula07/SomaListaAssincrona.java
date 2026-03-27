package org.example.aula07;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SomaListaAssincrona {

    public static void main(String[] args) {
        int tamanho = 1_000_001;
        List<Integer> lista = new Random()
                .ints(tamanho, 1, 100)
                .boxed()
                .toList();

        int quantidadeDeThreads = 11;
        List<List<Integer>> partes = new ArrayList<>();

        int indiceInicial = 0;
        Double incremento = Math.ceil((double) lista.size() / quantidadeDeThreads);
        for (int i = 0; i < quantidadeDeThreads; i++) {
            int indiceFinal = indiceInicial + incremento.intValue();
            if (indiceFinal > tamanho) {
                indiceFinal = tamanho;
            }
            List<Integer> parte = lista.subList(indiceInicial, indiceFinal);
            partes.add(parte);
            indiceInicial = indiceFinal;
        }

        for (int i = 0; i < quantidadeDeThreads; i++) {
            System.out.println("part%s tamanho %s".formatted(i+1, partes.get(i).size()));
        }

        try (ExecutorService executorService = Executors.newFixedThreadPool(quantidadeDeThreads)) {
            List<Future<BigDecimal>> futures = new ArrayList<>();
            for (List<Integer> parte: partes) {
                Future<BigDecimal> somaParte = executorService.submit(() -> parte.stream().map(BigDecimal::valueOf).reduce(BigDecimal.ZERO, BigDecimal::add));
                futures.add(somaParte);
            }

            List<BigDecimal> somas = futures.stream().map(SomaListaAssincrona::safeGet).toList();

            for (int i = 0; i < quantidadeDeThreads; i++) {
                System.out.println("Soma parte %s: %s".formatted(i+1, somas.get(i)));
            }
            System.out.println("Total: " + somas.stream().reduce(BigDecimal.ZERO, BigDecimal::add));
        } catch (Exception ex) {
            System.out.println("Falha ao tentar somar os numeros");
        }

    }

    public static BigDecimal safeGet(Future<BigDecimal> bigDecimalFuture) {
        try {
            return bigDecimalFuture.get();
        } catch (Exception ex) {
            throw new RuntimeException("Falha ao buscar a soma", ex);
        }
    }
}
