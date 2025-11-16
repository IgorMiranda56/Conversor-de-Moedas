package com.conversor.controller;

import com.conversor.service.ExchangeService;

import java.util.Scanner;

public class MenuController {

    private final ExchangeService service = new ExchangeService();
    private final Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcao;

        do {
            System.out.println("\n=== CONVERSOR DE MOEDAS ===");
            System.out.println("1 - USD para BRL");
            System.out.println("2 - BRL para USD");
            System.out.println("3 - EUR para BRL");
            System.out.println("4 - BRL para EUR");
            System.out.println("5 - USD para EUR");
            System.out.println("6 - EUR para USD");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();

            if (opcao != 0) {
                System.out.print("Valor: ");
                double valor = scanner.nextDouble();
                realizarConversao(opcao, valor);
            }

        } while (opcao != 0);

        System.out.println("Finalizando...");
    }

    private void realizarConversao(int opcao, double valor) {
        String from = "";
        String to = "";

        switch (opcao) {
            case 1 -> { from = "USD"; to = "BRL"; }
            case 2 -> { from = "BRL"; to = "USD"; }
            case 3 -> { from = "EUR"; to = "BRL"; }
            case 4 -> { from = "BRL"; to = "EUR"; }
            case 5 -> { from = "USD"; to = "EUR"; }
            case 6 -> { from = "EUR"; to = "USD"; }
            default -> {
                System.out.println("Opção inválida.");
                return;
            }
        }

        double convertido = service.converter(valor, from, to);

        if (convertido != -1) {
            System.out.printf("\n%.2f %s = %.2f %s\n\n", valor, from, convertido, to);
        }
    }
}
