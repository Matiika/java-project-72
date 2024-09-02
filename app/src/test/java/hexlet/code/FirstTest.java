package hexlet.code;

import hexlet.code.Main;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    @Test
    public void mainTest() {
        var a = Main.plus(1, 1);
        assertEquals(2, 2);
    }
}
