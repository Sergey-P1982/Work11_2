package com.epam.task61;

import com.epam.task61.controller.Controller;

public class Main {

    public static void main(String[] args) {
        new Controller().run();
    }
}
//OUTPUT:
//        1. Show all books
//        2. Find by author
//        3. Find by publisher
//        4. Find books published after specified year
//        5. Sort books by publisher
//        6. Change languare
//        7. Add a new book to the library
//        0. Exit
//        Choice operation:
//        1
//        All books:
//        author:Blinov          titul:Blinov                    publish:Misnk           year:2013  pages:855   cost:855,00
//        author:Brce            titul:Java2                     publish:London          year:570   pages:123   cost:123,00
//        author:Blin            titul:Java3                     publish:Uman            year:21    pages:1234  cost:1234,00
//        author:Шилдт           titul:Java8                     publish:Киев            year:2012  pages:678   cost:678,00
//        author:Bruce Eckel     titul:Thinking in Java          publish:London          year:2003  pages:455   cost:455,00
//        author:Блинов          titul:Методы программирования   publish:Минск           year:2013  pages:855   cost:855,00
//        author:Романчук        titul:Паттерны                  publish:Минск           year:2013  pages:856   cost:856,00
