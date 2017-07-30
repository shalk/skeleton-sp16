import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by shalk on 2017/7/30.
 */
public class PalindromeUT {
    @Test
    public void testWordToQueue() {
        Deque<Character> deque = Palindrome.wordToDeque("Palindrome");
        deque.printDeque();
    }

    @Test
    public void testIsPalindrome1() {
        String word = "noon";
        Boolean expected = true;
        Boolean actual = Palindrome.isPalindrome(word);
        assertEquals(expected, actual);
    }

    @Test
    public void testIsPalindrome2() {
        String word = "moon";
        Boolean expected = false;
        Boolean actual = Palindrome.isPalindrome(word);
        assertEquals(expected, actual);
    }
}
