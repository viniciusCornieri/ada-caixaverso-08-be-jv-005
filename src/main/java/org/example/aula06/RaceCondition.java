package org.example.aula06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RaceCondition {

    public static void main(String[] args) {
        List<Integer> toListResult = IntStream.range(0, 1_000_000)
                .parallel()
                .boxed()
                .toList();
        System.out.println(toListResult.size());

        List<Integer> lista = Collections.synchronizedList(new ArrayList<>());
        IntStream.range(0, 1_000_000)
                .parallel()
                .forEach(lista::add);

        System.out.println(lista.size());
    }

}
