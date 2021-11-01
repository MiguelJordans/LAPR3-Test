package lapr.project.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class FileUtils {
    static BufferedReader br;
    FileWriter writer;

    public static String read(Path File) throws IOException {
        String result = "";
        br = new BufferedReader(new FileReader(String.valueOf(File)));
        StringBuilder builder = new StringBuilder(result);
        String line = br.readLine();

        while (line != null) {
            builder.append(line);
            line = br.readLine();
        }
        result = builder.toString();
        return result;
    }


    public static void write(Path File,String string) throws IOException {
        try (FileWriter wr = new FileWriter(String.valueOf(File))) {
            wr.append(string);
        }
    }
}
