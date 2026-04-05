# MVP Tasks (TelegramFitnessBot)

Эти задачи — декомпозиция MVP на основе `BRD_TelegramFitnessBot_MVP.md`.

## Принципы
- Telegram-first: большинство действий — кнопками + минимальный числовой ввод.
- Multi-user: каждый пользователь видит только свои данные (изоляция по Telegram `user_id`).
- Упражнения — нормализованный каталог (`Exercise`) в БД.
- План (`TrainingPlan`) — отдельная сущность и **ссылается** на упражнения (через `exerciseId`).
- LLM используется в основном на **первичной генерации плана** и/или расширении каталога.

## Эпики
- 00 Foundation
- 10 Onboarding
- 20 Exercises Catalog
- 30 Training Plans (LLM generation + management)
- 40 Workout logging (during workout)
- 50 Progress tracking (weight/measurements/photos)
- 60 Nutrition profile + daily menu generation
- 61 Calorie intake log
- 70 Reports (button + period)
- 80 NFR (security/privacy/ops)
