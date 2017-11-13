
//Jesus said to her, "Woman, what does that have to do with you and me? My hour has not yet come." (John 2:4)

package com.javarush.task.task30.task3008.client;

import java.io.IOException;
import java.net.Socket;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;
import com.javarush.task.task30.task3008.Connection;

public class Client extends Thread {
    protected Connection connection;
    private volatile boolean clientConnected;
    
    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
    
    public void run() {
        {
            SocketThread socketThread = getSocketThread();
            socketThread.setDaemon(true);
            socketThread.start();
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                ConsoleHelper.writeMessage("Thread error");
                System.exit(1);
            }
            if (clientConnected) {
                ConsoleHelper.writeMessage("Connection established. To quit, type 'exit'");
                while (clientConnected) {
                    String message = ConsoleHelper.readString();
                    if (message.equalsIgnoreCase("exit")) {
                        break;
                    } else {
                        if (shouldSendTextFromConsole()) {
                            sendTextMessage(message);
                        }
                    }
                }
            } else {
                ConsoleHelper.writeMessage("Error at client side");
            }
        }
    }
    
    protected String getServerAddress() {
        String serverAddress;
        ConsoleHelper.writeMessage("Enter server address: ");
        serverAddress = ConsoleHelper.readString();
        return serverAddress;
    }
    
    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port: ");
        return ConsoleHelper.readInt();
    }
    
    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter User name: ");
        return ConsoleHelper.readString();
    }
    
    protected boolean shouldSendTextFromConsole() {
        return true;
    }
    
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }
    
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Error, can't send your message...");
            clientConnected = false;
        }
    }
    
    public class SocketThread extends Thread {
        
        public void run() {
            String serverAddress = getServerAddress();
            int serverPort = getServerPort();
            try {
                Socket socket = new Socket(serverAddress,serverPort);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();

            } catch (IOException  | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
        
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }
        
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("User " + userName + " joined to chat");
        }
        
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("User " + userName + " has left this chat");
        }
        
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            synchronized (Client.this) {
                Client.this.clientConnected = clientConnected;
                Client.this.notify();
            }
        }
        
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            Message message;

            while (!clientConnected) {
                try {
                    message = connection.receive();
                } catch (ClassNotFoundException e) {
                    throw new IOException("Unexpected MessageType");
                }
                if (message.getType() == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else {
                    if (message.getType() == MessageType.NAME_ACCEPTED) {notifyConnectionStatusChanged(true);}
                    else throw new IOException("Unexpected MessageType");}

            }
        }
        
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            Message message;

            while (true) {

                try {
                    message = connection.receive();
                } catch (Exception e) {
                    break;
                }
                if (message.getType() == MessageType.TEXT) processIncomingMessage(message.getData());
                else {
                    if (message.getType() == MessageType.USER_ADDED) informAboutAddingNewUser(message.getData());
                    else {
                        if (message.getType() == MessageType.USER_REMOVED) informAboutDeletingNewUser(message.getData());
                        else break;
                    }
                }

            }
            throw new IOException("Unexpected MessageType");

        }
    } 
}

/*
Чат (22)
Итак, подведем итог:
• Ты написал сервер для обмена текстовыми сообщениями.
• Ты написал консольный клиент, который умеет подключаться к серверу и
обмениваться сообщениями с другими участниками.
• Ты написал бот клиента, который может принимать запросы и отправлять данные о
текущей дате и времени.
• Ты написал клиента для чата с графическим интерфейсом.

Что можно добавить или улучшить:
• Можно добавить поддержку приватных сообщений (когда сообщение отправляется не
всем, а какому-то конкретному участнику).
• Можно расширить возможности бота, попробовать научить его отвечать на
простейшие вопросы или время от времени отправлять шутки.
• Добавить возможность пересылки файлов между пользователями.
• Добавить контекстное меню в графический клиент, например, для отправки
приватного сообщения кому-то из списка участников.
• Добавить раскраску сообщений в графическом клиенте в зависимости от отправителя.
• Добавить блокировку сервером участников за что-либо, например, ненормативную
лексику в сообщениях.
• Добавить еще миллион фич и полезностей!

Ты научился:
• Работать с сокетами.
• Пользоваться сериализацией и десериализацией.
• Создавать многопоточные приложения, синхронизировать их, применять модификатор
volatile, пользоваться классами из библиотеки java.util.concurrent.
• Применять паттерн MVC.
• Использовать внутренние и вложенные классы.
• Работать с библиотекой Swing.
• Применять классы Calendar и SimpleDateFormat.

Так держать!


Требования:
1. Поздравляю, чат готов!
Чат (21)
У меня есть отличнейшая новость для тебя. Компонент представление (View) уже готов. Я добавил класс ClientGuiView. Он использует библиотеку javax.swing. Ты должен как следует разобраться в каждой строчке этого класса. Если тебе все понятно – это замечательно, если нет – обязательно найди ответы на свои вопросы с помощью дебага, документации или поиска в Интернет.

Осталось написать компонент контроллер (Controller):
1. Создай класс ClientGuiController унаследованный от Client.
2. Создай и инициализируй поле, отвечающее за модель ClientGuiModel model.
3. Создай и инициализируй поле, отвечающее за представление ClientGuiView view. Подумай, что нужно передать в конструктор при инициализации объекта.
4. Добавь внутренний класс GuiSocketThread унаследованный от SocketThread. Класс GuiSocketThread должен быть публичным. В нем переопредели следующие методы:
а) void processIncomingMessage(String message) – должен устанавливать новое сообщение у модели и вызывать обновление вывода сообщений у представления.
б) void informAboutAddingNewUser(String userName) – должен добавлять нового пользователя в модель и вызывать обновление вывода пользователей у отображения.
в) void informAboutDeletingNewUser(String userName) – должен удалять пользователя из модели и вызывать обновление вывода пользователей у отображения.
г) void notifyConnectionStatusChanged(boolean clientConnected) – должен вызывать аналогичный метод у представления.
5. Переопредели методы в классе ClientGuiController:
а) SocketThread getSocketThread() – должен создавать и возвращать объект типа GuiSocketThread.
б) void run() – должен получать объект SocketThread через метод getSocketThread() и вызывать у него метод run(). Разберись, почему нет необходимости вызывать метод run в отдельном потоке, как мы это делали для консольного клиента.
в) getServerAddress(), getServerPort(), getUserName(). Они должны вызывать одноименные методы из представления (view).
6. Реализуй метод ClientGuiModel getModel(), который должен возвращать модель.
7. Реализуй метод main(), который должен создавать новый объект ClientGuiController и вызывать у него метод run().
Запусти клиента с графическим окном, нескольких консольных клиентов и убедись, что
все работает корректно.

Чат (20)
Консольный клиент мы уже реализовали, чат бота тоже сделали, почему бы не сделать клиента с графическим интерфейсом? Он будет так же работать с нашим сервером, но иметь графическое окно, кнопки и т.д.
Итак, приступим. При написании графического клиента будет очень уместно воспользоваться паттерном MVC (Model-View-Controller). Ты уже должен был с ним сталкиваться, если необходимо, освежи свои знания про MVC с помощью Интернет. В нашей задаче самая простая реализация будет у класса, отвечающего за модель (Model).

Давай напишем его:
1) Создай класс ClientGuiModel в пакете client. Все классы клиента должны быть созданы в этом пакете.
2) Добавь в него множество(set) строк в качестве final поля allUserNames. В нем будет храниться список всех участников чата. Проинициализируй его.
3) Добавь поле String newMessage, в котором будет храниться новое сообщение, которое получил клиент.
4) Добавь геттер для allUserNames, запретив модифицировать возвращенное множество. Разберись, как это можно сделать с помощью метода класса Collections.
5) Добавь сеттер и геттер для поля newMessage.
6) Добавь метод void addUser(String newUserName), который должен добавлять имя участника во множество, хранящее всех участников.
7) Добавь метод void deleteUser(String userName), который будет удалять имя участника из множества.

Чат (19)
Сейчас будем реализовывать класс BotSocketThread, вернее переопределять некоторые его методы, весь основной функционал он уже унаследовал от SocketThread.

1. Переопредели метод clientMainLoop():
а) С помощью метода sendTextMessage() отправь сообщение с текстом «Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.»
б) Вызови реализацию clientMainLoop() родительского класса.
2. Переопредели метод processIncomingMessage(String message). Он должен следующим образом обрабатывать входящие сообщения:
а) Вывести в консоль текст полученного сообщения message.
б) Получить из message имя отправителя и текст сообщения. Они разделены «: «.
в) Отправить ответ в зависимости от текста принятого сообщения.
Если текст сообщения:
«дата» – отправить сообщение содержащее текущую дату в формате «d.MM.YYYY«;
«день» – в формате «d«;
«месяц» — «MMMM«;
«год» — «YYYY«;
«время» — «H:mm:ss«;
«час» — «H«;
«минуты» — «m«;
«секунды» — «s«.
Указанный выше формат используй для создания объекта SimpleDateFormat. Для получения текущей даты необходимо использовать класс Calendar и метод getTime().
Ответ должен содержать имя клиента, который прислал запрос и ожидает ответ, например, если Боб отправил запрос «время«, мы должны отправить ответ «Информация для Боб: 12:30:47«.
Наш бот готов. Запусти сервер, запусти бота, обычного клиента и убедись, что все работает правильно.
Помни, что message бывают разных типов и не всегда содержат «:«

Чат (18)
Иногда бывают моменты, что не находится достойного собеседника. Не общаться же с самим собой :). Давай напишем бота, который будет представлять собой клиента, который автоматически будет отвечать на некоторые команды. Проще всего реализовать бота, который сможет отправлять текущее время или дату, когда его кто-то об этом попросит.

С него и начнем:
1) Создай новый класс BotClient в пакете client. Он должен быть унаследован от Client.
2) В классе BotClient создай внутренний класс BotSocketThread унаследованный от SocketThread. Класс BotSocketThread должен быть публичным.
3) Переопредели методы:
а) getSocketThread(). Он должен создавать и возвращать объект класса BotSocketThread.
б) shouldSendTextFromConsole(). Он должен всегда возвращать false. Мы не хотим, чтобы бот отправлял текст введенный в консоль.
в) getUserName(), метод должен генерировать новое имя бота, например: date_bot_X, где X – любое число от 0 до 99. Для генерации X используй метод Math.random().
4) Добавь метод main. Он должен создавать новый объект BotClient и вызывать у него метод run().

Чат (17)
Последний, но самый главный метод класса SocketThread – это метод void run(). Добавь его. Его реализация с учетом уже созданных методов выглядит очень просто.

Давай напишем ее:
1) Запроси адрес и порт сервера с помощью методов getServerAddress() и getServerPort().
2) Создай новый объект класса java.net.Socket, используя данные, полученные в предыдущем пункте.
3) Создай объект класса Connection, используя сокет из п.17.2.
4) Вызови метод, реализующий «рукопожатие» клиента с сервером (clientHandshake()).
5) Вызови метод, реализующий основной цикл обработки сообщений сервера.
6) При возникновении исключений IOException или ClassNotFoundException сообщи главному потоку о проблеме, используя notifyConnectionStatusChanged и false в качестве параметра.

Клиент готов, можешь запустить сервер, несколько клиентов и проверить как все работает.
*/
