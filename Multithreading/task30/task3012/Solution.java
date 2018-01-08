
//	But in the days of the voice of the seventh angel, when he shall begin to sound, the mystery of God should be finished, as he hath declared to his servants the prophets. (Revelation 10:7)

package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
    }

    public void createExpression(int number) {
        int[] array={1, 3, 9, 27, 81, 243, 729, 2187};        //напишите тут ваш код
        String s="";
        int nn=number;
        while (nn>0)
        {
            if (nn%3==0)
            {
                s=s+"0";
                nn/=3;
            }
            else if (nn%3==1)
            {
                s=s+"+";
                nn/=3;
            }
            else if (nn%3==2)
            {
                s=s+"-";
                nn/=3;
                nn++;
            }
        }
        int sum=0;
        String str="";
        for (int i=0;i<s.length(); i++)
        {
            if (s.charAt(i)=='+') {
                str+=" + "+array[i];
                sum+=array[i];
            }
            else if (s.charAt(i)=='-')
            {
                str+=" - "+array[i];
                sum-=array[i];
            }
        }
        System.out.println(sum+" ="+str);
    }
}

/*
Получи заданное число

Реализуй метод createExpression(int number).

Метод createExpression вызывается с одним параметром number. Этот параметр - число от 1 до 3000 включительно.

Нужно вывести арифметическое выражение, результатом которого является число number.

Можно использовать числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.

Можно использовать знаки: "+" и "-" любое количество раз.

Обрати внимание, что перед каждым числом в искомой строке обязательно должен быть знак плюс или минус.

Перед выражением выведи [переданное число] =. (Смотри примеры вывода ниже).



Пример1:

Переданное число:

74

Ожидаемый вывод:

74 = - 1 + 3 - 9 + 81



Пример2:

Переданное число:

1234

Ожидаемый вывод:

1234 = + 1 - 9 + 27 - 243 - 729 + 2187



При выводе выражения используй числа ТОЛЬКО В ВОЗРАСТАЮЩЕМ порядке!

Переданное число:

2

Ожидаемый вывод:

2 = - 1 + 3 //правильно

Ожидаемый вывод:

2 = + 3 - 1 //НЕ правильно

Метод main не участвует в тестировании.



Подсказка:

Почитай в интернете про троичную симметричную систему счисления.





Требования:

1. В начале строчки вывода должно быть расположено число, которое передано в метод createExpression в качестве параметра и знак "=".

2. В выражении можно использовать только числа: 1, 3, 9, 27, 81, 243, 729, 2187 не более, чем по одному разу.

3. В выражении можно использовать только знаки "+" и "-" любое количество раз.

4. Метод createExpression должен быть реализован согласно условию.
*/