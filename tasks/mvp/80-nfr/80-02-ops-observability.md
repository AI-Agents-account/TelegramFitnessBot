# 80-02 Ops & Observability (MVP)

## Business goal
Упростить эксплуатацию: healthcheck, структурные логи, базовые метрики.

## Scope
- `/health`.
- Логи: startup, ошибки, ключевые события (start workout, end workout, menu generated) без PII.
- Конфигурация через env.

## Acceptance criteria
- По логам можно понять, что бот работает и где ошибка.

## Smoke test
- Запуск, запрос health, базовые команды.
