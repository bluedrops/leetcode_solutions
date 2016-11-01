public class Solution {

    /*
    Optimized solution: Create a hashmap of the entries in the array to give us constant time lookup, then check for (target - nums[index]) in the hashmap.
        - Time complexity: O(n)
        - Space complexity: O(n)
    */

    public int[] twoSum(int[] nums, int target) {

        int[] ret = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            map.put(i, nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            if(map.containsValue(target - nums[i])) {
                ret[0] = i;
                ret[1] = map.get(target-nums[i]);
            }
        }

        return ret;
    }
}
