import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.List;

final class MatchTest {
    private Match match;
    private Team homeTeam;
    private Team awayTeam;

    @BeforeEach
    void setUp() {
        match = new Match();

        // Set up home team
        homeTeam = new Team();
        for (int i = 0; i < Team.getMaxPlayers(); i++) {
            homeTeam.addPlayer(new Player());
        }
        match.setHomeTeam(homeTeam);

        // Set up away team
        awayTeam = new Team();
        for (int i = 0; i < Team.getMaxPlayers(); i++) {
            awayTeam.addPlayer(new Player());
        }
        match.setAwayTeam(awayTeam);
    }

    @Test
    void testConstructor() {
        assertNotNull(match.getHomeTeamGoals());
        assertNotNull(match.getAwayTeamGoals());
        assertTrue(match.getHomeTeamGoals().isEmpty());
        assertTrue(match.getAwayTeamGoals().isEmpty());
    }

    @Test
    void testGetHomeTeam() {
        assertEquals(homeTeam, match.getHomeTeam());
    }

    @Test
    void testSetHomeTeam() {
        Team newHomeTeam = new Team();
        match.setHomeTeam(newHomeTeam);
        assertEquals(newHomeTeam, match.getHomeTeam());
    }

    @Test
    void testGetAwayTeam() {
        assertEquals(awayTeam, match.getAwayTeam());
    }

    @Test
    void testSetAwayTeam() {
        Team newAwayTeam = new Team();
        match.setAwayTeam(newAwayTeam);
        assertEquals(newAwayTeam, match.getAwayTeam());
    }

    @Test
    void testAddHomeTeamGoal() {
        Goal goal = new Goal(homeTeam.getPlayers().get(0), 10);
        match.addHomeTeamGoal(goal);
        List<Goal> goals = match.getHomeTeamGoals();
        assertEquals(1, goals.size());
        assertTrue(goals.contains(goal));
    }

    @Test
    void testGetHomeTeamGoals() {
        Goal goal1 = new Goal(new Player(), 10);
        Goal goal2 = new Goal(new Player(), 20);
        match.addHomeTeamGoal(goal1);
        match.addHomeTeamGoal(goal2);
        List<Goal> homeTeamGoals = match.getHomeTeamGoals();
        assertEquals(2, homeTeamGoals.size());
        assertTrue(homeTeamGoals.contains(goal1));
        assertTrue(homeTeamGoals.contains(goal2));
    }

    @Test
    void testAddAwayTeamGoal() {
        Goal goal = new Goal(awayTeam.getPlayers().get(0), 10);
        match.addAwayTeamGoal(goal);
        List<Goal> goals = match.getAwayTeamGoals();
        assertEquals(1, goals.size());
        assertTrue(goals.contains(goal));
    }

    @Test
    void testGetAwayTeamGoals() {
        Goal goal1 = new Goal(new Player(), 10);
        Goal goal2 = new Goal(new Player(), 20);
        match.addAwayTeamGoal(goal1);
        match.addAwayTeamGoal(goal2);
        List<Goal> awayTeamGoals = match.getAwayTeamGoals();
        assertEquals(2, awayTeamGoals.size());
        assertTrue(awayTeamGoals.contains(goal1));
        assertTrue(awayTeamGoals.contains(goal2));
    }

    @Test
    void testGetResult() {
        // Add some goals to the match
        match.addHomeTeamGoal(new Goal(homeTeam.getPlayers().get(0), 15));
        match.addHomeTeamGoal(new Goal(homeTeam.getPlayers().get(1), 35));
        match.addAwayTeamGoal(new Goal(awayTeam.getPlayers().get(0), 25));

        // Test for a home win
        assertEquals(MatchResult.HOME_WIN, match.getResult());

        // Test for an away win
        match.getAwayTeamGoals().add(new Goal(awayTeam.getPlayers().get(1), 80));
        match.getAwayTeamGoals().add(new Goal(awayTeam.getPlayers().get(2), 90));
        assertEquals(MatchResult.AWAY_WIN, match.getResult());

        // Test for a draw
        match.addHomeTeamGoal(new Goal(homeTeam.getPlayers().get(0),95));
        assertEquals(MatchResult.DRAW, match.getResult());
    }

    @Test
    void testSimulate() {
        match.simulate();
        assertTrue(match.getHomeTeamGoals().size() + match.getAwayTeamGoals().size() <= Match.getMaxGoals() * 2);
    }

    @Test
    void testToString() {
        match.simulate();
        String expectedString = "Game: " + homeTeam.getName() + " vs " + awayTeam.getName() + System.lineSeparator() +
                "Score: " + match.getHomeTeamGoals().size() + " - " + match.getAwayTeamGoals().size() + System.lineSeparator() +
                "Goals: " + System.lineSeparator() +
                match.printGoals(match.getHomeTeamGoals()) +
                match.printGoals(match.getAwayTeamGoals());
        assertEquals(expectedString, match.toString());
    }
}