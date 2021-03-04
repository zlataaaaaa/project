Материалы, использованные в работе:


Oracle JDK 15: https://www.oracle.com/ru/java/technologies/javase-jdk15-downloads.html#license-lightbox
Конкретная версия Java.

Геттеры и Сеттеры: https://vertex-academy.com/tutorials/ru/gettery-i-settery/?doing_wp_cron=1613423557.9797959327697753906250
Специальные методы. Геттер для чтения. Сеттер для записи.

Метод toString(): https://www.examclouds.com/ru/java/java-core-russian/method-tostring
Как использовать метод toString() Java: https://www.internet-technologies.ru/articles/ispolzovanie-metoda-tostring-v-java.html
Для преобразования объекта в понятный текст. Если попытаться распечатать объект встречи, то распечатается вся информация из встречи: участники, время.

StringBuffer и StringBuilder: https://metanit.com/java/tutorial/7.3.php
Для склеивания текста.

Интерфейс Set и класс HashSet - https://metanit.com/java/tutorial/5.4.php:
Для сохранения набора уникальных значений. 

Разбираемся с hashCode() и equals(): https://habr.com/ru/post/168195/:
Для определения уникальности требуется создавать переопределенные методы equals и hashCode.

Интерфейсы Comparable и Comparator. Сортировка - https://metanit.com/java/tutorial/5.6.php:
Для сортировки коллекций. В частности, для сортировки встреч сначала по количеству участников, а затем по порядку дат и времени.

Интерфейс Map и класс HashMap - https://metanit.com/java/tutorial/5.8.php:
Коллекции для хранения планов и участников в виде справочника.

Лямбда-выражения Введение в лямбда-выражения - https://metanit.com/java/tutorial/9.1.php:
Лямбды как параметры и результаты методов - https://metanit.com/java/tutorial/9.2.php:
Для запуска кода внутри тестов.

Работа с датами. LocalDate - https://metanit.com/java/tutorial/12.3.php:
Для хранения времени, например: начало или конец встречи.

Обработка исключений - https://metanit.com/java/tutorial/4.1.php:
Для вызова исключений, если вдруг передали неправильные параметры.

Классы исключений - https://metanit.com/java/tutorial/4.2.php:
Для конкретной ошибки вызываем конкретный класс исключения. Например, если подали null, то NullPointerException. Если передали некорректный параметр, то IllegalArgumentException.

Параметры методов - https://metanit.com/java/tutorial/2.16.php:
Для перечисления участников встречи друг за другом без создания конкретной коллекции. Использование аргументов переменной длины.

Apache Maven - https://ru.wikipedia.org/wiki/Apache_Maven:
Для сборки проекта, подключение зависимостей, таких как JUnit 5.

JUnit - https://ru.wikipedia.org/wiki/JUnit:
Руководство по JUnit. Введение: https://proselyte.net/tutorials/junit/introduction/:
Для создания тестов.

Модульное тестирование: https://ru.wikipedia.org/wiki/%D0%9C%D0%BE%D0%B4%D1%83%D0%BB%D1%8C%D0%BD%D0%BE%D0%B5_%D1%82%D0%B5%D1%81%D1%82%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5
О том, что такое модульное тестирование.

