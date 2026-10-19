# Android Studio, эмулятор и телефон

[Официальная загрузка Android Studio](https://developer.android.com/studio).
[Инструкция курса](https://developer.android.com/codelabs/basic-android-kotlin-compose-install-android-studio).

## Mac

1. Скачать Android Studio для Apple Silicon, если Mac использует M-чип.
2. Открыть DMG и перенести Android Studio в Applications.
3. Запустить мастер первоначальной настройки, установить Android SDK и Platform Tools.
4. Через SDK Manager установить Android SDK Platform 35 и Build Tools 34.0.0.
5. Открыть одну папку проекта. Для Gradle выбрать JDK 17 в настройках Build Tools → Gradle.
6. Дождаться синхронизации. При необходимости Android Studio создаст локальный `local.properties`.
   Этот файл содержит путь SDK именно на вашем компьютере и исключён из Git.

## Эмулятор

[Задание курса](https://developer.android.com/codelabs/basic-android-kotlin-compose-emulator).

1. Tools → Device Manager → Create Virtual Device.
2. Выбрать Pixel, скачать ARM64-образ на Apple Silicon (API 24 или выше).
3. Запустить виртуальный телефон, затем приложение кнопкой Run.
4. Закрытие окна останавливает телефон; повторно запустить можно из Device Manager.

Для автоматической проверки эмулятор также запускается в GitHub Actions.
Сценарий `scripts/smoke-android.sh` устанавливает все шесть APK, запускает Activity,
сохраняет скриншоты и проверяет журнал на аварийные завершения.
Это отдельная проверка, не установка Android Studio на Mac.

## Физический телефон — альтернативный способ запуска

[Задание курса](https://developer.android.com/codelabs/basic-android-kotlin-compose-connect-device).

1. Включить режим разработчика и USB debugging в настройках Android.
2. Подключить телефон кабелем, разрешить отладку для своего компьютера.
3. Выбрать телефон в списке устройств Android Studio и нажать Run.
4. После работы при желании отключить USB debugging.

Телефон в этой работе не подключался. Для проверки достаточно эмулятора;
проверка на физическом устройстве отмечается только после реального запуска.

## Подготовленное локальное окружение этой работы

В рабочей папке рядом с репозиторием создан `.tools/android-sdk` с Platform 35
и Build Tools 34.0.0. Загрузки сверены с SHA-1 из официального индекса Google.
Локальные `local.properties` шести проектов указывают на этот SDK и исключены из Git.
Это инструменты сборки; полная Android Studio и локальный эмулятор не установлены.
