
//And found in the temple those that sold oxen and sheep and doves, and the changers of money sitting (John 2:14)

package com.javarush.task.task39.task3913.query;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.util.Date;
import java.util.Set;

public interface IPQuery {
    int getNumberOfUniqueIPs(Date after, Date before);

    Set<String> getUniqueIPs(Date after, Date before);

    Set<String> getIPsForUser(String user, Date after, Date before);

    Set<String> getIPsForEvent(Event event, Date after, Date before);

    Set<String> getIPsForStatus(Status status, Date after, Date before);
}

/*
Парсер логов (1)

Сегодня мы напишем парсер логов.



Лог файл имеет следующий формат:

ip username date event status



Где:

ip - ip адрес с которого пользователь произвел событие.

user - имя пользователя (одно или несколько слов разделенные пробелами).

date - дата события в формате day.month.year hour:minute:second.

event - одно из событий:

LOGIN - пользователь залогинился,

DOWNLOAD_PLUGIN - пользователь скачал плагин,

WRITE_MESSAGE - пользователь отправил сообщение,

SOLVE_TASK - пользователь попытался решить задачу,

DONE_TASK - пользователь решил задачу.

Для событий SOLVE_TASK и DONE_TASK существует дополнительный параметр,

который указывается через пробел, это номер задачи.

status - статус:

OK - событие выполнилось успешно,

FAILED - событие не выполнилось,

ERROR - произошла ошибка.



Пример строки из лог файла:

"146.34.15.5 Eduard Petrovich Morozko 05.01.2021 20:22:55 DONE_TASK 48 FAILED".

Записи внутри лог файла не обязательно упорядочены по дате, события могли произойти и быть записаны в лог в разной последовательности.



Класс, который будет отвечать за парсинг логов называется LogParser.

1.1. Добавь в класс LogParser конструктор с параметром Path logDir, где logDir - директория с логами (логов может быть несколько, все они должны иметь расширение log).

1.2. Реализуй интерфейс IPQuery у класса LogParser:

1.2.1. Метод getNumberOfUniqueIPs(Date after, Date before) должен возвращать количество уникальных IP адресов за выбранный период. Здесь и далее, если в методе есть параметры Date after и Date before, то нужно возвратить данные касающиеся только данного периода (включая даты after и before).

Если параметр after равен null, то нужно обработать все записи, у которых дата меньше или равна before.

Если параметр before равен null, то нужно обработать все записи, у которых дата больше или равна after.

Если и after, и before равны null, то нужно обработать абсолютно все записи (без фильтрации по дате).

1.2.2. Метод getUniqueIPs() должен возвращать множество, содержащее все не повторяющиеся IP. Тип в котором будем хранить IP будет String.

1.2.3. Метод getIPsForUser() должен возвращать IP, с которых работал переданный пользователь.

1.2.4. Метод getIPsForEvent() должен возвращать IP, с которых было произведено переданное событие.

1.2.5. Метод getIPsForStatus() должен возвращать IP, события с которых закончилось переданным статусом.



Реализацию метода main() можешь менять по своему усмотрению.





Требования:

1. В классе LogParser должен быть создан конструктор с одним параметром Path logDir.

2. Класс LogParser должен поддерживать интерфейс IPQuery.

3. Метод getNumberOfUniqueIPs(Date, Date) должен возвращать количество уникальных IP адресов за выбранный период.

4. Метод getUniqueIPs(Date, Date) класса LogParser должен возвращать множество, содержащее все не повторяющиеся IP адреса за выбранный период.

5. Метод getIPsForUser(String, Date, Date) класса LogParser должен возвращать IP адреса, с которых работал переданный пользователь за выбранный период.

6. Метод getIPsForEvent(Event, Date, Date) класса LogParser должен возвращать IP адреса, с которых было произведено переданное событие за выбранный период.

7. Метод getIPsForStatus(Status, Date, Date) класса LogParser должен возвращать IP адреса, события с которых закончилось переданным статусом за выбранный период.
*/
