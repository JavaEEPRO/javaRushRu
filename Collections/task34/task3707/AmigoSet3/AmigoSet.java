
//He said, I am the voice of one crying in the wilderness, Make straight the way of the Lord, as said the prophet Esaias. (John 1:23)

package com.javarush.task.task37.task3707;

import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet<E> implements Serializable, Cloneable, Set<E> {

    private static final Object PRESENT = new Object();
    private transient HashMap<E,Object> map;

    public AmigoSet() {
        map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        map = new HashMap<>(Math.max((int) (collection.size() / .75f) + 1, 16));
        addAll(collection);
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }

    @Override
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        Set<E> keySet = map.keySet();
        return keySet.iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        map.remove(o);
        return super.remove(o);
    }
}

/*
AmigoSet (3)

Напиши свою реализацию следующих методов при условии, что нужно работать с ключами мапы:

* Iterator<E> iterator() - очевидно, что это итератор ключей. Получи множество ключей в map, верни его итератор

* int size() - это количество ключей в map, равно количеству элементов в map

* boolean isEmpty()

* boolean contains(Object o)

* void clear()

* boolean remove(Object o)



Ничего своего писать не нужно, используй то, что уже реализовано для множества ключей map.

Используй Alt+Insert => Override methods





Требования:

1. Метод iterator должен возвращать итератор для множества ключей поля map.

2. Метод size должен возвращать то же, что и метод size поля map.

3. Метод isEmpty должен возвращать true, если map не содержит ни одного элемента, иначе - false.

4. Метод contains должен возвращать true, если map содержит анализируемый элемент, иначе - false.

5. Метод clear должен вызывать метод clear объекта map.

6. Метод remove должен удалять из map полученный в качестве параметра элемент.
*/
