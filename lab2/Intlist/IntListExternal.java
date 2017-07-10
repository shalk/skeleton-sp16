/**
 * Created by shalk on 2017/6/17.
 */
public class IntListExternal {

    /**
     * incrList an IntList identical to L, but which all values incremented by x;
     * Values in L cannot change!
     * Developed live  in lecture
     * @param L
     * @param x
     * @return
     */
    public static IntList incrList(IntList L, int x) {
        if (L == null) {
            return null;
        }
        IntList P = new IntList(L.head + x , incrList(L.tail, x));
        return P;
        //return L == null ? null : new IntList(L.head + x, incrList(L.tail, x));
    }

    /**
     * return an IntList identical to L, but which all values  decremented by x;
     * Not allow to use `new`
     * @param L
     * @param x
     * @return
     */
    public static IntList dincrList(IntList L, int x) {
        if (L == null) {
            return null;
        }
        L.head = L.head - x;
        dincrList(L.tail, x);
        return L;
    }
}
