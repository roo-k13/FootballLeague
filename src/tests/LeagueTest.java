import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class LeagueTest {
    private League league;

    private Team team1;
    private Team team2;
    private Team team3;

    @BeforeEach
    void setUp() {
        league = new League();
        league.setName("Test League");

        team1 = new Team();
        team1.setName("Team 1");
        team2 = new Team();
        team2.setName("Team 2");
        team3 = new Team();
        team3.setName("Team 3");

        Match match1 = new Match();
        match1.setHomeTeam(team1);
        match1.setAwayTeam(team2);

        Match match2 = new Match();
        match2.setHomeTeam(team2);
        match2.setAwayTeam(team3);

        Match match3 = new Match();
        match3.setHomeTeam(team3);
        match3.setAwayTeam(team1);

        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);

        league.addGame(match1);
        league.addGame(match2);
        league.addGame(match3);
    }

    @Test
    @DisplayName("Test getting league name")
    final void getNameTest() {
        String expectedName = "Test League";
        Assertions.assertEquals(expectedName, league.getName());
    }

    @Test
    @DisplayName("Test setting league name")
    final void setNameTest() {
        String expectedName = "Premier League";
        league.setName(expectedName);
        Assertions.assertEquals(expectedName, league.getName());
    }

    @Test
    @DisplayName("Test getting teams")
    final void getTeamsTest() {
        ArrayList<Team> expectedTeams = new ArrayList<>();
        expectedTeams.add(team1);
        expectedTeams.add(team2);
        expectedTeams.add(team3);
        Assertions.assertEquals(expectedTeams, league.getTeams());
    }

    @Test
    @DisplayName("Test adding a team")
    void testAddTeam() {
        Team newTeam = new Team();
        newTeam.setName("New Team");
        league.addTeam(newTeam);
        Assertions.assertTrue(league.getTeams().contains(newTeam));
    }

    @Test
    @DisplayName("Test removing a team")
    void testRemoveTeam() {
        league.removeTeam(team2);
        Assertions.assertFalse(league.getTeams().contains(team2));
    }

    @Test
    @DisplayName("Test adding a game")
    void testAddGame() {
        Match newMatch = new Match();
        newMatch.setHomeTeam(team1);
        newMatch.setAwayTeam(team2);
        league.addGame(newMatch);
        Assertions.assertTrue(league.getGames().contains(newMatch));
    }

    @Test
    @DisplayName("Test removing a game")
    void testRemoveGame() {
        Match match = new Match();
        league.addGame(match);
        league.removeGame(match);
        Assertions.assertFalse(league.getGames().contains(match));
    }

    @Test
    @DisplayName("Test getting the league standings")
    void testGetStandings() {
        HashMap<Team, Integer> expectedPoints = new HashMap<>();
        expectedPoints.put(team1, 2);
        expectedPoints.put(team2, 2);
        expectedPoints.put(team3, 2);
        Assertions.assertEquals(expectedPoints, league.getStandings());
    }
}