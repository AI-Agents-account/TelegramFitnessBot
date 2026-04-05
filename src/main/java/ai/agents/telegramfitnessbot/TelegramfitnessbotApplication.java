package ai.agents.telegramfitnessbot;

import ai.agents.telegramfitnessbot.config.TelegramBotProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TelegramBotProperties.class)
public class TelegramfitnessbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelegramfitnessbotApplication.class, args);
	}

}
