
//For the Father himself loveth you, because ye have loved me, and have believed that I came out from God. (John 16:27)

package com.javarush.task.task32.task3205;

public interface SomeInterfaceWithMethods {
    void voidMethodWithoutArgs();

    String stringMethodWithoutArgs();

    void voidMethodWithIntArg(int i);
}

/*
Создание прокси-объекта

1) В отдельном файле создай публичный класс CustomInvocationHandler, который будет хэндлером при создании прокси-объекта.

2) CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.

3) CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.

4) Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].

5) После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].

6) Реализуй логику метода getProxy, который должен создавать прокси (Proxy.newProxyInstance(...)).

См. пример вывода в методе main.

Метод main не участвует в тестировании.





Требования:

1. Класс CustomInvocationHandler должен существовать.

2. Класс CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.

3. Класс CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.

4. Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].

5. После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].

6. Метод getProxy должен создавать прокси для интерфейса SomeInterfaceWithMethods.
*/
