package com.example.gameapp.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameLibraryMockitoTest {

    private GameLibrary library;
    private Player mockPlayer;
    private Game game;

    @BeforeEach
    void setUp() {
        library = new GameLibrary();
        mockPlayer = mock(Player.class);

        when(mockPlayer.getId()).thenReturn("p1");
        when(mockPlayer.borrowGame(any(Game.class))).thenReturn(true);
        when(mockPlayer.returnGame(any(Game.class))).thenReturn(true);

        game = new Game("Cyberpunk", "RPG");

        library.addGame(game);
        library.registerPlayer(mockPlayer);
    }

    @Test
    void testBorrowGame_invokesPlayerBorrow() {
        boolean result = library.borrowGame("p1", "Cyberpunk");

        assertTrue(result);
        verify(mockPlayer, times(1)).borrowGame(game);
        Collection<Game> available = library.getAvailableGames();
        assertFalse(available.contains(game));
    }

    @Test
    void testBorrowGame_withUnknownPlayer_returnsFalse() {
        reset(mockPlayer);

        boolean result = library.borrowGame("unknown", "Cyberpunk");
        assertFalse(result);
        verifyNoInteractions(mockPlayer);
    }

    @Test
    void testBorrowGame_withNonexistentTitle_returnsFalse() {
        reset(mockPlayer);

        boolean result = library.borrowGame("p1", "Nonexistent");
        assertFalse(result);
        verify(mockPlayer, never()).borrowGame(any());
    }

    @Test
    void testReturnGame_invokesPlayerReturn() {
        library.borrowGame("p1", "Cyberpunk");
        reset(mockPlayer);
        when(mockPlayer.returnGame(any(Game.class))).thenReturn(true);
        library.addGame(game);

        boolean result = library.returnGame("p1", "Cyberpunk");
        assertTrue(result);
        verify(mockPlayer, times(1)).returnGame(game);
        assertTrue(library.getAvailableGames().contains(game));
    }

    @Test
    void testAwardAchievement_interaction() {
        reset(mockPlayer);

        Achievement ach = new Achievement("A1", "Desc");
        boolean result = library.awardAchievement("p1", ach);
        assertTrue(result);
        verifyNoInteractions(mockPlayer);
    }
}
