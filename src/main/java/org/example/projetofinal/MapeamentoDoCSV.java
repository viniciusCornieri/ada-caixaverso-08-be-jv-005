package org.example.projetofinal;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Stream;

public class MapeamentoDoCSV {

    public static void main(String[] args) {
        Stream.of(
        "TX000001,AC00128,14.09,2023-04-11 16:29:14,Debit,San Diego,D000380,162.198.218.92,M015,ATM,70,Doctor,81,1,5112.21,2024-11-04 08:08:08",
        "TX000002,AC00455,376.24,2023-06-27 16:44:19,Debit,Houston,D000051,13.149.61.4,M052,ATM,68,Doctor,141,5,13758.91,2024-11-04 08:09:35",
        "TX000003,AC00019,126.29,2023-07-10 18:16:08,Debit,Mesa,D000235,215.97.143.157,M009,Online,19,Student,56,1,1122.35,2024-11-04 08:07:04",
        "TX000004,AC00070,184.50,2023-05-07 16:32:11,Debit,Raleigh,D000187,200.13.225.150,M002,Online,26,Student,25,1,8569.06,2024-11-04 08:09:06",
        "TX000005,AC00411,13.45,2023-10-16 17:51:24,Credit,Atlanta,D000308,65.164.3.100,M091,Online,26,Student,198,1,7429.40,2024-11-04 08:06:39"
        ).map(Transaction::fromCSV)
        .forEach(System.out::println);

        Transaction t1 = Transaction.builder()
                .transactionId("TX001")
                .accountId("AC001")
                .amount(BigDecimal.TEN)
                .type(TransactionType.Credit)
                .timestamp(LocalDateTime.now())
                .channel(Channel.ATM)
                .occupation("Student")
                .loginAttempts(1)
                .balance(BigDecimal.TWO)
                .build();

    }


}
