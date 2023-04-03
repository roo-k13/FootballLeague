import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

final class TeamTest {

    private Team team;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        team = new Team();
        team.setName("Team");
        team.setCity("City");
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    void testGetName() {
        assertEquals("Team", team.getName());
    }

    @Test
    void testSetName() {
        team.setName("New Name");
        assertEquals("New Name", team.getName());
    }

    @Test
    void testGetCity() {
        assertEquals("City", team.getCity());
    }

    @Test
    void testSetCity() {
        team.setCity("New City");
        assertEquals("New City", team.getCity());
    }

    @Test
    public void testGetPlayers() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        List<Player> players = team.getPlayers();
        assertEquals(2, players.size());
        assertTrue(players.contains(player1));
        assertTrue(players.contains(player2));
    }

    @Test
    public void testAddPlayer() {
        Player player = new Player();
        team.addPlayer(player);
        assertTrue(team.getPlayers().contains(player));
        assertThrows(IllegalArgumentException.class, () -> team.addPlayer(player));
    }

    @Test
    public void testRemovePlayer() {
        team.addPlayer(player1);
        team.addPlayer(player2);
        assertTrue(team.getPlayers().contains(player1));
        assertTrue(team.getPlayers().contains(player2));
        team.removePlayer(player1);
        assertFalse(team.getPlayers().contains(player1));
        assertThrows(IllegalArgumentException.class, () -> team.removePlayer(player1));
    }
}