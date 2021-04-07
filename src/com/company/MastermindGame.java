package com.company;

import java.lang.reflect.Array;
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

    private void codeChecker(char[] tryCode) {
        char[] correctCode = code.getCode();
        int rightPlace = 0;
        int wrongPlace = 0;

        for (int i = 0; i < tryCode.length; i++) {
            if (correctCode[i] == tryCode[i]) {
                rightPlace++;
            } else if (new String(correctCode).indexOf(tryCode[i]) != -1) {
                wrongPlace++;
            }
        }

        if (rightPlace != 0) {
            System.out.println("Het aantal correcte letters op de juiste plaats -> " + rightPlace);
        }

        if (wrongPlace != 0) {
            System.out.println("Het aantal correcte letters niet op de juiste plaats ->  " + wrongPlace);
        }
    }

    private boolean winner(char[] tryCode) {
        return Arrays.equals(code.getCode(), tryCode);
    }

    public void playGame() {
        System.out.println("Probeer de code te kraken! Keuze uit a, b, c, d, e, f.");

        while (true) {
            System.out.println("Voer code van 4 letters zonder spaties in:");
            String input = scanner.nextLine();

            if (input.equals("q")) {
                System.out.println("Spel is gestopt!");
                System.out.println("De code was " + Arrays.toString(code.getCode()));
                break;
            }

            if (input.isEmpty()){
                System.out.println("Vul iets in... Of voer q in om te stoppen.");
            }
            char[] playerCode = input.toCharArray();

            if (inValidCheck(playerCode)) {
                System.out.println("Dit is een ongeldige invoer in. Probeer opnieuw.");
                continue;
            }

            System.out.println(Arrays.toString(playerCode));

            codeChecker(playerCode);
            if (winner(playerCode)) {
                System.out.println("Je hebt de code gekraakt! Je hebt gewonnen.");
                break;
            }
        }
    }
}
