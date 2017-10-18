
//Jesus answered, and said to him: If any one love me, he will keep my word, and my Father will love him, and we will come to him,
//and will make our abode with him. (John 14:23)


//look at the line 103 :)))
-----------------------------------------------Solution.java-----------------------------------------------------------------
package com.javarush.task.task14.task1413;

/* 
Computer
*/

public class Solution {
    public static void main(String[] args) {
        Computer computer = new Computer(new Keyboard(), new Mouse(), new Monitor());
        if (isWork(computer.getKeyboard()) &&
                isWork(computer.getMonitor()) &&
                isWork(computer.getMouse())) {
            System.out.println("Work!");
        }
    }

    public static boolean isWork(CompItem item) {
        System.out.println(item.getName());
        return item.getName() != null && item.getName().length() > 4;
    }

}

-----------------------------------------------------------------------------------------------------------------------------


------------------------------------------------CompItem.java----------------------------------------------------------------
package com.javarush.task.task14.task1413;


public interface CompItem {
    String getName();
}
-----------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Computer.java----------------------------------------------------------------
package com.javarush.task.task14.task1413;


public class Computer {
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;
    
    public Computer (Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }
    
    public Keyboard getKeyboard () {
        return keyboard;
    }
    
    public Mouse getMouse () {
        return mouse;
    }
    
    public Monitor getMonitor () {
        return monitor;
    }
}
-----------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Monitor.java-----------------------------------------------------------------
package com.javarush.task.task14.task1413;


public class Monitor implements CompItem {
    
    @Override
    public String getName () {return this.getClass().getSimpleName();}
}
-----------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Keyboard.java----------------------------------------------------------------
package com.javarush.task.task14.task1413;


public class Keyboard implements CompItem {
    
    @Override
    public String getName () {return this.getClass().getSimpleName();}
}
-----------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Mouse.java-------------------------------------------------------------------
package com.javarush.task.task14.task1413;


public class Mouse implements CompItem {
    public String getName () {return "Mouse";}   // this works, compiles and passes validation also :)))
}
-----------------------------------------------------------------------------------------------------------------------------




/*
Computer
1. Создай интерфейс CompItem.
2. Добавь в него метод String getName().
3. Создай классы Keyboard, Mouse, Monitor, которые реализуют интерфейс CompItem.
4. Метод getName() должен возвращать имя класса, например, для класса Keyboard будет «Keyboard«.
5. Создай класс Computer.
6. В класс Computer добавь приватное поле keyboard типа Keyboard.
7. В класс Computer добавь приватное поле mouse типа Mouse.
8. В класс Computer добавь приватное поле monitor типа Monitor.
9. Создай конструктор с тремя параметрами в классе Computer используя комбинацию клавиш Alt+Insert внутри класса (команда Constructor).
10 Внутри конструктора инициализируйте все три поля (переменных) класса в соответствии с переданными параметрами.
11. Создай геттеры для полей класса Computer (в классе используй комбинацию клавиш Alt+Insert и выбери команду Getter).
12. Все созданные классы и интерфейс должны быть в отдельных файлах.


Требования:
1. Интерфейс CompItem должен существовать в отдельном файле.
2. В интерфейсе CompItem должен быть объявлен метод getName() с типом возвращаемого значения String и без параметров.
3. Классы Keyboard, Monitor и Mouse должны реализовывать интерфейс CompItem, а также существовать в отдельных файлах.
4. Метод getName в классах реализующих интерфейс CompItem должен возвращать простое имя класса, например "Keyboard" для класса Keyboard.
5. Класс Computer должен содержать по одному приватному полю типа Keyboard, Mouse, Monitor, а также существовать в отдельном файле.
6. Конструктор класса Computer должен принимать 3 параметра(keyboard, mouse, monitor) и корректно инициализировать соответствующие поля класса.
7. Для полей keyboard, mouse и monitor Computer должны быть созданы геттеры(getKeyboard, getMouse, getMonitor), которые будут возвращать соответствующие поля класса Computer.

package com.javarush.task.task14.task1413;

* 
Computer
*

public class Solution {
    public static void main(String[] args) {
        Computer computer = new Computer(new Keyboard(), new Mouse(), new Monitor());
        if (isWork(computer.getKeyboard()) &&
                isWork(computer.getMonitor()) &&
                isWork(computer.getMouse())) {
            System.out.println("Work!");
        }
    }

    public static boolean isWork(CompItem item) {
        System.out.println(item.getName());
        return item.getName() != null && item.getName().length() > 4;
    }

}

*/
