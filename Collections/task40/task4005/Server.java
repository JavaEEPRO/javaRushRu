
//And the earth helped the woman, and the earth opened her mouth, and swallowed up the flood which the dragon cast out of his mouth. (Revelation 12:16)

package com.javarush.task.task40.task4005;

import java.net.ServerSocket;
import java.net.Socket;

/* 
Сокетный сервер и клиент
*/

public class Server {

    public static void main(String[] args) {
        int port = 4444;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (Connection connection = new Connection(socket)) {
                while (true) {
                    String message = connection.receive();

                    if (message.equals("exit"))
                        break;

                    System.out.println(message);

                    connection.send("Echo: " + message);
                }
            } catch (Exception e) {
            }
        }

    }
}

/*
Сокетный сервер и клиент

Есть сервер, он принимает входящие сообщения от клиентов и отвечает им echo.

Есть клиенты, они считывают сообщения с клавиатуры и отправляют их серверу.

Программа запускается, но не работает.

Разберись в чем проблема, внеси минимальные изменения в код, чтобы все заработало.





Требования:

1. Класс Client не изменяй.

2. Класс Server не изменяй.

3. Внеси необходимые изменения в класс Connection.

4. Поля в классе Connection не изменяй.
*/
