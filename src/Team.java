import java.util.ArrayList;
import java.util.List;

final class Team {
    private String name;
    private String city;
    private final List<Player> players;
    private static final short MAX_PLAYERS = 11;

    Team() {
        this.players = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
    }


    String getCity() {
        return city;
    }

    void setCity(String city) {
        if (city == null || city.trim().isEmpty()) {
            throw new IllegalArgumentException("City cannot be null or empty");
        }
        this.city = city;
    }

    List<Player> getPlayers() {
        return new ArrayList<>(players);
    }

    static short getMaxPlayers() {
        return MAX_PLAYERS;
    }

    void addPlayer(Player player) {
        if (players.contains(player)) {
            throw new IllegalArgumentException("The player '" + player + "' already exists in the team");
        }
        if (players.size() >= MAX_PLAYERS) {
            throw new IllegalStateException("The team is already full");
        }
        players.add(player);
    }

    void removePlayer(Player player) {
        if (!players.contains(player)) {
            throw new IllegalArgumentException("The player '" + player + "' doesn't exist in the team");
        }
        players.remove(player);
    }

    List<Player> getPlayersByPosition(PlayerPosition position) {
        List<Player> playersByPosition = new ArrayList<>();
        for (Player player : players) {
            if (player.getPosition() == position) {
                playersByPosition.add(player);
            }
        }
        return playersByPosition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team: ").append(name).append(" (").append(city).append(")\n");
        sb.append("Number of players: ").append(players.size()).append("/").append(MAX_PLAYERS).append("\n");
        sb.append("Players by position:\n");
        for (PlayerPosition position : PlayerPosition.values()) {
            sb.append("\t").append(position).append(": ");
            List<Player> playersByPosition = getPlayersByPosition(position);
            if (playersByPosition.isEmpty()) {
                sb.append("None\n");
            } else {
                sb.append(playersByPosition.size()).append("\n");
                for (Player player : playersByPosition) {
                    sb.append("\t\t").append(player.getName()).append("\n");
                }
            }
        }
        return sb.toString();
    }
}