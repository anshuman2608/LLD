import org.junit.Test;
import static org.junit.Assert.*;

public class MagicalArenaTest {
    @Test
    public void testPlayMatch_PlayerAWins() {
        // Create players
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(100, 10, 5);
        // Create dice
        Die attackingDie = new Die(6);
        Die defendingDie = new Die(6);

        // Create and run the game
        MagicalArena arena = new MagicalArena(playerA, playerB, attackingDie, defendingDie);
        arena.playMatch();

        // Assert that Player A wins
        assertTrue(playerA.getHealth() == 50 && playerB.getHealth() == 0);
    }

    @Test
    public void testPlayMatch_PlayerBWins() {
        // Create players
        Player playerA = new Player(100, 10, 5);
        Player playerB = new Player(50, 5, 10);
        // Create dice
        Die attackingDie = new Die(6);
        Die defendingDie = new Die(6);

        // Create and run the game
        MagicalArena arena = new MagicalArena(playerA, playerB, attackingDie, defendingDie);
        arena.playMatch();

        // Assert that Player B wins
        assertTrue(playerA.getHealth() == 0 && playerB.getHealth() == 50);
    }

    @Test
    public void testPlayMatch_EqualHealth_PlayerBWins() {
        // Create players with equal health
        Player playerA = new Player(50, 5, 10);
        Player playerB = new Player(50, 10, 5);
        // Create dice
        Die attackingDie = new Die(6);
        Die defendingDie = new Die(6);

        // Create and run the game
        MagicalArena arena = new MagicalArena(playerA, playerB, attackingDie, defendingDie);
        arena.playMatch();

        // Assert that Player B wins when both players have equal health
        assertTrue(playerA.getHealth() == 0 && playerB.getHealth() == 50);
    }
}
