# Ответы на Quiz — Unit 3

Ответы сверены с актуальными вопросами Android Developers 16 ноября 2026 года.
Онлайн-форма не отправлялась.

## Pathway 1 — More Kotlin fundamentals

1. `data class Person(val name: String, val age: Int)` — корректный синтаксис data class.
2. `true` — прямые наследники sealed-класса должны находиться в том же package и module.
3. `<>` — параметр обобщённого типа указывается в угловых скобках.
4. `enum` — enum удобен для фиксированного набора значений.
5. `mutableListOf()` — создаёт изменяемый список.
6. `map`, `filter`, `forEach` — все три принимают функции как аргументы.
7. `println(colors[2])` и `println(colors.get(2))` — оба обращения возвращают третий элемент `Blue`.
8. `Singleton` — класс/объект с единственным экземпляром.
9. `A set must contain distinct values and a map’s keys must be distinct.`
10. `records.size` — свойство количества элементов коллекции.

## Pathway 2 — Build a scrollable list

1. `True` — adaptive icon содержит отдельные foreground и background drawable.
2. `LazyColumn` — лениво создаёт элементы вертикального списка и прокручивается.
3. `.xml` — векторные drawable описываются XML.
4. `LazyVerticalGrid` — вертикальная ленивая сетка.
5. `It can only hold a small, finite number of predefined items` — обычный Column создаёт элементы сразу.
6. `items()` — добавляет коллекцию элементов в LazyColumn.
7. `Row` — располагает дочерние элементы горизонтально.
8. `Column` — располагает дочерние элементы вертикально.

## Pathway 3 — Build beautiful apps

1. `All of the above` — анимация объясняет изменения, даёт визуальные подсказки и делает интерфейс аккуратнее.
2. `Damping ratio and stiffness` — параметры spring-анимации.
3. `True` — spring является физической моделью пружины.
4. `primary` — основной наиболее часто используемый фирменный цвет.
5. `Shape.kt` — файл определения форм компонентов.
6. `False` — в проекте разрешено любое необходимое количество Preview-функций.
7. `True` — стандартная RGB-запись использует `#` и шесть шестнадцатеричных символов.
8. `Theme.kt` — объединяет цветовую схему, формы и типографику.
9. `Elevation` — создаёт тень и отделяет Card от фона.
10. `All of the above` — тёмная тема помогает при слабом освещении, чувствительности к свету и иногда экономит заряд.
11. `False` — TalkBack является экранным диктором; Switch Access предназначен для управления переключателями.
12. `contentDescription` — текстовое описание изображения или иконки для TalkBack.
