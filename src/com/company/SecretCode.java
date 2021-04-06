package com.company;

import java.util.Arrays;
import java.util.Random;

public class SecretCode {
    private final char[] letters = {'a', 'b', 'c', 'd', 'e', 'f'};
    private final Random random = new Random();
    private char[] code = new char[4];

    public SecretCode() {
        for (int i = 0; i < this.code.length; i++) {
            this.code[i] = this.letters[this.randomIndex()];
        }
    }

    private int randomIndex() {
        return random.nextInt(letters.length - 1);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.code);
    }
}
