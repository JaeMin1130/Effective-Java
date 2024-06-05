package chapter2.item9.trywithresources;

import java.io.*;

public class TopLineWithDefault {
    // 코드 9-5 try-with-resources with catch절
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "chapter2\\item9\\iru.txt";
        System.out.println(firstLineOfFile(path, "Toppy McTopFace"));
    }
}
