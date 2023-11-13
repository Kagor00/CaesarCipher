package com.javarush.main;

public class Runner {

    public static void main(String[] args) {
        if (args.length == 3) {
            CryptoManager.executeWithKey(args[0], args[1], Integer.parseInt(args[2]));
        } else if (args.length == 2) {
            CryptoManager.executeBruteForce(args[0], args[1]);
        } else {
            CryptoManager.executeInteractive();
        }
    }
}
