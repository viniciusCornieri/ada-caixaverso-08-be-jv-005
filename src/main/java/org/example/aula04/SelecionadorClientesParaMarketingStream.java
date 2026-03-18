package org.example.aula04;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Na aula passada, utilizamos o método `removeIf` para modificar uma lista existente.
 * Agora, utilizando a API de **Streams**, receba uma lista de clientes e filtre apenas os que realizaram sua
 * **última compra a mais de 90 dias**, gerando uma nova lista de resultados.
 *
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
public class SelecionadorClientesParaMarketingStream {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("Teste1", LocalDate.parse("2025-03-05"));
        Cliente c2 = new Cliente("Teste2", LocalDate.parse("2026-03-08"));
        Cliente c3 = new Cliente("Teste3", LocalDate.parse("2025-11-15"));
        Cliente c4 = new Cliente("Teste4", LocalDate.parse("2026-02-22"));
        Cliente c5 = new Cliente("Teste5", LocalDate.parse("2025-10-19"));
        List<Cliente> clientes = new ArrayList<>(List.of(c1, c2, c3, c4, c5));
        System.out.println("================");
        List<String> clientesFiltrados =
                clientes.stream()
                    .filter(c -> c.diasDesdeAUltimaCompra() > 90)
                    .sorted(Comparator.comparing(Cliente::ultimaCompra))
                    .map(cliente -> cliente.nome())
                    .toList();
        clientesFiltrados.forEach(System.out::println);


    }

    public record Cliente(String nome, LocalDate ultimaCompra) {

        public long diasDesdeAUltimaCompra() {
            return ChronoUnit.DAYS.between(this.ultimaCompra(), LocalDate.now());
        }
    }
}
