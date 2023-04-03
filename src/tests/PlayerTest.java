import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerTest {

    @Test
    void testGetName() {
        Player player = new Player();
        player.setName("John");
        assertEquals("John", player.getName());
    }

    @Test
    void testGetAge() {
        Player player = new Player();
        player.setAge("25");
        assertEquals("25", player.getAge());
    }

    @Test
    void testGetPosition() {
        Player player = new Player();
        player.setPosition(PlayerPosition.FORWARD);
        assertEquals(PlayerPosition.FORWARD, player.getPosition());
    }

    @Test
    void testGetNumber() {
        Player player = new Player();
        player.setNumber(10);
        assertEquals(10, player.getNumber());
    }

    @Test
    void testGetTeam() {
        Player player = new Player();
        Team team = new Team();
        team.setName("Team A");
        player.setTeam(team);
        assertEquals(team, player.getTeam());
    }
}