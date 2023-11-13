package com.javarush.file;

import com.javarush.cryptography.BruteForce;
import com.javarush.cryptography.CaesarCipher;

public class Tools {
    private final CaesarCipher caesarCipher = new CaesarCipher();
    private final FileService fileService = new FileService();
    private final BruteForce bruteforce = new BruteForce();

    public void encryptProcess(String filePath, int key) {
        String inputText;
        String outputText;
        try {
            inputText = fileService.readFile(filePath);
            outputText = caesarCipher.encode(inputText, key);
            fileService.writeFile(filePath, outputText, "[ENCRYPTED]");
            System.out.println("Операцiю шифрування здiйснено успiшно");
        } catch (RuntimeException e) {
            System.out.println("Помилка. Перевiрте правильнiсть шляху до файлу.");
        }
    }

    public void decryptProcess(String filePath, int key) {
        String inputText;
        String outputText;
        try {
            inputText = fileService.readFile(filePath);
            outputText = caesarCipher.decode(inputText, key);
            fileService.writeFile(filePath, outputText, "[DECRYPTED]");
            System.out.println("Операцiю дешифрування здiйснено успiшно");
        } catch (RuntimeException e) {
            System.out.println("Помилка. Перевiрте правильнiсть шляху до файлу.");
        }
    }

    public void bruteForceProcess(String filePath) {
        String inputText;
        String outputText;
        try {
            inputText = fileService.readFile(filePath);
            int key = bruteforce.findKey(inputText);
            outputText = caesarCipher.decode(inputText, key);
            String cipherArgument = "BF_key " + key;
            fileService.writeFile(filePath, outputText, cipherArgument);
            System.out.println("Операцiю автоматичного пiдбору ключа здiйснено");
        } catch (RuntimeException e) {
            System.out.println("Помилка. Перевiрте правильнiсть шляху до файлу.");
        }
    }
}
