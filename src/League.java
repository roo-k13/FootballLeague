import java.util.ArrayList;
import java.util.HashMap;

final class League {
    private String name;
    private final ArrayList<Team> teams;
    private final ArrayList<Match> matches;
    private final HashMap<Team, Integer> standings;

    League() {
        final byte NUMBER_OF_TEAMS = 16;
        this.teams = new ArrayList<>(NUMBER_OF_TEAMS);
        this.matches = new ArrayList<>(NUMBER_OF_TEAMS * 2);
        this.standings = new HashMap<>(NUMBER_OF_TEAMS);
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    ArrayList<Team> getTeams() {
        return teams;
    }

    ArrayList<Match> getGames() {
        return matches;
    }

    void addTeam(Team team) {
        teams.add(team);
    }

    void removeTeam(Team team) {
        teams.remove(team);
    }

    void addGame(Match match) {
        matches.add(match);
    }

    void removeGame(Match match) {
        matches.remove(match);
    }

    HashMap<Team, Integer> getStandings() {
        initializeStandings();
        updateStandings();
        return standings;
    }

    private void initializeStandings() {
        for(Team team : teams) {
            standings.put(team, 0);
        }
    }

    private void updateStandings() {
        for (Match match : matches) {
            Team homeTeam = match.getHomeTeam();
            Team awayTeam = match.getAwayTeam();
            MatchResult result = match.getResult();

            if (result == MatchResult.DRAW) {
                addPointsToTeam(homeTeam, 1);
                addPointsToTeam(awayTeam, 1);
            } else if (result == MatchResult.HOME_WIN) {
                addPointsToTeam(homeTeam, 3);
            } else if (result == MatchResult.AWAY_WIN) {
                addPointsToTeam(awayTeam, 3);
            }
        }
    }

    private void addPointsToTeam(Team team, int points) {
        int currentPoints = standings.get(team);
        standings.put(team, currentPoints + points);
    }
}