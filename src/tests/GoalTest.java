import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GoalTest {

    @Test
    void testToString() {
        Player scorer = new Player();
        scorer.setName("John");
        Goal goal = new Goal(scorer, 25);

        String expected = "Goal scored by John at 25 minutes.";
        String actual = goal.toString();

        Assertions.assertEquals(expected, actual);
    }
}