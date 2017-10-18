
//You heard how I told you, 'I go away, and I come to you.' If you loved me, you would have rejoiced, 
//because I said 'I am going to my Father;' for the Father is greater than I. (John 14:28)

----------------------------------------------Solution.java---------------------------------------------------
package com.javarush.task.task14.task1421;

/* 
Singleton
*/
public class Solution {
    public static void main(String[] args) {
    }
}

--------------------------------------------------------------------------------------------------------------


-----------------------------------------------Singleton.java-------------------------------------------------
package com.javarush.task.task14.task1421;


public class Singleton {
    private Singleton(){}
    private static final Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
--------------------------------------------------------------------------------------------------------------





/*
Singleton
Класс является синглтоном (реализует паттерн Singleton), если позволяет создать всего один объект своего типа.

Реализовать Singleton pattern:
1. Создай класс Singleton в отдельном файле.
2. Добавь в него статический метод getInstance().
3. Метод getInstance должен возвращать один и тот же объект класса Singleton при любом вызове метода getInstance.
4. Подумай, каким образом можно запретить создание других объектов этого класса.
5. Сделай все конструкторы в классе Singleton приватными (private).
6. В итоге должна быть возможность создать объект (экземпляр класса) ТОЛЬКО используя метод getInstance.


Требования:
1. Класс Singleton должен быть создан в отдельном файле.
2. Класс Singleton не должен позволять создавать объекты своего типа извне класса.
3. Класс Singleton должен содержать приватное статическое поле instance типа Singleton.
4. В классе Singleton должен быть реализован публичный статический метод getInstance возвращающий значение поля instance.
5. Метод getInstance должен ВСЕГДА возвращать один и тот же объект.

package com.javarush.task.task14.task1421;

* 
Singleton
*
public class Solution {
    public static void main(String[] args) {
    }
}

*/
