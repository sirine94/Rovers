package com.syrine.exercices.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

        public static List ReadFile(String fileName) throws IOException {
        if(fileName.isEmpty() || fileName == null)
            throw new IOException("Please enter as argument the input file.");
        List<String> list;
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            list = stream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
        return list;

    }
}
