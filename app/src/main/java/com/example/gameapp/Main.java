package com.example.gameapp;

import com.example.gameapp.core.GameLibrary;
import com.example.gameapp.core.Game;
import com.example.gameapp.core.Player;
import com.example.gameapp.core.Achievement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Вывод версии и старт приложения
        LOG.info("Старт приложения, версия {}", Constants.VERSION);

        GameLibrary library = new GameLibrary();

        // добавляем игры
        library.addGame(new Game("GTA V", "Action-Adventure"));
        library.addGame(new Game("Stardew Valley", "Simulation"));
        library.addGame(new Game("Celeste", "Platformer"));

        // регистрируем игрока
        Player alice = new Player("Alice");
        library.registerPlayer(alice);

        // выдаём достижения
        library.awardAchievement(alice.getId(), new Achievement("First Blood", "Первый убитый враг"));
        library.awardAchievement(alice.getId(), new Achievement("Green Thumb", "Вырастил первый урожай"));

        // логируем результаты
        LOG.info("Доступные игры: {}", library.getAvailableGames());
        LOG.info("Достижения игрока {}: {}", alice.getName(), library.getPlayerAchievements(alice.getId()));
    }
}
