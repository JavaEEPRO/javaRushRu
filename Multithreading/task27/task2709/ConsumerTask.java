
//Do you not know that the saints shall judge the world? and if the world shall be judged by you, are you unworthy to judge the smallest matters? (1Cor 6:2)

package com.javarush.task.task27.task2709;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        synchronized (transferObject){
            while (!stopped) {
                transferObject.get();
            }
        }
    }

    public void stop() {
        stopped = true;
    }
}

/*
Producer–consumer
В классе TransferObject расставь вызовы методов wait/notify/notifyAll, чтобы обеспечить последовательное создание и получение объекта.
В методах run классов ConsumerTask и ProducerTask создай необходимые synchronized блоки.

Ожидаемый вывод:
...
Put: M
Got: M
Put: N
Got: N
Put: K
Got: K
...
где M, N, K — числа
Метод main не участвует в тестировании

P.S. Всегда старайся использовать concurrent коллекции вместо ручной реализации wait/notify/notifyAll.
Задачи подобные этой позволяют лучше понять основы работы многопоточных приложений.


Требования:
1. В методе run класса ConsumerTask должен содержаться synchronized блок, монитор - transferObject.
2. В методе run класса ProducerTask должен содержаться synchronized блок, монитор - transferObject.
3. Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно появится.
4. Метод put класса TransferObject должен ждать пока value заберут и обновлять его значение после того, как оно пропадет.
5. Метод get класса TransferObject должен устанавливать флаг isValuePresent в false и уведомлять другие нити ожидающие освобождения монитора перед возвратом значение поля value.
6. Метод put класса TransferObject должен устанавливать флаг isValuePresent в true и уведомлять другие нити ожидающие освобождения монитора после обновления значение поля value.
*/
