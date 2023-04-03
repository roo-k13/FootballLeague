import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

final class Match {
    private Team homeTeam;
    private Team awayTeam;
    private final List<Goal> homeTeamGoals;
    private final List<Goal> awayTeamGoals;
    private static final short LENGTH = 90;
    private static final short MAX_GOALS = 5;

    Match() {
        this.homeTeamGoals = new ArrayList<>(MAX_GOALS);
        this.awayTeamGoals = new ArrayList<>(MAX_GOALS);
    }

    Team getHomeTeam() {
        return homeTeam;
    }

    void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    Team getAwayTeam() {
        return awayTeam;
    }

    void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    void addHomeTeamGoal(Goal goal) {
        homeTeamGoals.add(goal);
    }

    List<Goal> getHomeTeamGoals() {
        return homeTeamGoals;
    }

    void addAwayTeamGoal(Goal goal) {
        awayTeamGoals.add(goal);
    }

    List<Goal> getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public static short getMaxGoals() {
        return MAX_GOALS;
    }

    MatchResult getResult() {
        if (homeTeamGoals.size() > awayTeamGoals.size()) {
            return MatchResult.HOME_WIN;
        } else if (awayTeamGoals.size() > homeTeamGoals.size()) {
            return MatchResult.AWAY_WIN;
        } else {
            return MatchResult.DRAW;
        }
    }

    private void simulateGoals(List<Goal> goals) {
        int amount = ThreadLocalRandom.current().nextInt(MAX_GOALS + 1);
        for (int i = 0; i < amount; i++) {
            int time = ThreadLocalRandom.current().nextInt(1, LENGTH + 1);
            goals.add(new Goal(homeTeam.getPlayers().get(0), time));
        }
    }

    void simulate() {
        simulateGoals(homeTeamGoals);
        simulateGoals(awayTeamGoals);
    }

    String printGoals(List<Goal> goals) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object goal : goals) {
            stringBuilder.append(String.format("%-25s", goal.toString()));
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Game: ").append(homeTeam.getName()).append(" vs ").append(awayTeam.getName()).append(System.lineSeparator());
        stringBuilder.append("Score: ").append(homeTeamGoals.size()).append(" - ").append(awayTeamGoals.size()).append(System.lineSeparator());
        stringBuilder.append("Goals: ").append(System.lineSeparator());
        stringBuilder.append(printGoals(homeTeamGoals));
        stringBuilder.append(printGoals(awayTeamGoals));
        return stringBuilder.toString();
    }
}