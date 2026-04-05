# 00-01 Project skeleton (Java/Spring + Telegram)

## Business goal
Запустить минимальный работоспособный Telegram-бот, который отвечает на `/start` и показывает главное меню. Это фундамент для всех остальных эпиков.

## Scope
- Java 17+, Spring Boot.
- Библиотека Telegram Bot API (long polling для dev).
- Конфигурация через env:
  - `TELEGRAM_BOT_TOKEN`
  - `TELEGRAM_BOT_USERNAME` (опц.)
  - `DB_URL`, `DB_USER`, `DB_PASSWORD`
- Подключение БД (PostgreSQL предпочтительно).
- Миграции (Flyway/Liquibase).
- Health endpoint (`/health` или actuator).

## Acceptance criteria
- Проект собирается (Gradle/Maven) и стартует локально.
- `/health` отдаёт 200.
- В Telegram: `/start` → приветствие + кнопки главного меню.

## Technical notes
- Сразу заложить слои: `telegram/`, `domain/`, `application/`, `infrastructure/`.
- Заложить storage для диалоговых состояний (MVP: in-memory; потом можно DB/Redis).

## Smoke test
- Запуск приложения + curl health.
- Отправка `/start` реальному боту.
