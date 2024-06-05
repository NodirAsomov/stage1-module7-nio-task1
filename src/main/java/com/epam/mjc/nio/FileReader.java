package com.epam.mjc.nio;

import org.antlr.v4.runtime.misc.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String[] words = getImportant(fileToString(file));

        return new Profile(words[0], Integer.parseInt(words[1]), words[2], Long.parseLong(words[3]));
    }

    private List<String> fileToString(File file) {
        Path path = Paths.get(file.getAbsolutePath());
        java.util.List<String> lines = null;

        try {
            lines = Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return lines;
    }


    private String[] getImportant(List<String> list) {
        String[] words = new String[4];

        words[0] = list.get(0).substring(list.get(0).indexOf(':') + 2);
        words[1] = list.get(1).substring(list.get(1).indexOf(':') + 2);
        words[2] = list.get(2).substring(list.get(2).indexOf(':') + 2);
        words[3] = list.get(3).substring(list.get(3).indexOf(':') + 2);

        return words;

    }
}
