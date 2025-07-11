public class Main {
    public static void main(String[] args) {
        GameLibrary library = new GameLibrary();

        library.addGame(new Game("GTA V", "Action-Adventure"));
        library.addGame(new Game("Stardew Valley", "Simulation"));
        library.addGame(new Game("Celeste", "Platformer"));


        Player alice = new Player("Alice");
        library.registerPlayer(alice);


        library.awardAchievement(alice.getId(), new Achievement("First Blood", "Первый убитый враг"));
        library.awardAchievement(alice.getId(), new Achievement("Green Thumb", "Вырастил первый урожай"));


        System.out.println("Доступные игры:");
        for (Game g : library.getAvailableGames()) {
            System.out.println(" - " + g);
        }
        System.out.println("Достижения игрока " + alice.getName() + ":");
        for (Achievement a : library.getPlayerAchievements(alice.getId())) {
            System.out.println(" - " + a);
        }
    }
}