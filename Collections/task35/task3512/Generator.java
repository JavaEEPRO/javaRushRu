
//And they had breastplates, as it were breastplates of iron;
//and the sound of their wings was as the sound of chariots of many horses running to battle. (Revelation 9:9)

package com.javarush.task.task35.task3512;

public class Generator<T> {

    Class<T> tClass;

    public Generator(Class<T> tClass) {
        this.tClass = tClass;
    }

    T newInstance() {
        try {
            return (T) tClass.newInstance();
        }catch (Exception e) {}
        return null;
    }
}

/*
Генератор объектов

Разберись с текущими классами.

Метод newInstance класса Generator должен создавать Event для каждого нового вызова, однако сейчас компилятор ругается на синтаксис.

Переделай класс Generator так, что бы конструкция стала рабочей.



Подсказка: Для создания объекта потребуется использовать метод Class<T>.newInstance().





Требования:

1. Класс Generator должен быть параметризован типом Т.

2. Класс Generator должен иметь поле типа Class, которое параметризовано типом Т.

3. Класс Generator должен иметь конструктор, который инициализирует поле типа Class.

4. Метод newInstance в классе Generator должен создавать и возвращать объект типа Т.
*/
