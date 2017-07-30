/**
 * Created by shalk on 2017/7/30.
 */
public class Palindrome {
    public static Deque<Character> wordToDeque(String word){
        Deque<Character> deque = new LinkedListDequeSolution<>();
        for(char c: word.toCharArray()) {
            deque.addLast(c);
        }
        return deque;
    }

    public static boolean isPalindrome(String word){

        Deque<Character> deque = wordToDeque(word);
        while(deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (first == last){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> deque = wordToDeque(word);
        while(deque.size() > 1) {
            char first = deque.removeFirst();
            char last = deque.removeLast();
            if (cc.equalChars(first, last)){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
