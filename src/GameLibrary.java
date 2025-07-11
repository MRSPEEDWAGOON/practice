import java.util.*;
import java.util.stream.Collectors;

public class GameLibrary {
    private final Map<String, Game> collection = new HashMap<>();
    private final Map<String, List<Achievement>> achievements = new HashMap<>();
    private final Map<String, Player> players = new HashMap<>();


    public void addGame(Game game) {
        collection.put(game.getTitle(), game);
    }

    public void registerPlayer(Player p) {
        players.put(p.getId(), p);
        achievements.put(p.getId(), new ArrayList<>());
    }

    public boolean awardAchievement(String playerId, Achievement ach) {
        List<Achievement> list = achievements.get(playerId);
        if (list != null && players.containsKey(playerId)) {
            list.add(ach);
            return true;
        }
        return false;
    }

    public Collection<Game> getAvailableGames() {
        return collection.values();
    }


    public List<Game> searchByGenger(String genre){
        return collection.values().stream().filter(g -> g.getGenre().equalsIgnoreCase(genre)).collect(Collectors.toList());
    }

    public List<Achievement> getPlayerAchievements(String playerId) {
        return Collections.unmodifiableList(achievements.getOrDefault(playerId, List.of()));
    }
}
