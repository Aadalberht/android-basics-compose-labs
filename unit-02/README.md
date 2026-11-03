# Лабораторная работа №2 — Building app UI

Источник: [Unit 2 курса Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course#unit-2).

## Состав работы

### Pathway 1 — Kotlin fundamentals

- Условные выражения `if`, `else` и `when`.
- Nullable-типы и безопасная работа с `null`.
- Классы, объекты и наследование.
- Типы функций, лямбда-выражения и функции высшего порядка.
- Семь самостоятельных практических задач.

### Pathway 2 — Add a button to an app

- Интерактивное приложение Dice Roller.
- Памятка по работе с отладчиком Android Studio.
- Практическое приложение Lemonade с четырьмя состояниями.

### Pathway 3 — Interacting with UI and state

- Tip Time: ввод стоимости и процента чаевых, округление результата.
- Локальные unit-тесты и инструментальный Compose UI-тест.
- Итоговый проект Art Space с переключением произведений.

## Правила репозитория

Каждое самостоятельное задание сохраняется отдельным коммитом. Консольные
программы Kotlin содержат собственный `main()` и проверяются независимо.
Android-приложения являются отдельными Gradle-проектами.

Фактические результаты сборки, тестов и запуска будут записаны в
`VERIFICATION.md` после завершения автоматической проверки.

## Соответствие заданиям курса

| Задание | Результат |
|---|---|
| Write conditionals | `kotlin/lessons/01_conditionals` |
| Use nullability | `kotlin/lessons/02_nullability` |
| Classes and objects | `kotlin/lessons/03_classes` |
| Function types and lambdas | `kotlin/lessons/04_lambdas` |
| Practice: Kotlin Fundamentals | `kotlin/practice/01_*` … `07_*` |
| Create an interactive Dice Roller | `dice-roller/` |
| Use the debugger | `dice-roller/DEBUGGER.md` |
| Practice: Click behavior | `lemonade/` |
| Intro to state in Compose | первый этап истории `tip-time/` |
| Calculate a custom tip | итоговая версия `tip-time/` |
| Write automated tests | `tip-time/app/src/test` и `app/src/androidTest` |
| Project: Create an Art Space app | `art-space/` |
| Три Quiz | `QUIZZES.md` |

## Запуск

Каждый `.kt` — отдельная консольная программа. Из корня репозитория все
Kotlin-задания проверяются командой:

```sh
python3 scripts/verify-kotlin.py
```

Android-приложение открывается в Android Studio отдельной папкой, например
`unit-02/lemonade`. Для сборки одного проекта:

```sh
cd unit-02/lemonade
./gradlew assembleDebug lintDebug
```

Для сборки всех приложений обоих юнитов:

```sh
./scripts/build-android.sh
```

APK появляется в `app/build/outputs/apk/debug/app-debug.apk` внутри проекта.

## Что показать на защите

1. В Kotlin объяснить `when`, nullable-тип `String?`, safe-call `?.`, Elvis `?:`,
   наследование и передачу лямбды в функцию.
2. В Dice Roller показать `rememberSaveable`, случайное число и смену drawable.
3. В Lemonade показать четыре состояния и случайные 2–4 нажатия для лимона.
4. В Tip Time ввести сумму и процент, включить округление и запустить тесты.
5. В Art Space переключить работы кнопками Previous/Next и повернуть экран.
