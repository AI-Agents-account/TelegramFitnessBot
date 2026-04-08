package ai.agents.telegramfitnessbot.telegram;

import ai.agents.telegramfitnessbot.config.TelegramBotProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MainBot extends TelegramLongPollingBot {

    private final TelegramBotProperties props;

    @Override
    public String getBotUsername() {
        return props.username();
    }

    @Override
    public String getBotToken() {
        return props.token();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update == null || !update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }

        var message = update.getMessage();
        var chatId = message.getChatId().toString();
        var text = message.getText().trim();

        if ("/start".equalsIgnoreCase(text)) {
            sendMainMenu(chatId);
            return;
        }

        // MVP for Epic 00: just echo available actions
        sendText(chatId, "Команда не распознана. Нажмите /start, чтобы открыть меню.");
    }

    private void sendMainMenu(String chatId) {
        var msg = SendMessage.builder()
                .chatId(chatId)
                .text("Привет! Это TelegramFitnessBot (MVP). Выберите раздел:")
                .replyMarkup(mainMenuKeyboard())
                .build();

        try {
            execute(msg);
        } catch (TelegramApiException e) {
            // swallow in MVP; later add structured logging
        }
    }

    private void sendText(String chatId, String text) {
        try {
            execute(SendMessage.builder().chatId(chatId).text(text).build());
        } catch (TelegramApiException e) {
            // swallow in MVP
        }
    }

    private ReplyKeyboardMarkup mainMenuKeyboard() {
        KeyboardRow row1 = new KeyboardRow(List.of(
                new KeyboardButton("Тренировка"),
                new KeyboardButton("Прогресс")
        ));
        KeyboardRow row2 = new KeyboardRow(List.of(
                new KeyboardButton("Питание"),
                new KeyboardButton("Отчёт")
        ));
        KeyboardRow row3 = new KeyboardRow(List.of(
                new KeyboardButton("Настройки")
        ));

        ReplyKeyboardMarkup keyboard = new ReplyKeyboardMarkup();
        keyboard.setResizeKeyboard(true);
        keyboard.setOneTimeKeyboard(false);
        keyboard.setSelective(false);
        keyboard.setKeyboard(List.of(row1, row2, row3));
        return keyboard;
    }
}
