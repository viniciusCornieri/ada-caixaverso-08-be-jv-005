package org.example.aula03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

public class GeradorDeProtocoloUUID {

    public String gerar() {
        return UUID.randomUUID().toString();
    }
}
