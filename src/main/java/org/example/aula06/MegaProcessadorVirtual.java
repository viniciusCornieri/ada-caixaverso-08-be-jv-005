package org.example.aula06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MegaProcessadorVirtual {

    public static void main(String[] args) {
        AtomicInteger valor = new AtomicInteger();

        Runnable increment = () -> {
            int i = valor.incrementAndGet();
            if (i % 100_000 == 0) {
                System.out.println("Processou %s".formatted(i));
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            Thread processo = Thread.ofVirtual()
                    .name("chamada-de-api")
                    .start(increment);
            threads.add(processo);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(valor.get());
    }

    public static class NonAtomicInteger {

        private int valor = 0;

        public int incrementAndGet() {
            return valor++;
        }

        public int get() {
            return valor;
        }

    }
}
