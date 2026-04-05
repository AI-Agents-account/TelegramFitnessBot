# 20-01 Каталог упражнений (Exercise) + поиск

## Business goal
Нормализованный каталог упражнений — основа планов и логирования. План всегда ссылается на существующие упражнения.

## Scope
- CRUD `Exercise` (MVP: без UI для массового редактирования; минимум — сервис + API).
- Поля MVP:
  - `name` (RU)
  - `primaryMuscleGroup` (enum)
  - `equipment` (enum)
  - `environment` (GYM/HOME/ANY)
  - `difficulty` (enum, опц.)
  - `tags` (опц.)
  - `isActive`
- Поиск:
  - по подстроке `name` (case-insensitive)
  - фильтры по группе/оборудованию/среде
  - пагинация

## Acceptance criteria
- Есть API/Service: `searchExercises(query, filters, page)`.
- Можно найти «Жим лёжа» по `жим` и фильтровать `CHEST+BARBELL`.
- Упражнения можно деактивировать (не удаляя), планы/логи при этом не ломаются.

## Technical notes
- Индекс по `name`.
- Уникальность `name` (как минимум в рамках системного каталога).

## Tests
- Поиск, фильтры, пагинация, неактивные упражнения.
