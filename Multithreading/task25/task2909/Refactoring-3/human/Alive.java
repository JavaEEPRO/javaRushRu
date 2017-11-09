
//Which things also we speak, not in the words which man's wisdom teaches, but which the Holy Spirit teaches; comparing spiritual things with spiritual. (1Cor 2:13)

package com.javarush.task.task29.task2909.human;


public interface Alive {
    void live();
}

/*
Рефакторинг (3)
3.1. Спуск поля. Спусти поле course в соответствующий класс. Сделай его приватным.
3.2. Спуск метода. Спусти геттер для поля course в соответствующий класс.
3.3. Извлечение интерфейса.
3.3.1. Создай интерфейс Alive (живой) в пакете human.
3.3.2. Интерфейс должен содержать метод жить live().
3.3.3. Добавь интерфейс нужному классу.
3.4. Свертывание иерархии. Избавься от класса Professor.


Требования:
1. Необходимо спустить поле course в нужный класс и сделать его приватным.
2. Необходимо спустить геттер для поля course в нужный класс.
3. Интерфейс Alive должен существовать в пакете human.
4. Интерфейс Alive должен содержать объявление метода жить live().
5. Класс Human должен поддерживать интерфейс Alive.
6. Класс Professor нужно удалить.
*/
