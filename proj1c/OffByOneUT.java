import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by shalk on 2017/7/30.
 */
public class OffByOneUT {
    @Test
    public void testEqualChar1() {
        OffByOne obo = new OffByOne();
        assertEquals(true, obo.equalChars('a', 'b'));
        assertEquals(true, obo.equalChars('z', 'y'));
        assertEquals(false, obo.equalChars('a', 'c'));
        assertEquals(false, obo.equalChars('z', 'a'));
    }
}
