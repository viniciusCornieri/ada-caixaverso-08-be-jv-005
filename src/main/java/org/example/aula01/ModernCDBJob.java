package org.example.aula01;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class ModernCDBJob {

    public static void main(String[] args) {
        ModernCDB cdb1 = new ModernCDB("CDB 1", LocalDate.now(), BigDecimal.ONE, 30);
        ModernCDB cdb2 = new ModernCDB("CDB 2", LocalDate.now(), BigDecimal.ONE, 15);
        ModernCDB cdb3 = new ModernCDB("CDB 3", LocalDate.now(), BigDecimal.TEN, 45);
        List<ModernCDB> listaCdbs = List.of(cdb1, cdb2, cdb3);

        for (ModernCDB cdb : listaCdbs) {
            System.out.println(cdb);
        }

        LocalDate agora = LocalDate.now();
        LocalDate dataAtualizada = agora;
        for (int i = 1; i <= 46; i++) {
            dataAtualizada = dataAtualizada.plusDays(1);
            System.out.println("DataAtual: " + dataAtualizada);
            for (ModernCDB cdb: listaCdbs) {
                if (cdb.estaAtivo() && cdb.estaEncerrado(dataAtualizada)) {
                    System.out.println(cdb + " Esta encerrado");
                    cdb.fecharCdb();
                }
            }
        }
    }
}
