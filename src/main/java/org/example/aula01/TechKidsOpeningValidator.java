package org.example.aula01;

import java.time.*;

public class TechKidsOpeningValidator {

    public static void main(String[] args) throws InterruptedException {
        var validator = new TechKidsOpeningValidator();
        var dataDeNascimento = LocalDate.of(2008, Month.DECEMBER, 15);
        boolean podeCriarConta = validator.menorDe18anos(dataDeNascimento, LocalDate.now());

        var now =  LocalDateTime.now();
        Thread.sleep(1000l);
        var depois =  LocalDateTime.now();
        Duration duration = Duration.between(now, depois);
        System.out.println("Tempo de depois: " + duration);
        System.out.println("Tempo de depois: " + duration.toSeconds());
        if (podeCriarConta) {
            System.out.println("Criando Conta");
        } else {
            System.out.println("Não pode criar a conta");
        }
    }

    public boolean menorDe18anos(LocalDate dataNascimento, LocalDate dataAtual) {
        Period idadePeriod = Period.between(dataNascimento, dataAtual);
        System.out.println("idadePeriod: " + idadePeriod);
        int idade = idadePeriod.getYears();
        System.out.println("Idade calculada: " + idade + " anos");
        return idade < 18;
    }
}
