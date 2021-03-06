
//Therefore when Jesus saw his mother, and the disciple whom he loved standing there, he said to his mother, "Woman, behold your son!" (John 19:26)

package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    
    private List<Horse> horses;
    public static Hippodrome game;
    
    public Hippodrome(List<Horse> list) {
        this.horses = list;
    }
    
    public List<Horse> getHorses() {
        return this.horses;
    }
    public static void main(String[] args) {
        
        List<Horse> horses = new ArrayList<Horse>();
        
        Horse horseRed = new Horse("red", 3, 0);
        Horse horseBlack = new Horse("black", 3, 0);
        Horse horseWhite = new Horse("White", 3, 0);
        horses.add(horseRed);
        horses.add(horseBlack);
        horses.add(horseWhite);
        game = new Hippodrome(horses);
    }
}

/*
Ипподром(6)
Теперь перейдем к классу Hippodrome и методу main.
Нам нужно создать объект типа Hippodrome и добавить ему несколько лошадей.

Для начала, в классе Hippodrome:
Создай статическое поле game типа Hippodrome.

В методе main требуется:
а) Создать объект типа Hippodrome и сохранить его в поле game.
б) Создать три объекта «лошадь«. Имена придумай сам. Начальные скорость у всех лошадей — 3, дистанция — 0.
в) Добавить созданных лошадей в список лошадей ипподрома (horses). Получить список лошадей ипподрома можно с помощью метода getHorses.


Требования:
1. В классе Hippodrome должно быть создано поле game типа Hippodrome.
2. Поле game должно быть статическим.
3. Поле game НЕ должно быть приватным.
4. В методе main должно инициализироваться поле game.
5. В методе main в список лошадей ипподрома должны быть добавлены три лошади.
6. Скорости всех лошадей должны быть равны 3, а дистанции - 0.

Ипподром(5)
Закончим написание класса лошадь (Horse).
Добавь конструктор с параметрами (name, speed, distance).
Добавь getter’ы и setter’ы для всех полей класса Horse.
Делай все методы public, если явно не указано обратное.

Ипподром(4)
Теперь вернемся к лошадям. У каждой лошади на скачках должны быть известны имя (name) и скорость (speed).
Наши лошади будут бежать просто определенное время (100 секунд/»шагов»).
Будем определять победителя, как лошадь, пробежавшую наибольшую дистанцию.
Поэтому нам понадобится хранить еще и расстояние (distance), которое лошадь уже пробежала.
Добавь в класс Horse переменные name (String), speed (double), distance (double).

Ипподром(3)
Несмотря на то что мы объявили переменную horses, сам список еще не создан (если ты конечно не успел опередить нас).
Создай конструктор класса Hippodrome с одним параметром типа List.
Сохрани в поле horses полученный в качестве параметра список (инициализируй поле horses).

Ипподром(2)
Раз это ипподром, то на нем должны быть лошади.
Значит наш ипподром должен хранить список всех его лошадей.
Добавь поле horses типа List<Horse> в класс Hippodrome.
А чтобы лошадей не украли — сделай это поле приватным.
Добавь getter для этого поля.

Ипподром(1)
Сегодня мы напишем небольшую игру под названием «Ипподром«.
Когда я говорю мы — я имею ввиду тебя. Я же буду работать наставником.

Для начала нам понадобятся классы «ипподром» и «лошадь«.
Создай классы Hippodrome (ипподром), Horse (лошадь).

Также не забудь, что любая программа начинается с метода main.
Добавь его в класс Hippodrome.

package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses = new ArrayList<Horse>();
    
    public Hippodrome(List<Horse> list) {
        this.horses = list;
    }
    
    public List<Horse> getHorses() {
        return this.horses;
    }
    public static void main(String[] args) {}
}
*/
