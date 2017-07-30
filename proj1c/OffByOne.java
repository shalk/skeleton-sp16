/**
 * Created by shalk on 2017/7/30.
 */
public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        if (x < y)
            return equalChars(y, x);
        return x - y == 1 ;
    }
}
