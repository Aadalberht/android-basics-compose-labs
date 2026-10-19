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

## Проверка

```sh
python3 scripts/verify-kotlin.py
./scripts/build-android.sh
```

Для первой команды нужен Kotlin CLI. Для второй — JDK 17 и Android SDK 35.
Gradle Wrapper включён в каждое приложение.

GitHub Actions автоматически собирает приложения, запускает Android Lint,
сверяет вывод Kotlin-программ и запускает шесть APK в эмуляторе.
Успешный запуск сохраняет APK и скриншоты в артефактах Actions.
Факт прохождения конкретного запуска указан в `unit-01/VERIFICATION.md`.

## Коммиты

```sh
git log --oneline --reverse
```

Исходные задания и дальнейшие изменения видны в истории. Промежуточная текстовая
версия открытки сохранена перед добавлением фонового изображения.
Будущие лабораторные можно добавлять как `unit-02/`, `unit-03/` и далее.
