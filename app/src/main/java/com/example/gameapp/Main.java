package com.example.gameapp;

import com.example.gameapp.core.Game;
import com.example.gameapp.core.GameLibrary;
import com.example.gameapp.core.Player;
import com.example.gameapp.core.Achievement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // Используем константу версии
        LOG.info("Application start, version {}", Constants.VERSION);

        GameLibrary library = new GameLibrary();
        library.addGame(new Game("GTA V", "Action-Adventure"));
        library.addGame(new Game("Stardew Valley", "Simulation"));
        library.addGame(new Game("Celeste", "Platformer"));

        Player alice = new Player("Alice");
        library.registerPlayer(alice);

        library.awardAchievement(alice.getId(), new Achievement("First Blood", "First blood"));
        library.awardAchievement(alice.getId(), new Achievement("Green Thumb", "First harvest"));

        LOG.info("Available games: {}", library.getAvailableGames());
        LOG.info("Player achievements {}: {}", alice.getName(), library.getPlayerAchievements(alice.getId()));
    }
}
