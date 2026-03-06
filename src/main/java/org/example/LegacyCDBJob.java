package org.example;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class LegacyCDBJob {

    void main() {
        LegacyCDB cdb1 = new LegacyCDB("CDB 1", new Date(), BigDecimal.ONE, 30);
        LegacyCDB cdb2 = new LegacyCDB("CDB 2", new Date(), BigDecimal.ONE, 15);
        LegacyCDB cdb3 = new LegacyCDB("CDB 3", new Date(), BigDecimal.TEN, 45);
        List<LegacyCDB> listaCdbs = List.of(cdb1, cdb2, cdb3);

        for (LegacyCDB cdb : listaCdbs) {
            System.out.println(cdb);
        }

        Date dataAtual = new Date();
        int umDiaEmHoras = 1 * 24;
        int umDiaEmMinutos = umDiaEmHoras * 60;
        int umDiaEmSegundos = umDiaEmMinutos * 60;
        int umDiaEmMillisegundos = umDiaEmSegundos * 1000;
        for (int i = 1; i <= 46; i++) {
            dataAtual.setTime(dataAtual.getTime() + umDiaEmMillisegundos);
            System.out.println(dataAtual);
            for (LegacyCDB cdb: listaCdbs) {
                if (cdb.estaAtivo() && cdb.estaEncerrado(dataAtual)) {
                    System.out.println(cdb + " Esta encerrado");
                    cdb.fecharCdb();
                }
            }
        }
    }
}
