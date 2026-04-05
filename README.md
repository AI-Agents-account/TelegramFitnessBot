# TelegramFitnessBot

Telegram-first bot for tracking workouts, body progress, generating daily meal plans (MVP).

## Quick start (Docker)

### 1) Create a `.env` from example

```bash
cp .env.example .env
# put your TELEGRAM_BOT_TOKEN into .env
```

### 2) Run

```bash
docker compose up --build
```

- App: http://localhost:8080/actuator/health
- Postgres: localhost:5432 (postgres/postgres)

## Contents
- `BRD_TelegramFitnessBot_MVP.md` — бизнес-требования (MVP)
- `tasks/mvp/` — декомпозиция MVP

## Security
- Never commit real bot tokens.
- Use env vars / local `.env` only.
