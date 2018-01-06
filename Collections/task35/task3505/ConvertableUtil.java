
//And in those days shall men seek death, and shall not find it; and shall desire to die, and death shall flee from them. (Revelation 9:6)

package com.javarush.task.task35.task3505;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertableUtil {

    public static <T extends Convertable> Map convert(List<T> list) {
        Map map = new HashMap();
        for (T entry: list)
            map.put(entry.getKey(), entry);
        return map;
    }
}

/*
List to Map

Реализуй логику метода convert в классе ConvertableUtil, который должен возвращать словарь, значениями которого являются элементы переданного cписка, а ключами являются объекты, полученные вызовом интерфейсного метода getKey.



Элементы cписка должны наследоваться от Convertable, который в свою очередь параметризирован каким-то ключом.

Например, ConvertableBook параметризирован String, т.е. ключ в результирующем словаре должен иметь тип - String

ConvertableUser параметризирован Integer, т.е. ключ в результирующем словаре должен иметь тип - Integer



Значения в словаре должны совпадать с элементами Списка.

Смотрите метод main для примера.



Расставьте в методе ConvertableUtil.convert дженерик типы.





Требования:

1. В множестве значений словаря возвращенного методом convert класса ConvertableUtil должны содержаться все элементы конвертируемого списка.

2. Размер словаря возвращенного методом convert класса ConvertableUtil должен быть равен размеру конвертируемого списка.

3. В множестве ключей словаря возвращенного методом convert класса ConvertableUtil должны содержаться ключи конвертируемого списка, полученные с помощью вызова метода getKey на каждом объекте списка.

4. Конвертация должна проходить в соответствии с условием задачи, ключи получаем с помощью метода getKey, а значением служат сами объекты списка.
*/
