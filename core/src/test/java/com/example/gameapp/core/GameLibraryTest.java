package com.example.gameapp.core;

import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class GameLibraryTest {
    private GameLibrary lib;
    private Game g1, g2, g3;
    private Player p;

    @BeforeEach
    void setUp() {
        lib = new GameLibrary();
        g1 = new Game("G1", "Action");
        g2 = new Game("G2", "Action");
        g3 = new Game("G3", "Puzzle");
        lib.addGame(g1);
        lib.addGame(g2);
        lib.addGame(g3);
        p = new Player("Test");
        lib.registerPlayer(p);
    }

    @Test
    @DisplayName("searchByGenre возвращает все игры указанного жанра")
    void testSearchByGenre() {
        List<Game> result = lib.searchByGenre("Action");
        assertEquals(2, result.size());
        assertTrue(result.contains(g1) && result.contains(g2));
    }

    @Test
    @DisplayName("searchByGenre с неверным жанром возвращает пустой список")
    void testSearchByInvalidGenre() {
        assertTrue(lib.searchByGenre("RPG").isEmpty());
    }

    @Test
    @DisplayName("borrowGame возвращает false для неверных данных")
    void testBorrowInvalid() {
        assertFalse(lib.borrowGame("fake-id", "G1"));
        assertFalse(lib.borrowGame(p.getId(), "UnknownGame"));
    }
}
