package org.example.projetofinal;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record Transaction(String transactionId,
                          String accountId,
                          BigDecimal amount,
                          LocalDateTime timestamp,
                          TransactionType type,
                          Channel channel,
                          String occupation,
                          int loginAttempts,
                          BigDecimal balance) {

    public static Transaction fromCSV(String row) {
        String[] campos = row.split(",");

        return Transaction.builder()
                .transactionId(campos[0])
                .accountId(campos[1])
                .amount(new BigDecimal(campos[2]))
//                .timestamp(LocalDateTime.parse(campos[3], DateTimeFormatter.ofPattern("...")))
                .timestamp(LocalDateTime.now())
                .type(TransactionType.valueOf(campos[4]))
                .channel(Channel.valueOf(campos[9]))
                .occupation(campos[11])
                .loginAttempts(Integer.parseInt(campos[13]))
                .balance(new BigDecimal(campos[14]))
                .build();
    }

}
