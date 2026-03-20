package org.example.aula05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * -> Grave uma lista de Strings
 * (`"ACESSO: Ana"`, `"ERRO: AC001"`, `"TRANS: TX001"`, `"ERRO: AC005"`)
 * em um arquivo chamado `auditoria.txt`.
 */
public class GravadorDeLogs {

    public static void main(String[] args) {
        List<String> logs = List.of("ACESSO: Ana", "ERRO: AC001", "TRANS: TX001", "ERRO: AC005");

        try {
            Files.write(Path.of("auditoria.txt"), logs);
            System.out.println("Arquivo escrito com sucesso");
        } catch (IOException e) {
            System.out.println("Falha na hora de escrever o arquivo. " + e.getMessage());
        }
    }
}
