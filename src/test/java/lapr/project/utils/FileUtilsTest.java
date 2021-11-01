package lapr.project.utils;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUtilsTest {

    @TempDir
    static Path tempDir;
    static Path tempFile;
/*
    @AfterAll
    public static void end() throws IOException {
        tempFile.
    }*/

    @BeforeAll
    public static void init() throws IOException {

        tempDir = Files.createTempDirectory("t");
        tempFile = Files.createFile(tempDir.resolve("test.txt"));
    }

    private static void fillFile(String text) throws IOException {
        FileWriter wr = new FileWriter(String.valueOf(tempFile));
        wr.append(text);
        wr.close();
    }

    @Test
    void oneLineReadTest() throws IOException {
        //Arrange
        String expected = "Olá!";
        fillFile(expected);
        //Act
        String actual = FileUtils.read(tempFile);
        //Assert
        assertEquals(actual, expected);

    }

    @Test
    void severalLinesReadTest() throws IOException {
        //Arrange
        String expected = "";
        StringBuilder builder;
        builder = new StringBuilder(expected);

        builder.append("Olá\n");
        builder.append("Tudo bem?");
        fillFile(expected);
        //Act
        String actual = FileUtils.read(tempFile);
        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void writeInFileOneLine() throws IOException {
        //Arrange
        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(tempFile)));
//      StringBuilder builder;

        String expected = "Olá";

        //Act
        FileUtils.write(Paths.get(String.valueOf(tempFile)), expected);
        String actual = br.readLine();
        //Assert
        assertEquals(actual, expected);
    }

    @Test
    void writeInFileMoreOneLine() throws IOException {
        //Arrange
        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(tempFile)));
//      StringBuilder builder;
        String expected = "";
        StringBuilder builder;
        builder = new StringBuilder(expected);

        builder.append("Olá\n");
        builder.append("Tudo bem?");
        String actual = "";

        //Act

        FileUtils.write(Paths.get(String.valueOf(tempFile)), builder.toString());
        String line = br.readLine();

        while (line != null) {
            builder.append(line);
            line = br.readLine();
        }
        actual = builder.toString();

        //Assert
        assertEquals(builder.toString(), actual);
    }

}