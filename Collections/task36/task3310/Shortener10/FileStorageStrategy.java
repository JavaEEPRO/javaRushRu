
//And they that dwell upon the earth shall rejoice over them, and make merry, and shall send gifts one to another; because these two prophets tormented them that dwelt on the earth. (Revelation 11:10)

package com.javarush.task.task33.task3310.strategy;

public class FileStorageStrategy implements StorageStrategy {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private FileBucket[] table = new FileBucket[DEFAULT_INITIAL_CAPACITY];
    private long bucketSizeLimit = 10000;
    private int size;


    static final long DEFAULT_BUCKET_SIZE_LIMIT = 10000;

    long maxBucketSize;



    public FileStorageStrategy() {
        for (int i = 0; i < DEFAULT_INITIAL_CAPACITY; i++) {
            table[i] = new FileBucket();
        }
    }

    public long getBucketSizeLimit() {
        return bucketSizeLimit;
    }

    public void setBucketSizeLimit(long bucketSizeLimit) {
        this.bucketSizeLimit = bucketSizeLimit;
    }

    public int hash(Long k) {
        long h = k;
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    public int indexFor(int hash, int length) {
        return hash % (length - 1);
    }

    public Entry getEntry(Long key) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    return entry;
                }
                entry = entry.next;
            }
        }
        return null;
    }

    public void resize(int newCapacity) {
        FileBucket[] newTable = new FileBucket[newCapacity];
        transfer(newTable);
        table = newTable;

    }

    public void transfer(FileBucket[] newTable) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) continue;
            Entry entry = table[i].getEntry();
            while (entry != null) {
                Entry next = entry.next;
                int newIndex = indexFor(entry.hash, newTable.length);
                if (newTable[newIndex] == null) {
                    entry.next = null;
                    newTable[newIndex] = new FileBucket();
                } else {
                    entry.next = newTable[newIndex].getEntry();
                }
                newTable[newIndex].putEntry(entry);
                entry = next;
            }
            table[i].remove();
        }
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {
        Entry entry = table[bucketIndex].getEntry();
        table[bucketIndex].putEntry(new Entry(hash, key, value, entry));
        size++;
        if (table[bucketIndex].getFileSize() > bucketSizeLimit)
            resize(2 * table.length);
    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {
        table[bucketIndex] = new FileBucket();
        table[bucketIndex].putEntry(new Entry(hash, key, value, null));
        size++;
    }

    @Override
    public boolean containsKey(Long key) {
        return getEntry(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            Entry entry = table[i].getEntry();
            while (entry != null) {
                if (entry.value.equals(value))
                    return true;

                entry = entry.next;
            }
        }
        return false;
    }

    @Override
    public void put(Long key, String value) {
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        if (table[index] != null) {
            Entry entry = table[index].getEntry();
            while (entry != null) {
                if (entry.getKey().equals(key)) {
                    entry.value = value;
                    return;
                }
                entry = entry.next;
            }
            addEntry(hash, key, value, index);
        } else {
            createEntry(hash, key, value, index);
        }
    }

    @Override
    public Long getKey(String value) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null)
                continue;

            Entry entry = table[i].getEntry();

            while (entry != null) {
                if (entry.value.equals(value))
                    return entry.key;
                entry = entry.next;
            }
        }
        return 0L;
    }

    @Override
    public String getValue(Long key) {
        Entry entry = getEntry(key);
        if (entry != null)
            return entry.value;

        return null;
    }
}

/*
Shortener (10)

Создай и реализуй класс FileStorageStrategy. Он должен:

10.1. Реализовывать интерфейс StorageStrategy.

10.2. Использовать FileBucket в качестве ведер (англ. bucket).



Подсказка: класс должен содержать поле FileBucket[] table.



10.3. Работать аналогично тому, как это делает OurHashMapStorageStrategy, но удваивать количество ведер не когда количество элементов size станет больше какого-то порога, а когда размер одного из ведер (файлов) стал больше bucketSizeLimit.

10.3.1. Добавь в класс поле long bucketSizeLimit.

10.3.2. Проинициализируй его значением по умолчанию, например, 10000 байт.

10.3.3. Добавь сеттер и геттер для этого поля.

10.4. При реализации метода resize(int newCapacity) проследи, чтобы уже не нужные файлы были удалены (вызови метод remove()).

Проверь новую стратегию в методе main(). Учти, что стратегия FileStorageStrategy гораздо более медленная, чем остальные. Не используй большое количество элементов для теста, это может занять оооочень много времени.

Запусти программу и сравни скорость работы всех 3х стратегий.



Запусти программу и сравни скорость работы всех 3х стратегий.

P.S. Обрати внимание на наличие всех необходимых полей в классе FileStorageStrategy, по аналогии с OurHashMapStorageStrategy:

static final int DEFAULT_INITIAL_CAPACITY

static final long DEFAULT_BUCKET_SIZE_LIMIT

FileBucket[] table

int size

private long bucketSizeLimit = DEFAULT_BUCKET_SIZE_LIMIT

long maxBucketSize





Требования:

1. Класс FileStorageStrategy должен поддерживать интерфейс StorageStrategy.

2. В классе FileStorageStrategy должны быть созданы все необходимые поля (согласно условию задачи).

3. Методы интерфейса StorageStrategy должны быть реализованы в FileStorageStrategy таким образом, чтобы обеспечивать корректную работу Shortener созданного на его основе.

Shortener (9)

Напишем еще одну стратегию, назовем ее FileStorageStrategy. Она будет очень похожа на стратегию OurHashMapStorageStrategy, но в качестве ведер (англ. buckets) будут файлы. Я знаю, ты знаешь о каких buckets идет речь, если нет - повтори внутреннее устройство HashMap.

9.1. Создай класс FileBucket в пакете strategy.

9.2. Добавь в класс поле Path path. Это будет путь к файлу.

9.3. Добавь в класс конструктор без параметров, он должен:

9.3.1. Инициализировать path временным файлом. Файл должен быть размещен в директории для временных файлов и иметь случайное имя.



Подсказка: Files.createTempFile.



9.3.2. Создавать новый файл, используя path. Если такой файл уже есть, то заменять его.

9.3.3. Обеспечивать удаление файла при выходе из программы.



Подсказка: deleteOnExit().



9.4. Добавь в класс методы:

9.4.1. long getFileSize(), он должен возвращать размер файла на который указывает path.

9.4.2. void putEntry(Entry entry) - должен сериализовывать переданный entry в файл. Учти, каждый entry может содержать еще один entry.

9.4.3. Entry getEntry() - должен забирать entry из файла. Если файл имеет нулевой размер, вернуть null.

9.4.4. void remove() - удалять файл на который указывает path.

Конструктор и методы не должны кидать исключения.



Shortener (8)

Добавь и реализуй класс OurHashMapStorageStrategy, используя класс Entry из предыдущей подзадачи. Класс OurHashMapStorageStrategy должен реализовывать интерфейс StorageStrategy.

8.1. Добавь в класс следующие поля:

8.1.1. static final int DEFAULT_INITIAL_CAPACITY = 16;

8.1.2. static final float DEFAULT_LOAD_FACTOR = 0.75f;

8.1.3. Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

8.1.4. int size;

8.1.5. int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);

8.1.6. float loadFactor = DEFAULT_LOAD_FACTOR;

8.2. Реализуй в классе следующие вспомогательные методы:

8.2.1. int hash(Long k)

8.2.2. int indexFor(int hash, int length)

8.2.3. Entry getEntry(Long key)

8.2.4. void resize(int newCapacity)

8.2.5. void transfer(Entry[] newTable)

8.2.6. void addEntry(int hash, Long key, String value, int bucketIndex)

8.2.7. void createEntry(int hash, Long key, String value, int bucketIndex)

8.3. Добавь в класс публичные методы, которые требует интерфейс StorageStrategy.

Какие-либо дополнительные поля класса не использовать. Методы, не описанные в задании, реализовывать не нужно. Если возникнут вопросы как реализовать какой-то метод или что он должен делать, то ты всегда можешь посмотреть, как работает похожий метод в HashMap.

Можешь добавить в метод main класса Solution тестирование новой стратегии. Запусти и сравни время работы двух стратегий на одинаковом количестве элементов.



Shortener (7)

Приступим к реализации второй стратегии OurHashMapStorageStrategy. Она не будет использовать готовый HashMap из стандартной библиотеки, а будет сама являться коллекцией.



7.1. Разберись как работает стандартный HashMap, посмотри его исходники или погугли статьи на эту тему.

7.2. Если ты честно выполнил предыдущий пункт, то ты знаешь для чего используется класс Node поддерживающий интерфейс Entry внутри HashMap. Создай свой аналог внутри пакета strategy. Это должен быть обычный, не вложенный, не generic класс. Сделай его публичным.

В отличии от класса Node из HashMap, наш класс будет поддерживать только интерфейс Serializable и будет называться Entry.

7.3. Добавь в Entry следующие поля: Long key, String value, Entry next, int hash. Как видишь, наша реализация будет поддерживать только тип Long для ключа и только String для значения. Область видимости полей оставь по умолчанию.

7.4. Добавь и реализуй конструктор Entry(int hash, Long key, String value, Entry next).

7.5. Добавь и реализуй методы: Long getKey(), String getValue(), int hashCode(), boolean equals() и String toString(). Реализовывать остальные методы оригинального Entry не нужно, мы пишем упрощенную версию.



Shortener (6)

Первая стратегия готова, пришло время ее протестить. Для этого:

6.1. Создай класс Solution, если ты не сделал это раньше.

6.2. Добавь в класс Solution реализации вспомогательных статических методов:

6.2.1. Set<Long> getIds(Shortener shortener, Set<String> strings). Этот метод должен для переданного множества строк возвращать множество идентификаторов. Идентификатор для каждой отдельной строки нужно получить, используя shortener.

6.2.2. Set<String> getStrings(Shortener shortener, Set<Long> keys). Метод будет возвращать множество строк, которое соответствует переданному множеству идентификаторов.

При реальном использовании Shortener, задача получить из множества строк множество идентификаторов и наоборот скорее всего не встретится, это нужно исключительно для тестирования.

6.2.3. testStrategy(StorageStrategy strategy, long elementsNumber). Метод будет тестировать работу переданной стратегии на определенном количестве элементов elementsNumber. Реализация метода должна:

6.2.3.1. Выводить имя класса стратегии. Имя не должно включать имя пакета.

6.2.3.2. Генерировать тестовое множество строк, используя Helper и заданное количество элементов elementsNumber.

6.2.3.3. Создавать объект типа Shortener, используя переданную стратегию.

6.2.3.4. Замерять и выводить время необходимое для отработки метода getIds для заданной стратегии и заданного множества элементов. Время вывести в миллисекундах. При замере времени работы метода можно пренебречь переключением процессора на другие потоки, временем, которое тратится на сам вызов, возврат значений и вызов методов получения времени (даты). Замер времени произведи с использованием объектов типа Date.

6.2.3.5. Замерять и выводить время необходимое для отработки метода getStrings для заданной стратегии и полученного в предыдущем пункте множества идентификаторов.

6.2.3.6. Сравнивать одинаковое ли содержимое множества строк, которое было сгенерировано и множества, которое было возвращено методом getStrings. Если множества одинаковы, то выведи "Тест пройден.", иначе "Тест не пройден.".

6.2.4. Добавь метод main(). Внутри метода протестируй стратегию HashMapStorageStrategy с помощью 10000 элементов.

6.3. Проверь, что программа работает и тест пройден.



Shortener (5)

Давай напишем наше первое хранилище (стратегию хранилища). Внутри оно будет содержать обычный HashMap. Все стратегии будем хранить в пакете strategy.

5.1. Создай класс HashMapStorageStrategy, реализующий интерфейс StorageStrategy.

5.2. Добавь в класс поле HashMap<Long, String> data. В нем будут храниться наши данные.

5.3. Реализуй в классе все необходимые методы. Реализации методов должны использовать поле data. Дополнительные поля не создавать.
*/