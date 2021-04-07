package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MastermindGame {
    SecretCode code;
    Scanner scanner = new Scanner(System.in);

    public void newGame() {
        this.code = new SecretCode();
//        System.out.println(code);
    }


    private boolean inValidCheck(char[] tryCode) {
        boolean invalid = false;

        if (tryCode.length > 4) {
            return true;
        }

        for (int num : tryCode) {
            if (num < 97 || num > 103) {
                invalid = true;
                break;
            }
        }
        return invalid;
    }

    private boolean winner(char[] tryCode) {
        return Arrays.equals(code.getCode(), tryCode);
    }

    public void playGame() {
        System.out.println("Probeer de code te kraken! Keuze uit a, b, c, d, e, f.");

        while (true) {
            System.out.println("Voer code van 4 letters in:");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Spel is gestopt! ");
                break;
            }

            char[] playerCode = input.toCharArray();

            if (inValidCheck(playerCode)) {
                System.out.println("Dit is een ongeldige invoer in. Probeer opnieuw.");
                continue;
            }

            System.out.println(Arrays.toString(playerCode));

            if (winner(playerCode)) {
                System.out.println("Je hebt de code gekraakt! Je hebt gewonnen.");
                break;
            }
        }
    }
}
