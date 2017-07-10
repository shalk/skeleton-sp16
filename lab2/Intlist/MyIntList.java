///**
// * Created by shalk on 2017/6/19.
// */
//public class IntList {
//    public int head;
//    public IntList tail;
//
//    public IntList(int x, IntList n) {
//        this.head = x;
//        this.tail = n;
//    }
//
//    public IntList() {
//        this(0, null);
//    }
//
//    public static IntList list(Integer...args) {
//        IntList head =  new IntList(args[0], null);
//        IntList p = head;
//        for (int i = 1; i < args.length; i++) {
//            p.tail  = new IntList(args[i], null);
//            p = p.tail;
//        }
//        return head;
//    }
//    public static IntList list1(Integer... args) {
//        IntList result, p;
//
//        if (args.length > 0) {
//            result = new IntList(args[0], null);
//        } else {
//            return null;
//        }
//
//        int k;
//        for (k = 1, p = result; k < args.length; k += 1, p = p.tail) {
//            p.tail = new IntList(args[k], null);
//        }
//        return result;
//    }
//    public static void dSquareList(IntList L) {
//        while (L != null) {
//            L.head = L.head * L.head;
//            L = L.tail;
//        }
//    }
//
//    public static IntList squareListIterative(IntList L) {
//        if (L==null) {
//            return null;
//        }
//        IntList ret = new IntList(L.head * L.head, null);
//        IntList t = ret;
//        for (IntList p = L.tail; p !=null ; p = p.tail) {
//            t.tail = new IntList(p.head * p.head, null);
//            t = t.tail;
//        }
//        return ret;
//    }
//    public static IntList squareListRecursive(IntList L) {
//        if (L==null) {
//            return null;
//        }
//        return new IntList(L.head * L.head, squareListRecursive(L.tail));
//    }
//
//    public static IntList dcatenate(IntList A, IntList B) {
//        if ( A == null) {
//            A = B;
//            return A;
//        }
//        IntList res = A;
//        IntList p = A;
//        while (p.tail != null) {
//            p = p.tail;
//        }
//        p.tail = B;
//        return res;
//    }
//
//    public static IntList catenate(IntList A, IntList B) {
//        if( A == null) {
//            return catenate(B, null);
//        }
//        IntList res = new IntList(A.head, null);
//        IntList L = res;
//        for (IntList p = A.tail; p != null; p = p.tail) {
//            L.tail = new IntList(p.head, null);
//            L = L.tail;
//        }
//        for(IntList p = B; p != null; p = p.tail) {
//            L.tail = new IntList(p.head, null);
//            L = L.tail;
//        }
//        return res;
//    }
//
//    @Override
//    public boolean equals(Object x) {
//        if (!(x instanceof IntList)) {
//            return false;
//        }
//        IntList p = (IntList)x;
//        IntList a = this;
//        while(p!=null && a!=null){
//            if (p.head != a.head) {
//                return false;
//            }
//            p = p.tail;
//            a = a.tail;
//        }
//        if( p==null & a==null) {
//            return true;
//        }
//        return false;
//    }
//
//    public static void main(String[] args) {
//        IntList myList = IntList.list(0, 1, 2, 3);
//        IntList newList = squareListIterative(myList);
//    }
//}
