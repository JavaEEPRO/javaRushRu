
//So then the other disciple who came first to the tomb also entered in, and he saw and believed. (John 20:8)

package com.javarush.task.task23.task2301;

/* 
Запрети наследование
*/
public class Solution {

    public static final class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}
/*
Запрети наследование
Запрети наследование от класса Listener.


Требования:
1. Класс Listener должен быть создан внутри класса Solution.
2. Класс Listener должен быть публичным.
3. Класс Listener должен быть статическим.
4. Должна быть запрещена возможность стать потомком класса Listener.

package com.javarush.task.task23.task2301;

* 
Запрети наследование
*
public class Solution {

    public static class Listener {
        public void onMouseDown(int x, int y) {
            //do something on mouse down event
        }

        public void onMouseUp(int x, int y) {
            //do something on mouse up event
        }
    }

    public static void main(String[] args) {

    }
}
*/
