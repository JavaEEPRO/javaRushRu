
//And they had hair as the hair of women, and their teeth were as the teeth of lions. (Revelation 9:8)

package com.javarush.task.task35.task3510;

public class Puppy extends Dog {

    public Puppy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Щенок " + name;
    }
}

/*
Вход воспрещен!

Проанализируй классы в задаче.

В методе main создано два дома: один для котов и один для собак.

Однако сейчас, когда в дом для кошек заходит собака, возникает конфликт и все находящиеся в нем коты вынуждены покинуть дом (метод checkConflicts).



Помоги котам защитить свой дом от посторонних, а так же не позволить им случайно заходить в дом для собак.

Для этого параметризируй House типом T и внеси соответствующие правки в реализацию класса.



Метод main не принимает участие в тестировании.





Требования:

1. Класс House должен быть параметризован с типом T.

2. Поле residents в классе House должно быть параметризовано типом T.

3. Метод enter в классе House должен принимать объект типа T.

4. Метод leave в классе House должен принимать объект типа T.

5. Метод checkConflicts в классе House больше не нужен и должен быть удален.
*/