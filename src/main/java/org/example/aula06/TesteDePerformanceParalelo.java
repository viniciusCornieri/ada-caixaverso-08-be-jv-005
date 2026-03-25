package org.example.aula06;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TesteDePerformanceParalelo {

    public static void main(String[] args) {
        Instant agora = Instant.now();
        BigDecimal somaSequencial = IntStream.range(0, 10_000_000)
                .mapToObj(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Tempo sequencial: " + Duration.between(agora, Instant.now()).toMillis());

        agora = Instant.now();
        BigDecimal somaParalela = IntStream.range(0, 10_000_000)
                .parallel()
                .mapToObj(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("Tempo paralelo: " + Duration.between(agora, Instant.now()).toMillis());



    }

}
