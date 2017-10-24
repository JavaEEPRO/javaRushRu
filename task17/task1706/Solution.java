
//His disciples said to him, "Behold, now you speak plainly, and speak no figures of speech. (John 16:29)

---------------------------------------------Solution.java----------------------------------------------------
package com.javarush.task.task17.task1706;

/* 
Синхронизированный президент
*/

public class Solution {
    
    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident );
    }
}

--------------------------------------------------------------------------------------------------------------



--------------------------------------------OurPresident.java-------------------------------------------------
package com.javarush.task.task17.task1706;

public class OurPresident {
    private static OurPresident president;
    
    static{
        synchronized(OurPresident.class) {
            president = new OurPresident();
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
--------------------------------------------------------------------------------------------------------------






/*
Синхронизированный президент
И снова Singleton паттерн — синхронизация в статическом блоке
Внутри класса OurPresident в статическом блоке создайте синхронизированный блок.
Внутри синхронизированного блока инициализируйте president.


Требования:
1. Класс OurPresident должен содержать приватную статическое поле OurPresident president.
2. Класс OurPresident должен содержать публичный статический метод OurPresident getOurPresident().
3. Класс OurPresident должен содержать приватный конструктор.
4. Класс OurPresident должен содержать статический блок.
5. Внутри статического блока класса OurPresident должен быть синхронизированный блок.
6. Внутри синхронизированного блока должно быть проинициализировано поле president.

package com.javarush.task.task17.task1706;

* 
Синхронизированный президент
*

public class Solution {
    public static void main(String[] args) {
        OurPresident expectedPresident = OurPresident.getOurPresident();
        OurPresident ourPresident = OurPresident.getOurPresident();
        System.out.println(expectedPresident == ourPresident );
    }
}


*/
