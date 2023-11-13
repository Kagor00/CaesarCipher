package com.javarush.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileService {
    public String readFile(String filePath) {
        String inputText;
        try {
            inputText = Files.readString(Path.of(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return inputText;
    }

    public void writeFile(String filePath, String outputText, String cipherArgument) {
        try {
            Path inputPath = Path.of(filePath);
            String fileName = inputPath.getFileName().toString();
            if (fileName.contains("[ENCRYPTED]")) {
                fileName = fileName.replace("[ENCRYPTED]", "");
            }
            String newFileName = String.format("%s %s%s", fileName.substring(0, fileName.indexOf(".")), cipherArgument, fileName.substring(fileName.indexOf(".")));
            Path outputPath = inputPath.resolveSibling(newFileName);
            Files.write(outputPath, outputText.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
