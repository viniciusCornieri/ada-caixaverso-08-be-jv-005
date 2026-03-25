package org.example.aula06;

import java.util.ArrayList;
import java.util.List;

public class SimularChamadaAPI {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i <= 100_000; i++) {
            Thread processo = Thread.ofVirtual()
                                    .name("chamada-de-api")
                                    .start(new InvocadorDeApi(i));
            threads.add(processo);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public record InvocadorDeApi(int id) implements Runnable {

        public void run() {
            System.out.println("Chamada %s".formatted(id));
            chamadaDeAPI();
            System.out.println("Encerrada %s".formatted(id));

        }

        private static void chamadaDeAPI() {
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


}
