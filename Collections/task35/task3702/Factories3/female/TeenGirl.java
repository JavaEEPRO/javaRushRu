
//And the four angels were loosed, which were prepared for an hour, and a day, and a month, and a year,
//for to slay the third part of men. (Revelation 9:15)

package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.Human;

public class TeenGirl implements Human {

    public static final int MAX_AGE = 19;

    @Override
    public String toString() {
        return "TeenGirl{}";
    }
}

/*
Фабрики (3)

1. Создай пакет female, в котором создай KidGirl, TeenGirl и Woman аналогично классам из пакета male.



2. Создай в пакете female фабрику FemaleFactory аналогичную MaleFactory с тем же принципом получения объектов.



3. Подумай, что общего у двух фабрик? Что можно сделать, чтобы легко можно было переключаться между ними?



Ответ - в следующем задании.





Требования:

1. Классы KidGirl, TeenGirl, Woman должны быть размещены в пакете female и поддерживать интерфейс Human.

2. В классах KidGirl, TeenGirl, Woman должен быть переопределен метод toString в соответствии с условием задачи.

3. В классе KidGirl константа MAX_AGE должна быть равна 12.

4. В классе TeenGirl константа MAX_AGE должна быть равна 19.

5. Для возрастов больше 19 лет метод getPerson фабрики FemaleFactory должен возвращать объект типа Woman.

6. Для возрастов больше 12 лет, но меньше 20, метод getPerson фабрики FemaleFactory должен возвращать объект типа TeenGirl.

7. Для возрастов меньше 13 лет, метод getPerson фабрики FemaleFactory должен возвращать объект типа KidGirl.
*/
