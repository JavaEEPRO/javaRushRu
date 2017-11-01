
//Gaius, my host and host of the whole assembly, greets you. Erastus, the treasurer of the city, greets you, as does Quartus, the brother. (Romans 16:23)

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
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e) {}
        }
    }
    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }
    public void print() {}
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
Ипподром(9)
Теперь вернемся к методам move и print. Начнем с move.

В методе move класса Hippodrome в цикле у каждой лошади мы вызываем метод move.

Да ты прав, его еще нет у класса Horse.

Поэтому в класс Horse надо добавить свой метод move :)

И метод print, кстати тоже.

Если я не говорю ничего насчет параметров метода, значит метод без параметров.

Делай все методы public, если явно не указано обратное.


Требования:
1. В классе Horse должен быть создан метод move.
2. В классе Horse должен быть создан метод print.
3. В методе move класса Hippodrome должен быть вызван метод move по одному разу для каждой лошади(каждого элемента списка horses).
Ипподром(8)
В методе run сделай цикл от 1 до 100. Это и будет наш забег.
В теле цикла вызываем сначала move, затем print.
Чтобы весь цикл не отработал за долю секунды — добавь в него еще Thread.sleep(200);

Ипподром(7)
Но и это еще не все — надо чтобы лошади бежали.
Добавь в класс Hippodrome методы run, move и print. Без параметров.
Метод move будет управлять движением всех лошадей.
Метод print отрисовывать их на экран.
А метод run — управлять всем этим.

Ипподром(6)
Теперь перейдем к классу Hippodrome и методу main.
Нам нужно создать объект типа Hippodrome и добавить ему несколько лошадей.

Для начала, в классе Hippodrome:
Создай статическое поле game типа Hippodrome.

В методе main требуется:
а) Создать объект типа Hippodrome и сохранить его в поле game.
б) Создать три объекта «лошадь«. Имена придумай сам. Начальные скорость у всех лошадей — 3, дистанция — 0.
в) Добавить созданных лошадей в список лошадей ипподрома (horses). Получить список лошадей ипподрома можно с помощью метода getHorses.

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
    
    public void run() {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            try{
                Thread.sleep(200);
            }catch(InterruptedException e) {}
        }
    }
    public void move() {}
    public void print() {}
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
*/
