
//Jesus said to him, "Because you have seen me, you have believed. Blessed are those who have not seen, and have believed." (John 20:29)

-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;

import java.util.*;

public class Arkanoid {
    private int width, height;
    
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    
    public static Arkanoid game;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void move() {}
    public void run() {}
    
    public Ball getBall() {
        return ball;
    }
    public Stand getStand() {
        return stand;
    }
    public List<Brick> getBricks() {
        return bricks;
    }
    
    public void setBall(Ball newBall) {
        this.ball = newBall;
    }
    public void setStand(Stand newStand) {
        this.stand = newStand;
    }
    public void setBricks(List<Brick> newBricks) {
        this.bricks = newBricks;
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------BaseObject.java----------------------------------------------------------------
package com.javarush.task.task24.task2413;


public abstract class BaseObject {
    
    private double x;
    private double y;
    
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    abstract void draw(Canvas canvas);
    abstract void move();
    boolean isIntersec(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;   
    }
    
    public void setX(double newX) {
        this.x = newX;
    }
    public void setY(double newY) {
        this.y = newY;
    }
    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Canvas.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Canvas {
    private int width, height;
    private char[][] matrix;
    
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height+2][width+2];
    }
    
    public void setPoint(double x, double y, char c) {
        int x0 = (int) Math.round(x);
        int y0 = (int) Math.round(y);
        if (y0 < 0 || y0 >= matrix.length) return;
        if (x0 < 0 || x0 >= matrix[y0].length) return;

        matrix[y0][x0] = c;
    }    
    
    public void drawMatrix(double x, double y, int[][] matrix, char c) {
        int height = matrix.length;
        int width = matrix[0].length;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (matrix[i][j] == 1)
                    setPoint(x + j, y + i, c);
            }
        }
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public char[][] getMatrix() {
        return matrix;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public void setMatrix(char[][] newMatrix) {
        this.matrix = newMatrix;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball extends BaseObject {
    
    
    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }
    
    public void draw(Canvas canvas) {}
    public void move() {}
    
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick extends BaseObject {
    
    public Brick(double x, double y, double radius) {
        super(x, y, radius);
    }
    public void draw(Canvas canvas) {}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand extends BaseObject {
    
    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }
    public void draw(Canvas canvas) {}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------

/*
Арканоид(10)
Что мы будем делать с Canvas?
Мы будем рисовать на нем (в его матрице).
Поэтому нам понадобятся два метода
void setPoint(double x, double y, char c)
void drawMatrix(double x, double y, int[][] matrix, char c)

Первый метод — setPoint будет «ставить точку в координатах x,y цветом c«.

В методе надо:
а) округлить x и y до целых чисел
б) занести в matrix[y][x] значение с
в) ничего не делать, если x < 0 или y < 0 или y > matrix.length или x > matrix[0].length

Второй метод — drawMatrix копирует переданную ему картинку (матрицу) в матрицу Canvas.
И не просто копирует, а начиная с координат x, y

В методе надо:
а) с помощью двух вложенных циклов пройтись по всем ячейкам переданной картинки
б) если значение ячейки элемента [i][j] полученной матрицы не равно 0, то покрасить в матрице объекта Canvas точку (x+j, y+i) в цвет c:
setPoint(x+j, y+i, c)


Требования:
1. В классе Canvas должен быть создан метод void setPoint(double x, double y, char c).
2. В классе Canvas должен быть создан метод void drawMatrix(double x, double y, int[][] matrix, char c).
3. Поведение метода setPoint должно соответствовать условию задачи.
4. Поведение метода drawMatrix должно соответствовать условию задачи.

Арканоид(9)
Теперь займемся классом Canvas.
Он у нас будет содержать матрицу (двумерный массив), куда мы будем «рисовать«.
У матрицы есть ширина и высота.
А еще будем в ней хранить не числа (int), а символы (char).

Надо:
а) Добавить в класс два приватных поля width и height.
б) Добавить в класс приватное поле matrix (char[][]).
в) Добавить конструктор с двумя параметрами типа int (width и height), поле matrix должно быть инициализировано пустым массивом размерностью [height+2][width+2].
г) Добавить геттеры и сеттеры для всех приватных полей класса.


Требования:
1. В классе Canvas должно быть создано приватное поле width типа int.
2. В классе Canvas должно быть создано приватное поле height типа int.
3. В классе Canvas должно быть создано приватное поле matrix типа char[].
4. В классе Canvas должен быть создан публичный геттер для поля width.
5. В классе Canvas должен быть создан публичный геттер для поля height.
6. В классе Canvas должен быть создан публичный геттер для поля matrix.
7. В классе Canvas должен быть создан публичный сеттер для поля width.
8. В классе Canvas должен быть создан публичный сеттер для поля height.
9. В классе Canvas должен быть создан публичный сеттер для поля matrix.
10. В классе Canvas должен быть создан корректный публичный конструктор с двумя параметрами типа int (width и height).

Арканоид(8)
Но и это еще не все.
Классу BaseObject нужны еще методы.
Пока это будут пустые методы draw(Canvas canvas) и move().
Классы-наследники должны будут переопределить их у себя и реализовать необходимую функциональность (пока можешь оставить их пустыми, просто чтобы код компилировался).
Объяви эти методы, но сделай их абстрактными.
Также сделай абстрактным сам класс BaseObject.

А еще нам нужно будет определять попал шарик в кирпич или в подставку.
Это будем делать так:
В этом же классе, создадим специальный метод: boolean isIntersec(BaseObject o)
Он будет определять — «пересеклись» объекты или нет. Если пересеклись — возвращать true, если нет — false.

Т.к. объекты мы условно считаем кругами, то предлагаю такую формулу взаимодействия
Если центр круга одного объекта попал в круг другого, то будем считать, что они столкнулись.

Или еще проще:
дистанция_между_объектами <= max (радиус_первого_объекта, радиус_второго_объекта)

Арканоид(7)
Теперь перейдем к классу BaseObject.
Я хочу сделать несколько предложений.

Во-первых для простоты считать все объекты у нас будут круглыми.
Нет, отрисовывать их мы будем фигурными, как и раньше.
А вот при расчетах из взаимодействия исходить из того, что они круглые.
Так — гораздо проще.

Во-вторых. Пусть координаты объектов и радиус будут вещественными числами.
Это придаст плавность движениям и точность всем вычислениям.
А при отрисовке мы будем их округлять.

Итак:
а) Добавь в класс BaseObject приватные поля x (double), y (double), radius (double).
б) Добавь геттеры и сеттеры.
в) Добавь конструктор BaseObject(double x, double y, double radius).
г) Пройдись по все классам-наследникам и поправь у них конструкторы.

Если вы пользуйтесь Intellij IDEA — Alt+Insert вам в помощь.

Арканоид(6)
У нас будут «кирпичи«, «шарик» и «подставка» и у них будет много общего.
Они будут перемещаться по полю и отрисовываться.
Значит у них у всех будут координаты и размер.
А еще методы move() — для перемещения и draw() для отрисовки.

Есть интересное предложение: давай введем один базовый класс для все объектов.
Пусть это будет класс BaseObject.
А классы Ball, Stand, Brick от него наследуются.

Создай класс BaseObject и добавь его родителем к классам Ball, Stand, Brick

Еще нам понадобится класс Canvas
Он будет ответственным за «отрисовку» объектов.
С помощью его они будут отрисовывать себя.
Вернее даже на нем, но детали я сообщу позднее.

Создай и этот класс.

Арканоид(5)
Чего еще не хватает классу Arkanoid?
Во-первых ему нужен метод run(), в котором будет описана основная логика программы.
Еще нужен метод move() — который будет двигать на один шаг все объекты требующие движения.
Создай методы run() и move().

Еще нам понадобится НЕ приватная статическая переменная game типа Arkanoid, которая будет хранить ссылку на созданный экземпляр класса Arkanoid.

Выглядеть это должно примерно так:
static Arkanoid game;

Арканоид(4)
Также классу Arkanoid нужно будет хранить ссылку на шарик (Ball), «подставку» Stand и список «кирпичей«.

Надо:
а) создать в классе Arkanoid два private поля: ball типа Ball и stand типа Stand
б) добавить private поле bricks типа List<Brick>
в) добавь для них публичные геттеры и сеттеры
-----------------------------------------------Arkanoid.java------------------------------------------------------------------
package com.javarush.task.task24.task2413;

import java.util.*;

public class Arkanoid {
    private int width, height;
    
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    
    public static Arkanoid game;
    
    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }
    
    public void move() {}
    public void run() {}
    
    public Ball getBall() {
        return ball;
    }
    public Stand getStand() {
        return stand;
    }
    public List<Brick> getBricks() {
        return bricks;
    }
    
    public void setBall(Ball newBall) {
        this.ball = newBall;
    }
    public void setStand(Stand newStand) {
        this.stand = newStand;
    }
    public void setBricks(List<Brick> newBricks) {
        this.bricks = newBricks;
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public static void main(String[] args) {}
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------BaseObject.java----------------------------------------------------------------
package com.javarush.task.task24.task2413;


public abstract class BaseObject {
    
    private double x;
    private double y;
    
    private double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    abstract void draw(Canvas canvas);
    abstract void move();
    boolean isIntersec(BaseObject o) {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
    
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getRadius() {
        return radius;   
    }
    
    public void setX(double newX) {
        this.x = newX;
    }
    public void setY(double newY) {
        this.y = newY;
    }
    public void setRadius(double newRadius) {
        this.radius = newRadius;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Canvas.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Canvas {
    private int width, height;
    private char[][] matrix;
    
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height+2][width+2];
    }
    
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    public char[][] getMatrix() {
        return matrix;
    }
    
    public void setWidth(int newWidth) {
        this.width = newWidth;
    }
    public void setHeight(int newHeight) {
        this.height = newHeight;
    }
    public void setMatrix(char[][] newMatrix) {
        this.matrix = newMatrix;
    }
}
------------------------------------------------------------------------------------------------------------------------------


-----------------------------------------------Ball.java----------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Ball extends BaseObject {
    
    
    public Ball(double x, double y, double radius) {
        super(x, y, radius);
    }
    
    public void draw(Canvas canvas) {}
    public void move() {}
    
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Brick.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Brick extends BaseObject {
    
    public Brick(double x, double y, double radius) {
        super(x, y, radius);
    }
    public void draw(Canvas canvas) {}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------


------------------------------------------------Stand.java--------------------------------------------------------------------
package com.javarush.task.task24.task2413;


public class Stand extends BaseObject {
    
    public Stand(double x, double y, double radius) {
        super(x, y, radius);
    }
    public void draw(Canvas canvas) {}
    public void move() {}
}
------------------------------------------------------------------------------------------------------------------------------
*/
