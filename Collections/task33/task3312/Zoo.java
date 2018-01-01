
//They marched across the breadth of the earth and surrounded the camp of God's people, the city he loves.
//But fire came down from heaven and devoured them. (Revelation 20:9)

package com.javarush.task.task33.task3312;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public List<Animal> animals = new ArrayList<>();

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY,  property="type")
    @JsonSubTypes({
            @JsonSubTypes.Type(value = Zoo.Dog.class, name = "dog"),
            @JsonSubTypes.Type(value = Zoo.Cat.class, name = "cat"),

    })
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

    @JsonTypeName ("dog")
    public static class Dog extends Animal {

        public double barkVolume;


        public Dog(String name) {
            super(name);
        }
    }

    @JsonTypeName ("cat")
    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}

/*
Сериализация зоопарка

Сделай так, чтобы при сериализации объекта типа Zoo, каждому элементу списка animals был добавлен тип (dog для класса Dog, cat для класса Cat).

Для проверки можешь использовать метод main класса Solution.



Было:

{"animals":[{"name":"doggy","barkVolume":0.0},{"name":"catty","lives":0}]}



Должно стать:

{"animals":[{"type":"dog","name":"doggy","barkVolume":0.0},{"type":"cat","name":"catty","lives":0}]}





Требования:

1. Класс Zoo.Animal должен быть отмечен аннотацией @JsonTypeInfo.

2. Класс Zoo.Animal должен быть отмечен аннотацией @JsonSubTypes.

3. Класс Zoo.Dog должен быть отмечен аннотацией @JsonTypeName.

4. Класс Zoo.Cat должен быть отмечен аннотацией @JsonTypeName.

5. При сериализации в JSON всем объектам списка animals должен быть добавлен тип и сохранен основной формат (пример в задании).
*/
