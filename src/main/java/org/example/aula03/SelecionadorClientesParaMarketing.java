package org.example.aula03;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * ->  O time de marketing nos passou uma lista de clientes
 * que devemos selecionar removendo da lista todos os
 * que fizeram uma compra recente nos últimos 90 dias,
 * para iniciarmos uma campanha para os que fazem tempo que não compram.
 * Dica: utilize o método removeIf da lista.
 * Exemplo:
 *
 * Clientes:
 * Cliente[nome: Teste1, dataUltimaCompra: 2025-03-05]
 * Cliente[nome: Teste2, dataUltimaCompra: 2026-03-08]
 * Cliente[nome: Teste3, dataUltimaCompra: 2025-11-15]
 * Cliente[nome: Teste4, dataUltimaCompra: 2026-02-22]
 * Cliente[nome: Teste5, dataUltimaCompra: 2025-10-19]
 *
 * Clientes selecionados:
 * Teste1
 * Teste3
 * Teste5
 */
public class SelecionadorClientesParaMarketing {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Teste1", LocalDate.parse("2025-03-05"));
        Cliente c2 = new Cliente("Teste2", LocalDate.parse("2026-03-08"));
        Cliente c3 = new Cliente("Teste3", LocalDate.parse("2025-11-15"));
        Cliente c4 = new Cliente("Teste4", LocalDate.parse("2026-02-22"));
        Cliente c5 = new Cliente("Teste5", LocalDate.parse("2025-10-19"));
        List<Cliente> clientes = new ArrayList<>(List.of(c1, c2, c3, c4, c5));

        clientes.removeIf((cliente) -> cliente.diasDesdeAUltimaCompra() < 90);
        clientes.forEach(System.out::println);
        System.out.println("================");

//        clientes.sort((primeiroCliente, segundoCliente) -> primeiroCliente.ultimaCompra().compareTo(segundoCliente.ultimaCompra()));
//        clientes.sort((primeiroCliente, segundoCliente) -> segundoCliente.ultimaCompra().compareTo(primeiroCliente.ultimaCompra()));
        clientes.sort(Comparator.comparing(Cliente::ultimaCompra).reversed());
        clientes.forEach(System.out::println);



//        clientes.sort();
//        List<Cliente> listaFiltrada = new ArrayList<>();

//        for (Cliente cliente: clientes) {
//            long diasDesdeAUltimaCompra = ChronoUnit.DAYS.between(cliente.ultimaCompra(), LocalDate.now());
//            if (diasDesdeAUltimaCompra > 90) {
//                listaFiltrada.add(cliente);
//            }
//        }


//        for (Cliente cliente: listaFiltrada) {
//            System.out.println(cliente);
//        }


    }

    public record Cliente(String nome, LocalDate ultimaCompra) {

        public long diasDesdeAUltimaCompra() {
            return ChronoUnit.DAYS.between(this.ultimaCompra(), LocalDate.now());
        }
    }
}
