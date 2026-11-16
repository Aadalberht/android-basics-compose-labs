# Лабораторная работа №3 — Display lists and use Material Design

Источник: [Unit 3 курса Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course#unit-3).

## Состав работы

### Pathway 1 — More Kotlin fundamentals

- Generics, объекты, enum/data-классы, extension-функции и scope functions.
- Коллекции: массивы, списки, множества и отображения.
- Функции высшего порядка для обработки коллекций.
- Семь этапов практики Events Tracker.

### Pathway 2 — Build a scrollable list

- Affirmations: карточки с текстом и изображениями в `LazyColumn`.
- Собственная иконка приложения.
- Courses: адаптивная сетка в `LazyVerticalGrid`.

### Pathway 3 — Build beautiful apps

- Woof: Material-тема, типографика, формы и раскрывающиеся карточки с анимацией.
- Проверка доступности: описания изображений, достаточные размеры целей и семантика.
- Superheroes: тематизированный список с верхней панелью.
- Итоговый проект 30 Days: 30 советов в прокручиваемом списке.

Каждое самостоятельное задание фиксируется отдельным коммитом. Результаты
сборки, тестов и запуска будут записаны в `VERIFICATION.md` после CI-проверки.

## Соответствие заданиям курса

| Задание | Результат |
|---|---|
| Generics, objects, and extensions | `kotlin/lessons/01_generics_objects_extensions` |
| Use collections in Kotlin | `kotlin/lessons/02_collections` |
| Higher-order functions with collections | `kotlin/lessons/03_higher_order_collections` |
| Practice: Classes and Collections | `kotlin/practice/events_tracker` и семь последовательных коммитов |
| Add a scrollable list | `affirmations/` |
| Change the app icon | собственная adaptive icon в `affirmations/` |
| Practice: Build a grid | `courses/` |
| Material Theming | `woof/` |
| Simple animation | раскрытие карточек и вращение кнопки в `woof/` |
| Testing for Accessibility | `woof/ACCESSIBILITY.md` и улучшенные semantics |
| Practice: Build Superheroes app | `superheroes/` |
| Project: Create a 30 Days App | `thirty-days/` — 30 оригинальных советов |
| Три Quiz | `QUIZZES.md` |

## Запуск

В Android Studio нужно открывать папку конкретного приложения, например:

```text
unit-03/affirmations
unit-03/courses
unit-03/woof
unit-03/superheroes
unit-03/thirty-days
```

После Gradle Sync выбрать эмулятор и нажать `Run 'app'`. Сборка одного проекта
из терминала:

```sh
cd unit-03/thirty-days
./gradlew assembleDebug lintDebug
```

Все Kotlin-задания из трёх лабораторных проверяются из корня репозитория:

```sh
python3 scripts/verify-kotlin.py
```

## Что показать на защите

1. В Kotlin объяснить generic-параметр, enum/data class, extension property,
   `filter`, `groupBy`, `fold` и различия List/Set/Map.
2. В Affirmations прокрутить LazyColumn, в Courses показать сетку из двух колонок.
3. В Woof раскрыть карточку собаки и показать Material-тему и анимацию.
4. В Superheroes показать Top App Bar, карточки и собственную типографику.
5. В 30 Days прокрутить список из 30 дней и раскрыть полный текст совета.
