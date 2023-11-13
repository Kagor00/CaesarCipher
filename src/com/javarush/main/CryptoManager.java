package com.javarush.main;

import com.javarush.file.Tools;

import java.util.Scanner;

public class CryptoManager {
    private static final Tools tools = new Tools();

    public static void executeWithKey(String command, String filePath, int key) {
        switch (command.toLowerCase()) {
            case "encrypt" -> tools.encryptProcess(filePath, key);
            case "decrypt" -> tools.decryptProcess(filePath, key);
            default -> System.out.println("Помилка. Невiрна команда.");
        }
    }

    public static void executeBruteForce(String command, String filePath) {
        switch (command.toLowerCase()) {
            case "brute_force", "bruteforce", "brute-force" -> tools.bruteForceProcess(filePath);
            default -> System.out.println("Помилка. Невiрна команда.");
        }
    }

    public static void executeInteractive() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введiть команду: ");
        String command = scanner.nextLine();
        System.out.print("Введiть шлях до файлу: ");
        String filePath = scanner.nextLine();

        switch (command.toLowerCase()) {
            case "encrypt", "decrypt" -> {
                System.out.print("Введiть ключ: ");
                try {
                    int key = scanner.nextInt();
                    executeWithKey(command, filePath, key);
                } catch (RuntimeException e) {
                    System.out.println("Помилка. Ключ має бути цiлим числом.");
                }
            }
            case "brute_force", "bruteforce", "brute-force", "brute force" -> tools.bruteForceProcess(filePath);
            default -> System.out.println("Помилка. Невiрна команда.");
        }

        scanner.close();
    }
}
