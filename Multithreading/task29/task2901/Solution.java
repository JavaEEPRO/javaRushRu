
//I Jesus have sent mine angel to testify unto you these things in the churches. I am the root and the offspring of David, and the bright and morning star. (Revelation 22:16)

package com.javarush.task.task29.task2901;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

/* 
Рефакторинг в соответствии с Naming and Code Convention
*/
public class Solution {
    public static final String DEFAULT_FILE_NAME = "C:/tmp/file_strange_name.tmp";

    private final String localFileName;
    private List<String> contentAslines;
    private boolean fileLoaded;

    public Solution(String firstFileName) {
        localFileName = firstFileName == null ? DEFAULT_FILE_NAME : firstFileName;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = Solution.class.getResource("Solution.java").getPath();

        Solution solution = new Solution(fileName);
        solution.downloadFileContent();
        if (solution.isFileLoaded()) {
            System.out.println(solution.hasFileExpectedLine("public class Solution {"));   //expected true
            System.out.println(solution.hasFileExpectedLine(" public class Solution {"));  //expected false
        }
    }

    public boolean isFileLoaded() {
        return fileLoaded;
    }

    public void downloadFileContent() {
        try {
            contentAslines = Files.readAllLines((new File(localFileName)).toPath(), Charset.defaultCharset());
            fileLoaded = true;
        } catch (IOException e) {
            System.out.println("Unsuccessful. What a surprise!");
        }
    }

    public boolean hasFileExpectedLine(String expectedLine) {
        return contentAslines.contains(expectedLine);
    }
}

/*
Рефакторинг в соответствии с Naming and Code Convention

Исправить код в соответствии с Naming and Code Convention (Shift+F6 для рефакторинга).



Подсказка:

IDEA не умеет правильно переименовывать имена классов, если меняется только регистр.

Переименуй имя класса во вспомогательное имя, а потом в это же в правильном регистре.





Требования:

1. Переименуй константу defaultFileName в соответствии с Naming and Code Convention.

2. Переименуй метод getFileLoaded в соответствии с Naming and Code Convention.

3. Переименуй метод DownloadFileContent в соответствии с Naming and Code Convention.

4. Переименуй метод isfileexpectedline в соответствии с Naming and Code Convention.

5. Переименуй параметр expectedline метода принимающего String в соответствии с Naming and Code Convention.
*/
