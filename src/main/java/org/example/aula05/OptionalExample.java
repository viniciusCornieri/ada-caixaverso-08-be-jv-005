package org.example.aula05;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OptionalExample {

    public static void main(String[] args) {
        String a = null;

        System.out.println(a);
        if (a != null) {
            System.out.println(a.toUpperCase());
        }
        Optional<String> optA = Optional.ofNullable(a);
        Optional<String> upperCase = optA.map(String::toUpperCase);
        Optional<String> optEmpty = Optional.empty();

        System.out.println(optA);
        System.out.println(upperCase);
        System.out.println(optEmpty);

        String resultado = upperCase.orElse("Não tem registro");
        System.out.println(resultado);

//        if (upperCase.isPresent()) {
//        String foraDoOptional = upperCase.get();
//        System.out.println(foraDoOptional);
//        }

//
//        if (upperCase.isEmpty()) {
//            System.out.println("Não tem registro");
//        }
         System.out.println("=========================");
         upperCase.ifPresent(System.out::println);

//         String linha = Stream.of("a", "b", "c")
//                 .peek(System.out::println)
//                 .collect(Collectors.joining(","));
        String linha = String.join(",", List.of("a", "b", "c"));
        System.out.println(linha);

    }
}
