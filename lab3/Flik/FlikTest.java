import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by shalk on 2017/7/10.
 */
public class FlikTest {

    @Test
    public void testIsSameNumber() {
        boolean result = Flik.isSameNumber(128, 128);
        assertEquals(true, result);
    }
}
