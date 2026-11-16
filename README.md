# Android Basics with Compose — лабораторные работы

Один репозиторий для курса. Каждая лабораторная соответствует одному Unit,
а практические приложения внутри юнита хранятся как отдельные Android-проекты.
Задания фиксируются отдельными коммитами по мере выполнения.

Источник: [официальный курс Android Developers](https://developer.android.com/courses/android-basics-compose/course).

## Лабораторная №1 — Your first Android app

- [Содержание и запуск](unit-01/README.md).
- [Результаты проверки](unit-01/VERIFICATION.md).
- [Ответы к трём Quiz](unit-01/QUIZZES.md).
- [Настройка Android Studio и устройств](unit-01/SETUP.md).
- [Прототип итоговой визитки](unit-01/business-card/design.md).
- [Источники изображений](THIRD_PARTY.md).
- [Скриншоты шести запущенных приложений](unit-01/evidence/README.md).
- [Скачать шесть APK](https://github.com/Aadalberht/android-basics-compose-labs/actions/runs/39296610114/artifacts/12208093178).

13 самостоятельных Kotlin-программ: три вводных задания и десять задач практики.
Шесть Android-приложений: Greeting, Happy Birthday, Compose Article,
Task Manager, Compose Quadrant, Business Card.

## Лабораторная №2 — Building app UI

- [Содержание и запуск](unit-02/README.md).
- [Результаты проверки](unit-02/VERIFICATION.md).
- [Ответы к трём Quiz](unit-02/QUIZZES.md).
- [Упражнение с отладчиком](unit-02/dice-roller/DEBUGGER.md).
- [Скриншоты четырёх запущенных приложений](unit-02/evidence/README.md).
- [Скачать APK](https://github.com/Aadalberht/android-basics-compose-labs/actions/runs/41621286772/artifacts/13223704239).

11 самостоятельных Kotlin-программ: четыре учебных темы и семь задач практики.
Четыре Android-приложения: Dice Roller, Lemonade, Tip Time и Art Space.
Tip Time содержит локальные unit-тесты и инструментальный Compose UI-тест.

## Лабораторная №3 — Display lists and use Material Design

- [Содержание и запуск](unit-03/README.md).
- [Ответы к трём Quiz](unit-03/QUIZZES.md).
- [Проверка доступности Woof](unit-03/woof/ACCESSIBILITY.md).

Четыре самостоятельные Kotlin-программы: три учебные темы и итоговая практика
Events Tracker из семи последовательных этапов. Пять Android-приложений:
Affirmations, Courses, Woof, Superheroes и оригинальный проект 30 Days of Focus.

## Проверка

```sh
python3 scripts/verify-kotlin.py
./scripts/build-android.sh
```

Для первой команды нужен Kotlin CLI. Для второй — JDK 17 и Android SDK 35.
Gradle Wrapper включён в каждое приложение.

GitHub Actions автоматически собирает приложения, запускает Android Lint,
сверяет вывод Kotlin-программ и запускает APK в эмуляторе.
Успешный запуск сохраняет APK и скриншоты в артефактах Actions.
Факты прохождения конкретных запусков указаны в `unit-01/VERIFICATION.md` и
`unit-02/VERIFICATION.md`.

## Коммиты

```sh
git log --oneline --reverse
```

Исходные задания и дальнейшие изменения видны в истории. Промежуточная текстовая
версия открытки сохранена перед добавлением фонового изображения.
Будущие лабораторные можно добавлять как `unit-03/`, `unit-04/` и далее.
