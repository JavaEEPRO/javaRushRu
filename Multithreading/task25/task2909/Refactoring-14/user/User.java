
//He brought him to Jesus. Jesus looked at him, and said, "You are Simon the son of Jonah. You shall be called Cephas" (which is by interpretation, Peter). (John 1:42)

package com.javarush.task.task29.task2909.user;

public class User {
    private String name;
    private String surname;
    private int age;
    private boolean man;

    private Work work;
    private Address address = new Address(); 

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    
     public boolean isMan() {
        return man;
    }

    public void setMan(boolean man) {
        this.man = man;
    }
    
    public void printInfo() {
        System.out.println("Имя: " + this.getName());
        System.out.println("Фамилия: " + this.getSurname());
    }
    
    public void printAdditionalInfo() {
        if (this.getAge() < 16)
            System.out.println("Пользователь моложе 16 лет");
        else
            System.out.println("Пользователь старше 16 лет");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return address.getCountry();
    }

    public void setCountry(String country) {
        address.setCountry(country);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        address.setCity(city);
    }

    public String getAddress() {
        return address.getCountry() + " " + address.getCity() + " " + address.getHouse();
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
    
     public String getBoss() {
        return work.getBoss();
    }
}

/*
Рефакторинг (14)
14.1. Перемещение поля. Замени поля isManAnya и isManRoma полем man в нужном классе.
Добавь сеттер и геттер для нового поля (при выборе имен методов учти тип поля).
14.2. Извлечение класса.
14.2.1. Добавь класс Address в пакет user.
14.2.2. Перенеси поля country, city и house в новый класс.
14.2.3. Добавь сеттеры и геттеры для них.
14.2.4. Перепиши класс User, используя поле класса Address address.
14.3. Встраивание класса. Класс House почти ничего не делает, избавься от него.
14.4. Сокрытие делегирования.
14.4.1. Добавь в класс User метод getBoss().
14.4.2. Перепиши реализацию метода getBossName(User user) класса UserHelper.


Требования:
1. Необходимо заменить поля isManAnya и isManRoma класса UserHelper полем boolean man в классе User. Так же добавь сеттер и геттер для нового поля.
2. Необходимо добавить класс Address в пакет user.
3. Необходимо перенести поля country, city и house из класса User в класс Address.
4. Необходимо добавить сеттеры и геттеры для полей country, city, house класса Address.
5. В классе User необходимо переписать методы: getAddress, getCountry, setCountry, getCity, setCity. И нужно добавить в класс приватное поле Address address.
6. Необходимо избавиться от класса House. Поле класса String house нужно перенести в класс Address. Необходимо обновить геттер и сеттер поля.
7. Необходимо добавить в класс User метод getBoss() и реализовать этот метод.
8. Необходимо изменить реализацию метода getBossName(User user) класса UserHelper (используй метод getBoss() класса User).
Рефакторинг (13)
Разберись с кодом пакета user (пользователь).
13.1. Извлечение метода. Добавь метод printInfo(), который будет выводить имя и фамилию
в консоль в формате

Имя: Вася
Фамилия: Пупкин

Замени повторяющийся код метода printUsers() его вызовом.
13.2. Встраивание метода. Избавься от метода ageLessThan16().
13.3. Перемещение метода. Перемести методы printInfo() и printAdditionalInfo() в класс User.
13.4. Расщепление переменной. Переменная age в методе calculateAverageAge() используется для разных промежуточных значений. Перепиши метод без использования этой переменной.
13.5. Удаление присваиваний параметрам. Перепиши метод calculateRate(), чтобы он не
пытался менять входные параметры, а просто возвращал рассчитанное значение.

Рефакторинг (12)
12.1. Объединение условных операторов.
12.1.1. Добавь внутренний метод, сообщающий, могут ли быть перевезены пассажиры
boolean canPassengersBeTransferred() в класс Car. Метод должен возвращать true, если
водитель доступен isDriverAvailable и есть топливо fuel.
12.1.2. Перепиши метод getNumberOfPassengersCanBeTransferred(), объединив условные
операторы (используй метод canPassengersBeTransferred()).
12.2. Объединение дублирующихся фрагментов в условных операторах. Перепиши метод
startMoving(), чтобы в нем не было повторяющихся вызовов функций.
12.3. Замена магического числа символьной константой. Замени магические числа в методе
getMaxSpeed() на константные переменные метода: MAX_TRUCK_SPEED,
MAX_SEDAN_SPEED и MAX_CABRIOLET_SPEED.
12.4. Замена условного оператора полиморфизмом.
12.4.1. Переопредели метод getMaxSpeed() в подклассах, избавившись от условного оператора.
12.4.2. Метод getMaxSpeed() в классе Car сделай абстрактным.

Рефакторинг (11)
11.1. Замена кода ошибки исключением. Перепиши метод заправиться fill(double
numberOfLiters), чтобы он в случае ошибки кидал исключение Exception.
11.2. Разбиение условного оператора.
11.2.1. Добавь и реализуй метод в классе Car, определяющий относится ли переданная дата к
лету: boolean isSummer(Date date , Date summerStart, Date summerEnd).
11.2.2. Добавь и реализуй метод, рассчитывающий расход топлива зимой: double
getWinterConsumption(int length).
11.2.3. Добавь и реализуй метод, рассчитывающий расход топлива летом: double
getSummerConsumption(int length).
11.2.4. Перепиши метод getTripConsumption(), используя новые методы.

Рефакторинг (10)
Разберись с кодом в пакете car (машина).
10.1. Замена конструктора фабричным методом.
10.1.1. Объяви классы Truck (грузовик), Sedan (седан) и Cabriolet (кабриолет), унаследованные от Car.
10.1.2. Добавь в них конструкторы, принимающие int numberOfPassengers.
10.1.3. Добавь фабричный статический метод Car create(int type, int numberOfPassengers) в класс Car и реализуй его.
10.1.4. Измени область видимости конструктора класса Car.

Рефакторинг (9)
9.1. Самоинкапсуляция поля. Перепиши метод incAverageGrade() используя сеттер и геттер для доступа к averageGrade.
9.2. Замена поля-массива объектом. Замени массив int[] size объектом нового типа Size,
содержащим публичные поля: рост int height и вес int weight. Публичный класс Size объяви
внутри класса Human.
9.3. Инкапсуляция поля. Сокрой поле company в классе Worker. Добавь сеттер и геттер для него.
9.4. Замена кодирования типа классом.
9.4.1. Объяви публичный класс группы крови BloodGroup внутри пакета human.
9.4.2. Добавь в класс BloodGroup приватное константное поле int code, приватный конструктор,
принимающий int и инициализирующий поле code, геттер для поля класса.
9.4.3. Добавь в класс BloodGroup статические методы first(), second(), third() и fourth(),
создающие и возвращающие объекты типа BloodGroup с правильным кодом внутри (1, 2, 3 и 4 соответственно).
9.4.4. Примени в классе Human новый тип BloodGroup.
*/
