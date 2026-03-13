package org.example.aula03;

import java.math.BigDecimal;

public class BigDecimalExemplos {

    public static void main(String[] args) {
        BigDecimal um = BigDecimal.ONE;
        BigDecimal dois = BigDecimal.valueOf(2);

        System.out.println("um.compareTo(dois):" + um.compareTo(dois));
        System.out.println("dois.compareTo(um):" + dois.compareTo(um));
        BigDecimal outroUm = new BigDecimal("1.00");
        System.out.println("um.compareTo(um):" + um.compareTo(outroUm));
        System.out.println("um.equals(outroUm):" + um.equals(outroUm));
        System.out.println("(um.compareTo(outroUm) == 0):" + (um.compareTo(outroUm) == 0));

    }
}
