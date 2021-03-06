
//And hath made us kings and priests unto God and his Father; to him [be] glory and dominion for ever and ever. Amen. (Revelation 1:6)

package com.javarush.task.task25.task2515;

public class SpaceShip extends BaseObject {

    private double dx = 0;

    public SpaceShip(double x, double y) {
        super(x, y, 3);
    }

    public void moveLeft() {
        dx = -1;
    }

    public void moveRight() {
        dx = 1;
    }
}

/*
Space (12)

Теперь займемся кораблем.

Для сложности сделаем так: если пользователь нажал кнопку влево, то корабль начинает все время двигаться влево.

Если нажал кнопку вправо - все время в право до упора.

Поэтому заведем специальную переменную dx, которая будет хранить направление движения корабля.

если dx = 1, корабль каждый ход идет на 1 вправо,

если dx = -1, корабль каждый ход идет на 1 влево.



Надо:

а) добавь конструктор, можно такой:

Радиус корабля будет равен 3. Корабль большой - это вам не ракета и не бомба.

public SpaceShip(double x, double y)

{

super(x, y, 3);

}

б) добавь в класс SpaceShip переменную dx (double, по умолчанию равна 0);

в) метод moveLeft(), устанавливает dx равной -1;

г) метод moveRight(), устанавливает dx равной 1.





Требования:

1. В классе SpaceShip конструктор должен принимать координаты x и y, а радиус выставлять всегда равный 3.

2. В классе SpaceShip добавь поле dx (double).

3. В классе SpaceShip напиши метод moveLeft(), который устанавливает поле dx равным -1.

4. В классе SpaceShip напиши метод moveRight(), который устанавливает поле dx равным 1.
*/
