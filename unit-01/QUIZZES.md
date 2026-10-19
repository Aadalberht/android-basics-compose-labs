# Ответы к трём Quiz первого юнита

Ответы разобраны для подготовки. Онлайн-отправка и получение значков требуют
входа владельца Google Developer Profile и здесь не отмечены как выполненные.

## Pathway 1 — Intro to Programming

[Тест](https://developer.android.com/courses/quizzes/android-basics-compose-unit-1-pathway-1/android-basics-compose-unit-1-pathway-1).

1. `val hello = "hello"`.
2. False: для неизменяемого значения используют `val`.
3. `total++`, `total--`, `total = total + 1`. Выражение `total - 1` не изменяет переменную.
4. True: комментарии не исполняются.
5. `Decimal` не входит в предложенный набор стандартных типов Kotlin.
6. True: `Float` менее точен, чем `Double`.
7. Точка входа — `main()`.
8. Варианты 1, 2, 4: `Unit` без явно указанного типа, сохранение результата,
   соответствие возвращаемому типу. Вопрос упрощён: правило про Unit относится
   к функциям с телом в фигурных скобках; у тела-выражения тип выводится.
9. Варианты 1, 3, 4: параметры, передача аргументов, разбиение на функции.
10. True: именованные аргументы допускают изменение порядка.

## Pathway 2 — Set up Android Studio

[Тест](https://developer.android.com/courses/quizzes/android-basics-compose-unit-1-pathway-2/android-basics-compose-unit-1-pathway-2).

1. IDE — Integrated Development Environment.
2. Варианты 1, 2, 3: помощь с ошибками, эмулятор, предпросмотр.
3. Вариант 3: тестирование без физического устройства.
4. Варианты 2, 3, 4: быстрый старт, рекомендуемая структура, начальный код.
5. Both B and C: File → New → New Project либо создание из стартового окна.
6. `setContent()`.
7. True: необходима аннотация `@Composable`.
8. `Surface`.
9. `Modifier`.
10. Неверен вариант 3: тема не обязана находиться внутри Surface, обычно оборачивает его.

## Pathway 3 — Build a basic layout

[Тест](https://developer.android.com/courses/quizzes/android-basics-compose-unit-1-pathway-3/android-basics-compose-unit-1-pathway-3).

1. Вариант 1: современный инструментарий Android UI.
2. True: основа интерфейса — composable-функции.
3. `@Composable`.
4. `Column`, `Row`, `Box` — варианты 1, 2, 4.
5. Resource Manager.
6. Класс `R`.
7. `painterResource()`.
8. `contentDescription`; декоративному изображению можно передать `null`.
9. True: Box размещает элементы слоями.
10. `Alignment.Start`.
