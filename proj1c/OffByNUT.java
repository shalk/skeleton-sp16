import org.junit.Assert;
import org.junit.Test;

/**
 * Created by shalk on 2017/7/30.
 */
public class OffByNUT {
    @Test
    public void testOffByN() {
        OffByN ob5 = new OffByN(5);
        Assert.assertEquals(true, ob5.equalChars('a', 'f'));
        Assert.assertEquals(false, ob5.equalChars('a', 'e'));
    }
}
