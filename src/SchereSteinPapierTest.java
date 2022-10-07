import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class SchereSteinPapierTest {

    private ArrayList<String> equalArray = new ArrayList<>();
    private SchereSteinPapier cut = new SchereSteinPapier();

    @Test
    public void runAllTests() {
        checkWhenEqual();
        checkWhenUserHasScissors();
        checkWhenUserHasStone();
        checkWhenUserHasPaper();
        checkWhenComputerHasScissors();
        checkWhenComputerHasStone();
        checkWhenComputerHasPaper();
    }

    @Test
    public void checkWhenEqual() {
        this.equalCheckHelper();

        for (int i = 0; i < equalArray.size(); i++) {
            String winner = cut.winLogic(equalArray.get(i), equalArray.get(i));
            String expectedWinner = "Niemand";
            assertThat(winner, is(expectedWinner));
        }
    }

    public void equalCheckHelper() {
        equalArray.add("Schere ✂️");
        equalArray.add("Stein \uD83E\uDEA8");
        equalArray.add("Papier \uD83D\uDCDD");
    }

    @Test
    public void checkWhenUserHasScissors() {
        String winner = cut.winLogic("Schere ✂️", "Stein \uD83E\uDEA8");
        String expectedWinner = "Computer";
        assertThat(winner, is(expectedWinner));
    }

    @Test
    public void checkWhenUserHasStone() {
        String winner = cut.winLogic("Stein \uD83E\uDEA8", "Papier \uD83D\uDCDD");
        String expectedWinner = "Computer";
        assertThat(winner, is(expectedWinner));
    }

    @Test
    public void checkWhenUserHasPaper() {
        String winner = cut.winLogic("Papier \uD83D\uDCDD", "Schere ✂️");
        String expectedWinner = "Computer";
        assertThat(winner, is(expectedWinner));
    }

    @Test
    public void checkWhenComputerHasScissors() {
        String winner = cut.winLogic("Stein \uD83E\uDEA8", "Schere ✂️");
        String expectedWinner = "User";
        assertThat(winner, is(expectedWinner));
    }

    @Test
    public void checkWhenComputerHasStone() {
        String winner = cut.winLogic("Papier \uD83D\uDCDD", "Stein \uD83E\uDEA8");
        String expectedWinner = "Computer";
        assertThat(winner, is(expectedWinner));
    }

    @Test
    public void checkWhenComputerHasPaper() {
        String winner = cut.winLogic("Schere ✂️", "Papier");
        String expectedWinner = "User";
        assertThat(winner, is(expectedWinner));
    }

}