import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PositionTest {
    @Test
    public void positionEquals() {
        Position pos1 = new Position(1,2);
        Position pos2 = new Position(1,2);
        Assertions.assertTrue(pos1.equals(pos2));
    }
}
