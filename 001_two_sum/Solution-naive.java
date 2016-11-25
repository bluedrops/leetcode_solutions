public class Solution {

    /*
    Naive solution: compute the sum of every array index against every other array index.
        - Time complexity: O(n^2)
        - Space complexity: O(1)
    */

    public int[] twoSum(int[] nums, int target) {

        /*
        16 / 16 test cases passed.
        Status: Accepted
        Runtime: Your runtime beats 34.42% of java submissions.
        */

        int[] ret = new int[2];
        boolean found = false;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    found = true;
                    break;
                }
            }
            if(found) break;
        }

        return ret;
    }
}
