
//On the next day, he was determined to go out into Galilee, and he found Philip. Jesus said to him, "Follow me." (John 1:43)

package com.javarush.task.task35.task3513;

public class MoveEfficiency implements Comparable {

    private int numberOfEmptyTiles;
    private int score;

    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }


    public int compareTo(MoveEfficiency that) {

        if (this == that) return 0;

        if (this.numberOfEmptyTiles > that.numberOfEmptyTiles) return 1;
        if (this.numberOfEmptyTiles < that.numberOfEmptyTiles) return -1;

        if (this.numberOfEmptyTiles == that.numberOfEmptyTiles) {
            if (this.score > that.score) return 1;
            if (this.score < that.score) return -1;
        }
        return 0;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

/*
2048 (15)

Для того, чтобы эффективности различных ходов можно было сравнивать, необходимо реализовать в классе MoveEfficiency поддержку интерфейса Comparable.



В методе compareTo первым делом сравни количество пустых плиток (numberOfEmptyTiles), потом счет (score), если количество пустых плиток равное. Если и счет окажется равным, будем считать эффективность ходов равной и вернем ноль.



Далее перейдем в класс Model и реализуем два метода:

1) boolean hasBoardChanged - будет возвращать true, в случае, если вес плиток в массиве gameTiles отличается от веса плиток в верхнем массиве стека previousStates. Обрати внимание на то, что мы не должны удалять из стека верхний элемент, используй метод peek.

2) MoveEfficiency getMoveEfficiency(Move move) - принимает один параметр типа move, и возвращает объект типа MoveEfficiency описывающий эффективность переданного хода. Несколько советов:

а) не забудь вызывать метод rollback, чтобы восстановить корректное игровое состояние;

б) в случае, если ход не меняет состояние игрового поля, количество пустых плиток и счет у объекта MoveEfficiency сделай равными -1 и 0 соответственно;

в) выполнить ход можно вызвав метод move на объекте полученном в качестве параметра.





Требования:

1. Класс MoveEfficiency должен поддерживать интерфейс Comparable.

2. Метод compareTo должен корректно сравнивать два объекта типа MoveEfficiency.

3. Метод hasBoardChanged должен быть реализован в соответствии с условием задачи.

4. Метод getMoveEfficiency должен возвращать эффективность хода полученного в качестве параметра.

5. Если ход, переданный в метод getMoveEfficiency не меняет игровое поле, должен быть возвращен объект с количеством пустых клеток равным -1.

6. Метод getMoveEfficiency не должен менять вес плиток в массиве gameTiles и счет.


*/
