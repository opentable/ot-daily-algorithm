package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        boolean isUnique = false;
        if (args.length == 0) {
            System.out.println("Pass a string on the command line");
        } else {
            isUnique = areAllCharsUnique(args[0]);
        }

        System.out.println(isUnique ? "Unique!" : "not unique :-(");
    }

    private static boolean areAllCharsUnique(String arg) {
        if (arg == null || arg.length() == 0)
            return false;

        char [] characters = arg.toCharArray(); // pretend this is c++
        Arrays.sort(characters);                // let's not make this too hard
        char lastChar = characters[0];
        for (int i = 1; i < arg.length(); i++) {
            if (characters[i] == lastChar) {
                return false;
            }
            lastChar = characters[i];
        }
        return true;
    }

}
