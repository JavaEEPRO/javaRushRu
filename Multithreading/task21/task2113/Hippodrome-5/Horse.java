
//But there were standing by the cross of Jesus his mother, and his mother's sister, Mary the wife of Clopas, and Mary Magdalene. (John 19:25)

package com.javarush.task.task21.task2113;

public class Horse {
    private String name;
    private double speed;
    private double distance;
    
    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    
    public double getDistance() {
        return distance;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }   
    
}
/*
Ипподром(5)
Закончим написание класса лошадь (Horse).
Добавь конструктор с параметрами (name, speed, distance).
Добавь getter’ы и setter’ы для всех полей класса Horse.
Делай все методы public, если явно не указано обратное.


Требования:
1. В классе Horse должен быть создан конструктор с параметрами String, double и double (name, speed и distance).
2. Конструктор класса Horse должен корректно инициализировать поля класса в соответствии с полученными параметрами.
3. В классе Horse должны быть созданы getter'ы для всех полей класса.
4. В классе Horse должны быть созданы setter'ы для всех полей класса.
5. Getter'ы класса Horse должны возвращать значения соответствующих полей класса.
6. Setter'ы класса Horse должны устанавливать значения соответствующих полей класса.

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


public class Horse {
    private String name;
    private double speed;
    private double distance;
}
*/
