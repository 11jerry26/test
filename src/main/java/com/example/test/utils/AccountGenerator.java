package com.example.test.utils;

import java.io.*;

/**
 * @author 何建宇
 */
public class AccountGenerator {
    private static final String PREFIX = "ktp";
    private static int counter;

    static {
        // 从文件中读取计数器的值
        counter = loadCounterFromFile();
    }

    public static String generateAccount() {
        String number = String.format("%010d", counter++);
        saveCounterToFile(counter);
        return PREFIX + number;
    }

    private static int loadCounterFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("counter.txt"))) {
            String line = reader.readLine();
            return Integer.parseInt(line);
        } catch (IOException | NumberFormatException e) {
            // 处理读取文件失败或解析计数器值失败的情况
            return 0; // 默认值为0
        }
    }

    private static void saveCounterToFile(int counter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("counter.txt"))) {
            writer.write(String.valueOf(counter));
        } catch (IOException e) {
            // 处理写入文件失败的情况
        }
    }
}
