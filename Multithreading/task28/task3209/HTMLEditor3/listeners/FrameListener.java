
//There will be no curse any more. The throne of God and of the Lamb will be in it, and his servants serve him. (Revelation 22:3)

package com.javarush.task.task32.task3209.listeners;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.javarush.task.task32.task3209.View;

public class FrameListener extends WindowAdapter {

    private View view;

    public FrameListener(View view) {
        this.view = view;
    }

    public void windowClosing(WindowEvent windowEvent) {
        view.exit();
    }
}

/*
HTML Editor (3)
Графический интерфейс будет представлять собой окно, в котором будет меню и панель с
двумя вкладками.
На первой вкладке будет располагаться текстовая панель, которая будет отрисовывать html страницу. На ней можно будет форматировать и редактировать текст страницы.
На второй вкладке будет редактор, который будет отображать код html страницы, в нем будут видны все используемые html теги. В нем также можно будет менять текст страницы, добавлять и удалять различные теги.
3.1. Добавь и проинициализируй поля в классе представления:
3.1.1. JTabbedPane tabbedPane - это будет панель с двумя вкладками.
3.1.2. JTextPane htmlTextPane - это будет компонент для визуального редактирования html.
Он будет размещен на первой вкладке.
3.1.3. JEditorPane plainTextPane - это будет компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое).
3.2. Добавь класс FrameListener в пакет listeners. Он должен:
3.2.1. Быть унаследован от WindowAdapter.
3.2.2. Иметь поле View view.
3.2.3. В конструкторе принимать View и инициализировать внутреннее поле.
3.2.4. Иметь переопределенный метод windowClosing(WindowEvent windowEvent), который должен вызывать exit() у представления.


Требования:
1. Класс View должен содержать приватное проинициализированое поле JTabbedPane tabbedPane.
2. Класс View должен содержать приватное проинициализированое поле JTextPane htmlTextPane.
3. Класс View должен содержать приватное проинициализированое поле JEditorPane plainTextPane.
4. Класс FrameListener должен быть создан в отдельном файле.
5. Класс FrameListener должен содержать приватное поле View view.
6. Класс FrameListener должен должен содержать конструктор с одним параметром, инициализирующий поле view.
7. В классе FrameListenerМетод должен быть метод windowClosing(WindowEvent windowEvent).
*/
