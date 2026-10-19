# Лабораторная работа №1 — Your first Android app

Источник: [Unit 1 курса Android Basics with Compose](https://developer.android.com/courses/android-basics-compose/course#unit-1).

## Состав работы

| Раздел курса | Результат в репозитории |
|---|---|
| Your first program in Kotlin | `kotlin/lessons/01_first_program/` — вывод сообщений, порядок строк, исправления семи упражнений |
| Create and use variables | `kotlin/lessons/02_variables/` — val/var, четыре типа, шаблоны строк, арифметика |
| Create and use functions | `kotlin/lessons/03_functions/` — функции, результат, параметры, именованные аргументы, значения по умолчанию |
| Practice: Kotlin Basics | `kotlin/practice/01_*` … `10_*` — все 10 задач; каждый каталог в отдельном коммите |
| Create your first Android app | `greeting/` — приветствие, цвет фона, отступы |
| Build a simple app with text composables | `happy-birthday/` — текстовая открытка сохранена отдельным промежуточным коммитом |
| Add images to your Android app | `happy-birthday/` — фоновое изображение, строки ресурсов, подпись по центру |
| Practice: Compose Basics — Compose Article | `compose-article/` — картинка, заголовок 24sp, отступы 16dp, выравнивание текста |
| Practice: Compose Basics — Task Manager | `task-manager/` — изображение и сообщения по центру |
| Practice: Compose Basics — Compose Quadrant | `compose-quadrant/` — четыре равных блока и заданные цвета |
| Project: Create a Business Card app | `business-card/` — логотип, имя, должность, три контакта и прототип `design.md` |
| Три Quiz | `QUIZZES.md` — ответы с пояснениями; онлайн-прохождение в профиле не выполнялось |

Практические приложения — отдельные Android-проекты, как просит курс.
Видеоролики и вводная страница не имеют отдельного программного результата.
Настройка локальной Android Studio и подключение физического телефона описаны
в `SETUP.md`; наличие этой инструкции само по себе не означает выполненную установку.
Фактические результаты проверок указаны в `VERIFICATION.md`.

## Запуск

Откройте в Android Studio **одну папку приложения**, например `unit-01/business-card`,
дождитесь Gradle Sync, выберите Android-устройство и нажмите Run.
Минимальная версия — Android 7.0 (API 24). Рекомендуется JDK 17.
Для сборки нужны Android SDK Platform 35 и Build Tools 34.0.0.
Gradle Wrapper уже включён; отдельно устанавливать Gradle не требуется.

```sh
cd unit-01/business-card
./gradlew assembleDebug
```

APK появится в `app/build/outputs/apk/debug/app-debug.apk`.
Чтобы собрать и проверить все шесть приложений, запустите из корня репозитория:

```sh
./scripts/build-android.sh
```

Kotlin-программы независимы: каждый `.kt` содержит свой `main()`.
Не компилируйте их как один модуль: имена учебных функций могут повторяться.
Откройте один файл в Kotlin Playground либо запустите локально:

```sh
kotlinc unit-01/kotlin/practice/09_compare_numbers/CompareNumbers.kt -include-runtime -d /tmp/compare.jar
java -jar /tmp/compare.jar
python3 scripts/verify-kotlin.py
```

Рядом с каждым `.kt` находится `.txt` с результатом запуска. Скрипт проверки
заново компилирует программы и сравнивает вывод с этими файлами.

## Что показать на защите

1. Открыть GitHub → Commits: видны отдельные этапы, а не один финальный коммит.
2. Объяснить разницу `val` и `var`, шаблон строки `${expression}`, параметры и аргументы.
3. Запустить задачу сравнения: больше → true, равно и меньше → false.
4. Показать `AppPreview` и запуск Compose Quadrant: `weight(1f)` делит пространство поровну.
5. В визитке показать `Profile`, `Contacts`, `ContactRow`, строковые ресурсы и `Image`.
6. В открытке объяснить слои `Box`, `ContentScale.Crop`, прозрачность, `contentDescription = null`.

Имя Albert и контакты в визитке демонстрационные. Меняются в
`business-card/app/src/main/res/values/strings.xml`.
