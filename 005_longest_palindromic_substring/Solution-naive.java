public class Solution {

    /*
    Naive solution: Brute-force check whether every substring 1.) is longer than the current longest palindrome and, 2.) is a palindrome.
        - Time complexity: O(n^3)
        - Space complexity: O(1)
     */

    public class Solution {

        public boolean isPalindrome(String s) {
            /* Borrowed from my solution to leetcode "#125 - Valid Palindrome" */
            s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
            for(int i = 0; i < Math.floor(s.length()/2); i++) {
                if(s.charAt(i) != s.charAt(s.length()-(i+1)))
                    return false;
            }
            return true;
        }

        public String longestPalindrome(String s) {
            String curr_longest = "";

            for (int from = 0; from < s.length(); from++) {
                for (int to = from + 1; to <= s.length(); to++) {
                    String substr = s.substring(from, to);
                    // Tiny optimization: Don't bother checking the substring if it's shorter than our current best palindromic substring.
                    if(substr.length() > curr_longest.length() && isPalindrome(substr))
                        curr_longest = substr;
                }
            }

            return curr_longest;
        }
    }
}