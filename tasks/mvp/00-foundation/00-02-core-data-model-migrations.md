# 00-02 Core data model + migrations

## Business goal
Зафиксировать основные сущности MVP в БД, чтобы дальше эпики реализовывались без «плавающих» моделей.

## Scope (entities)
- `UserProfile`
- `Exercise`
- `TrainingPlan` + `TrainingDay` + `PlanExercise` (link to Exercise)
- `WorkoutSession` + `WorkoutSet` (+ rest start/stop timestamps)
- `BodyMeasurement`
- `ProgressPhoto` (Telegram `file_id`)
- `NutritionProfile`
- `DailyMenu` (упрощённо: JSON/text + estimated macros)
- `CalorieLogEntry` (факт потребления)

## Acceptance criteria
- Миграции применяются на чистую БД без ошибок.
- У каждой user-scoped таблицы есть `telegram_user_id`/`user_id` для изоляции.
- В `PlanExercise` хранится `exercise_id` (FK) и `order_index`.

## Technical notes
- UUID vs Long — выбрать и закрепить.
- Индексы:
  - `exercise.name` (поиск)
  - `*_user_id + date` (истории)
  - `plan_id + order_index`

## Smoke test
- Поднять Postgres, применить миграции, проверить `information_schema`/`\dt`.
