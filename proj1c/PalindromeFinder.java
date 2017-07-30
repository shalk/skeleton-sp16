/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {
    public static void main(String[] args) {
        int minLength = 4;
        In in = new In("words.txt");

        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word)) {
                System.out.println(word);
            }
        }
        in.close();
        // find OffByOne Palindrome
        System.out.println("[find OffByOne Palindrome]");
        In in1 = new In("words.txt");
        CharacterComparator cc = new OffByOne();
        while (!in1.isEmpty()) {
            String word = in1.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }
        in1.close();
        // find OffByN
        System.out.println("[find OffByN Palindrome]");
        In in2 = new In("words.txt");
        CharacterComparator ob5 = new OffByN(5);
        while (!in2.isEmpty()) {
            String word = in2.readString();
            if (word.length() >= minLength && Palindrome.isPalindrome(word, ob5)) {
                System.out.println(word);
            }
        }
        //For what N are there the most palindromes in English?
        int mostPalinDromesNum = 0;
        int mostN = 0;
        String longestPalinDrome = "";
        int longestPalinDromeN = 0;

        for(int N = 0; N < 26; N++){
            In in3 = new In("words.txt");
            CharacterComparator obn = new OffByN(N);
            // record current palin number of N;
            int currentNum = 0;
            while (!in3.isEmpty()) {
                String word = in3.readString();
                int wordLength = word.length();
                if (wordLength >= minLength && Palindrome.isPalindrome(word, obn)) {
                    currentNum = currentNum + 1;
                    if (wordLength > longestPalinDrome.length()) {
                       longestPalinDrome = word;
                       longestPalinDromeN = N;
                    }
                }
            }
            if (currentNum > mostPalinDromesNum) {
                mostPalinDromesNum = currentNum;
                mostN = N;
            }
            in3.close();
        }
        System.out.println("N:" + mostN + " have  the most palindromes in English:" + mostPalinDromesNum);
        System.out.println("N:" + longestPalinDromeN + " have the longest palindrome:" + longestPalinDrome);
    }
} 
