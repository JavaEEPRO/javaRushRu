
//The same came for a witness, to bear witness of the Light, that all men through him might believe. (John 1:7)

package com.javarush.task.task31.task3110;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) throws Exception {
        Path zipDirectory = zipFile.getParent();
        if (Files.notExists(zipDirectory))
            Files.createDirectories(zipDirectory);

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {

            if (Files.isDirectory(source)) {
                List<Path> fileNames = Collections.emptyList();//fileManager.getFileList();

                for (Path fileName : fileNames)
                    addNewZipEntry(zipOutputStream, source, fileName);

            } else if (Files.isRegularFile(source)) {

                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());
            } else {

                throw new Exception();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}

/*
Archiver (2)

Сейчас мы напишем реализацию метода createZip(Path source), в котором мы будем архивировать файл, заданный переменной source.

В Java есть специальный класс ZipOutputStream из пакета java.util.zip, который сжимает (архивирует)

переданные в него данные. Чтобы несколько файлов, сжимаемые в один архив, не слиплись вместе, для каждого из них создается специальная сущность - элемент архива ZipEntry. Т.е. в ZipOutputStream мы сначала кладем ZipEntry, а затем уже записываем содержимое файла. При записи файл автоматически сжимается, а при чтении - автоматически восстанавливается. ZipEntry может быть не только файлом, но и папкой.



Чтобы заархивировать файл (создать новый архив и добавить в него файл):

1. Создай новый поток архива ZipOutputStream используя переменную класса zipFile, с помощью метода newOutputStream класса Files.

2. Создай новый элемент архива ZipEntry. В конструктор ZipEntry передай строку, содержащую имя новой записи. Имя нужно получить из полного пути source, взять только имя файла и сконвертировать его в String.

3. Добавь в поток архива созданный элемент архива.

4. Перепиши данные из файла, который архивируем в поток архива. Для этого:

4.1. Создай поток InputStream для добавляемого файла source, используя метод newInputStream класса Files

4.2. Сделай цикл, который будет читать данные из InputStream (созданного в п.4.1), пока они там есть и записывать их в ZipOutputStream (созданный в п.1)

4.3. Закрой InputStream, сделай это с помощью try-with-resources

5. Закрой элемент архива у потока архива

6. Закрой поток архива, сделай это также с помощью try-with-resources

7. Запусти программу и проверь, что файл архивируется





Требования:

1. Метод createZip должен создавать ZipOutputStream используя поле zipFile и метод Files.newOutputStream.

2. Метод createZip должен создавать элемент архива ZipEntry c именем файла, полученным из параметра source.

3. Созданный ZipEntry нужно добавить в ZipOutputStream.

4. Для переменной source должен быть создан InputStream с помощью метода Files.newInputStream.

5. Данные из InputStream нужно переписать в ZipOutputStream.

6. Закрой текущий Entry у объекта ZipOutputStream.

7. InputStream для source должен быть закрыт.

8. ZipOutputStream должен быть закрыт.
*/
