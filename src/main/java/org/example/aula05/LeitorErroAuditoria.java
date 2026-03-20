package org.example.aula05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * -> Abra o arquivo `auditoria.txt` gerado anteriormente e exiba no console
 * apenas as linhas que começam com o código `ERRO`.
 *
 * **Exemplo**
 * Saída:
 * ERRO: AC001
 * ERRO: AC005
 */
public class LeitorErroAuditoria {

    public static void main(String[] args) {

        // try-with-resources
        try (BufferedReader reader = Files.newBufferedReader(Path.of("auditoria.txt"))) {
            reader.lines()
                    .filter(linha -> linha.contains("ERRO"))
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
