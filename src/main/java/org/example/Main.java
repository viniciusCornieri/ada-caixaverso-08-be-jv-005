package org.example;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    static void main() {

        System.out.println(new Date());
        System.out.println(new Date(2026, 3, 5));
        System.out.println(new Date(2026, 0, 1));
        System.out.println(LocalDate.now());
        System.out.println(LocalDate.of(2026, 3, 5));
        System.out.println(LocalDate.of(2026, 1, 1));
    }
}
