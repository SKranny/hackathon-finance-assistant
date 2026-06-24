# Finance Assistant

Android-приложение для умного управления личными финансами с ИИ-ассистентом на базе локальной модели Ollama.

## Возможности

### Основной функционал

- **Автоматический анализ SMS-транзакций** — приложение сканирует SMS-сообщения от банков и извлекает информацию о расходах и доходах
- **Интеграция с календарём** — отслеживание предстоящих событий и их влияния на финансы
- **AI-ассистент** — чат-бот для управления финансами (перенос расходов, отмена подписок, настройка напоминаний)
- **Прогнозирование баланса** — визуализация ожидаемых изменений баланса на 30 дней вперёд
- **Умные напоминания** — push-уведомления о предстоящих расходах и подписках
- **Генерация финансовых кейсов** — автоматическое выявление проблемных паттернов расходов
- **Импорт данных** — поддержка импорта транзакций из CSV/Excel файлов
- **Локальная обработка данных** — вся логика работает локально через Ollama API

### Структура экранов

1. **Главный экран** — баланс, быстрые действия, сводка расходов
2. **Лента событий** — список транзакций и финансовых инсайтов
3. **Прогноз** — график прогноза баланса
4. **Ассистент** — диалог с ИИ-помощником

## Технологии

- Kotlin + Jetpack Compose
- Hilt (DI)
- ObjectBox (локальная БД)
- Ollama API (локальная AI-модель)
- Room (для части данных)
- Kotlin Coroutines + Flow

## Требования

- Android 8.0+ (API 26)
- Ollama с моделью `gemma4:e2b`
- 4+ GB RAM для работы AI

---

## Установка и запуск

### 1. Установка APK на Android устройство/эмулятор

#### Вариант A: Через Android Studio

```bash
# Клонировать репозиторий
git clone <repo-url>
cd hackathon-finance-assistant

# Открыть в Android Studio
# Или собрать через терминал:
./gradlew assembleDebug

# APK будет в: app/build/outputs/apk/debug/app-debug.apk
```

#### Вариант B: Через ADB

```bash
# Установить APK напрямую
adb install app/build/outputs/apk/debug/app-debug.apk
```

### 3. Альтернатива: Ollama в Termux (для Android-устройства)

Termux позволяет запустить Ollama прямо на Android-устройстве.

#### Шаг 1: Установка Termux

1. Скачайте Termux из F-Droid (не из Google Play — там устаревшая версия):
   https://f-droid.org/en/packages/com.termux/

2. После установки обновите пакеты:
```bash
pkg update && pkg upgrade -y
```

#### Шаг 2: Установка Ollama

```bash
# Установить Ollama для Android (aarch64)
curl -fsSL https://ollama.com/install.sh | sh

# Или скачать бинарник вручную:
# https://github.com/ollama/ollama/releases
```

#### Шаг 3: Загрузка модели gemma4:e2b

```bash
# Загрузить модель (~2.5 GB)
ollama pull gemma4:e2b

# Проверить установку
ollama list
```

#### Шаг 4: Запуск Ollama сервера

```bash
# Запустить сервер на порту 11434
# По умолчанию Ollama слушает localhost:11434
ollama serve

# Сервер будет работать в фоне
# Чтобы запустить в фоне:
nohup ollama serve > ollama.log 2>&1 &

# Проверить статус:
curl http://localhost:11434/api/tags
```

#### Шаг 5: Настройка сети (для эмулятора)

Если Ollama запущен на том же устройстве, используйте:

```bash
# Для доступа с эмулятора к Ollama на устройстве
# Нужно использовать реальный IP вместо localhost

# Узнать IP устройства:
ip addr show wlan0
# или
ifconfig wlan0

# Пример: 192.168.1.100
```

Для Android 10+ приложения по умолчанию используют `127.0.0.1` для всех localhost-соединений. Если эмулятор/устройство не может подключиться к Termux Ollama:

```bash
# В Termux запустите Ollama с явным хостом:
OLLAMA_HOST=0.0.0.0 ollama serve
```

#### Шаг 6: Проверка подключения

С устройства с приложением проверьте доступность Ollama:

```bash
# С устройства:
curl http://<ollama-ip>:11434/api/tags

# Ответ должен содержать список моделей
```

### 5. Конфигурация приложения

При первом запуске приложение попросит разрешения:
- Доступ к SMS (для чтения транзакций)
- Доступ к календарю (для отслеживания событий)
- Уведомления (для напоминаний)

**Настройка Ollama URL:**

По умолчанию приложение ожидает Ollama по адресам:
- `http://10.0.2.2:11434` — для эмулятора Android Studio
- `http://localhost:11434` — для Android-устройства

Для Termux на устройстве используйте реальный IP (например `http://192.168.1.100:11434`) или настройте переадресацию портов.

### 6. Запуск на эмуляторе Android Studio

```bash
# Запустить эмулятор
# (через Android Studio: Tools > Device Manager > Create Device)

# Установите APK на эмулятор:
./gradlew installDebug

# Или через Android Studio Run/Debug
```

### 7. Альтернатива: Ollama Desktop (для быстрой проверки)

Если не хочется настраивать Termux на устройстве, можно запустить Ollama на ПК:

1. **Скачайте Ollama** с https://ollama.com/download
2. **Загрузите модель:**
   ```bash
   ollama pull gemma4:e2b
   ```
3. **Запустите сервер:**
   ```bash
   ollama serve
   ```
4. Запустите эмулятор — он автоматически подключится к Ollama на хосте

> Эмулятор Android Studio направляет `10.0.2.2:11434` на `localhost:11434` ПК.

### 8. Возможные проблемы

| Проблема | Решение |
|----------|---------|
| Ollama не запускается | Проверьте `ollama.log`, убедитесь что устройство поддерживает aarch64 |
| Модель не загружается | Освободите место (нужно ~3 GB свободного места) |
| Приложение не подключается к Ollama | Проверьте URL в настройках, убедитесь что Ollama запущен |
| Out of memory | Закройте другие приложения, используйте меньшую модель |
| Разрешения SMS не работают | На Android 10+ может потребоваться ручное разрешение в настройках |

### 9. Структура проекта

```
app/
├── src/main/java/com/finance/assistant/
│   ├── ai/                    # AI Model Manager (Ollama integration)
│   ├── data/                  # Data layer
│   │   ├── local/             # ObjectBox + Room databases
│   │   ├── objectbox/         # ObjectBox entities
│   │   ├── repository/        # Repositories
│   │   └── importer/          # CSV/Excel import
│   ├── di/                    # Hilt modules
│   ├── domain/                # Domain layer
│   │   ├── model/             # Domain models
│   │   └── usecase/           # Use cases
│   ├── service/               # Background services
│   └── ui/                    # UI layer
│       ├── components/        # Reusable composables
│       ├── navigation/        # Navigation graph
│       ├── screens/           # Screen composables
│       └── theme/             # Material theme
```

