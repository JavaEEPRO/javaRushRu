
//Neither repented they of their murders, nor of their sorceries, nor of their fornication, nor of their thefts. (Revelation 9:21)

package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private TransferQueue<ShareItem> queue;
    @Override
    public void run() {
        try {
            for (int i = 1; i < 10; i++) {
                if (Thread.currentThread().isInterrupted()) break;

                System.out.format("Элемент 'ShareItem-%s' добавлен%n", i);
                this.queue.offer(new ShareItem("ShareItem-" + i, i));
                Thread.sleep(100);

                if (this.queue.hasWaitingConsumer()) System.out.format("Consumer в ожидании!%n");

            }
        } catch (Exception e) {
        }
    }

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }
}

/*
Экономим время

1. Создай Producer и Consumer (См. комментарий к методу main).

2. Создай методы toString, equals и hashCode в классе ShareItem. Для этого в IntelliJ IDEA в теле класса ShareItem выполни:

2.1. Alt+Enter -> toString() -> Enter.

2.2. Alt+Enter -> equals() and hashCode() -> click all 'Next'-s.

2.3. Реализацию методов toString(), equals() и hashCode() оставь такими, какими их сгенерировала IntelliJ IDEA.

3. В Producer и Consumer реализуй метод run так, чтобы вызов метода interrupt прерывал работу consumer и producer трэдов.



4. Реализация метода run для Producer:

4.1. Используя метод offer добавь в очередь 9 ShareItem-ов с такими параметрами: ("ShareItem-N", N), где N - номер элемента от 1 до 9.

4.2. Перед каждым добавлением выведи фразу "Элемент 'ShareItem-N' добавлен". Используй System.out.format.

4.3. Усыпи трэд на 0.1 секунды.

4.4. Если у очереди есть Consumer, не занятый работой, то выведи фразу "Consumer в ожидании!".

Просмотри методы интерфейса TransferQueue, там есть нужный метод.



5. Реализация метода run для Consumer:

5.1. Усыпи трэд на 0.45 секунды.

5.2. В бесконечном цикле забери элемент из очереди методом take и выведи в консоль "Processing item.toString()".



6. Сверь вывод с файлом output.txt.

7. Стек-трейс не выводи в консоль.

8. Для вывода любой информации на экран используй System.out.format.





Требования:

1. Создай класс Producer.

2. Создай класс Consumer.

3. В классе ShareItem должны быть созданы методы: toString(), equals(Object) и hashCode().

4. Метод run() класса Producer должен быть реализован согласно условию задачи.

5. Метод run() класса Consumer должен быть реализован согласно условию задачи.

6. Вывод должен совпадать с файлом output.txt.
*/
