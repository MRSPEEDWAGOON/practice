package com.example.gameapp.core;

import java.util.*;

public class Player {
    private final String id;
    private final String name;
    private final List<Game> borrowedGames = new ArrayList<>();

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public List<Game> getBorrowedGames() {
        return Collections.unmodifiableList(borrowedGames);
    }

    public boolean borrowGame(Game game) {
        if (game != null && !borrowedGames.contains(game)) {
            borrowedGames.add(game);
            return true;
        }
        return false;
    }

    public boolean returnGame(Game game) {
        return borrowedGames.remove(game);
    }
}
