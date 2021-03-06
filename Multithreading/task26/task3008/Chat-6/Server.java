
//I write not these things to shame you, but as my beloved sons I warn you. (1Cor 4:14)

package com.javarush.task.task30.task3008;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ConsoleHelper.writeMessage("Please, input server port: ");
        try (ServerSocket serverSocket = new ServerSocket(ConsoleHelper.readInt())) {
            ConsoleHelper.writeMessage("Server starting...");
            while (true) {
                new Handler(serverSocket.accept()).start();
            }
        } catch (Exception e) {
            ConsoleHelper.writeMessage("Error, server socket was closed.");
        }
    }
    
    private static class Handler extends Thread {
        private Socket socket;
        
        public Handler(Socket socket) {
            this.socket = socket;
        }
    }
}

/*
Чат (6)
Приступим к самому важному – написанию класса Server. Сервер должен поддерживать

множество соединений с разными клиентами одновременно. Это можно реализовать с

помощью следующего алгоритма:

- Сервер создает серверное сокетное соединение.

- В цикле ожидает, когда какой-то клиент подключится к сокету.

- Создает новый поток обработчик Handler, в котором будет происходить обмен

сообщениями с клиентом.

- Ожидает следующее соединение.

Добавь:

1)	В класс Server приватный статический вложенный класс Handler, унаследованный от

Thread.

2)	В класс Handler поле socket типа Socket.

3)	В класс Handler конструктор, принимающий в качестве параметра Socket и

инициализирующий им соответствующее поле класса.

4)	Метод main класса Server, должен:

а) Запрашивать порт сервера, используя ConsoleHelper.

б) Создавать серверный сокет java.net.ServerSocket, используя порт из предыдущего пункта.

в) Выводить сообщение, что сервер запущен.

г) В бесконечном цикле слушать и принимать входящие сокетные соединения только что созданного

серверного сокета.

д) Создавать и запускать новый поток Handler, передавая в конструктор сокет из предыдущего пункта.

е) После создания потока обработчика Handler переходить на новый шаг цикла.

ж) Предусмотреть закрытие серверного сокета в случае возникновения исключения.

з) Если исключение Exception все же произошло, поймать его и вывести сообщение

об ошибке.


Требования:
1. В классе Server должен быть создан приватный статический класс Handler, унаследованный от класса Thread.
2. В классе Handler должно быть создано поле socket типа Socket.
3. Конструктор класса Handler должен принимать один параметр типа Socket и инициализировать поле socket.
4. Метод main должен считывать с клавиатуры порт сервера используя метод readInt класса ConsoleHelper.
5. Метод main должен корректно реализовывать бесконечный цикл описанный в условии задачи.
*/
