/**
 * Created by shalk on 2017/7/30.
 */
public class OffByN implements CharacterComparator {
    private final int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        if ( x < y) {
            return equalChars(y, x);
        }
        return x - y == N ;
    }
}
