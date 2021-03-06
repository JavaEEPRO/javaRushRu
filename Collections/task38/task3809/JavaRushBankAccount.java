
//Nicodemus saith unto him, How can a man be born when he is old? can he enter the second time into his mother's womb, and be born? (John 3:4)

package com.javarush.task.task38.task3809;

public class JavaRushBankAccount {
    private String ownerName;

    @LongPositive
    private long amount;

    public JavaRushBankAccount(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}

/*
Annotation + Reflection

Разберись в коде и исправьте ошибку.

Ориентируйся на ожидаемый вывод.

Сделай минимально возможные изменения.





Требования:

1. Программа должна выводить данные на экран.

2. Вывод на экран должен соответствовать ожидаемому.

3. Аннотация(@interface) LongPositive должна быть отмечена двумя другими аннотациями.

4. Аннотация(@interface) LongPositive должна применяться только к полям.

5. Аннотация(@interface) LongPositive должна быть доступна во время выполнения программы.
*/
