package org.example.aula07;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationTest {

    public static void main(String[] args) {

        Duration duration = Duration.of(1_000_000, ChronoUnit.SECONDS);
        System.out.println(duration.toHours());
    }
}
