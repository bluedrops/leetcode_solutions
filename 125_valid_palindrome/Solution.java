public class Solution {

    /*
    Optimized solution: Remove all inconsequential characters using a regex, then convert to lowercase for uniformity. Then read the string in-place to the middle of the string, comparing each letter to its corresponding one on the other half of the string.
        - Time complexity: O(n)
        - Space complexity: O(1)
     */

    public boolean isPalindrome(String s) {

        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        for(int i = 0; i < Math.floor(s.length()/2); i++) {
            if(s.charAt(i) != s.charAt(s.length()-(i+1))) {
                return false;
            }
        }

        return true;
    }
}