# Упражнение с отладчиком Android Studio

Файл для упражнения: `app/src/main/java/com/example/diceroller/MainActivity.kt`.

1. Открыть проект `dice-roller` в Android Studio.
2. Поставить breakpoint слева от строки `val imageResource = when (result)`.
3. Нажать **Debug app**, а не обычный Run.
4. В окне Debug проверить `result`, стек вызовов и текущую строку.
5. Нажать **Resume Program**, затем кнопку **Roll** в приложении. Выполнение
   снова остановится на breakpoint, и можно увидеть новое значение `result`.
6. Поставить breakpoint на вызове `DiceRollerApp()` в `onCreate()`, перезапустить
   Debug и использовать **Step Into**, чтобы перейти внутрь composable-функции.
7. Удалить breakpoints после упражнения.

Breakpoint не меняет исходный код и поэтому не хранится в Git. Результат
упражнения проверяется демонстрацией Variables, Frames, Resume и Step Into в IDE.
