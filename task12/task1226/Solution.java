
//A new commandment I give to you, that you love one another, just like I have loved you; that you also love one another. (John 13:34)


package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {
    
    public interface Fly {
        public void fly();
    }

    public interface Climb {
        public void climb();
    }
    
    public interface Run {
        public void run();
    }
    
    public class Cat implements Run, Climb{
        public void run(){}
        public void climb(){}
    }

    public class Dog implements Run {
        public void run() {}
    }

    public class Tiger extends Cat {
        public void run(){}
        public void climb(){}
    }

    public class Duck implements Run, Fly {
        public void run(){}
        public void fly(){}
    }
}




/*
Лазать, летать и бегать
1. Внутри класса Solution создай интерфейс public interface Fly(летать) с методом void fly().
2. Внутри класса Solution создай интерфейс public interface Climb(лазить по деревьям) с методом void climb().
3. Внутри класса Solution создай интерфейс public interface Run(бегать) с методом void run().
4. Подумай логически, какие именно интерфейсы нужно добавить для каждого класса.
5. Добавь интерфейсы классам Cat(кот), Dog(собака), Tiger(тигр), Duck(Утка).


Требования:
1. Класс Solution должен содержать интерфейс Fly с методом void fly().
2. Класс Solution должен содержать интерфейс Climb с методом void climb().
3. Класс Solution должен содержать интерфейс Run с методом void run().
4. Объект класса Cat должен уметь бегать(поддерживать интерфейс Run) и лазить по деревьям(поддерживать интерфейс Climb).
5. Объект класса Dog должен уметь бегать(поддерживать интерфейс Run).
6. Класс Tiger должен быть котом.
7. Объект класса Duck должен уметь бегать(поддерживать интерфейс Run) и летать(поддерживать интерфейс Fly).

package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {

    public class Cat {
    }

    public class Dog {
    }

    public class Tiger extends Cat {
    }

    public class Duck {
    }
}

*/
