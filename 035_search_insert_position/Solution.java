public class Solution {

    /*
    Solution: Binary search to the appropriate index; if the number is found, return it; if not, return the appropriate location for the insert.
        - Time complexity: O(log n)
        - Space complexity: O(1)
     */

    /*
    62 / 62 test cases passed.
    Status: Accepted
    Runtime: Your runtime beats 22.47% of java submissions.
     */

    public int searchInsert(int[] nums, int target) {
        return search(0, nums.length-1, nums, target);
    }

    private int average(int a, int b) {
        return (int) Math.floor((a + b)/2);
    }

    private int search(int lower, int upper, int[] nums, int target) {

        if(nums[lower] == target) return lower;
        if(nums[upper] == target) return upper;

        if(upper-lower <= 1) {
            if(target > nums[lower] && target < nums[upper])
                return lower + 1;
            return (target > nums[upper]) ? (upper + 1) : lower;
        }

        int mid = average(lower, upper);

        if(nums[mid] == target) return mid;

        if(target > nums[mid]) {
            return search(mid+1, upper, nums, target);
        } else {
            int new_lower = mid-1;
            if(new_lower < 0) new_lower = 0;
            return search(lower, new_lower, nums, target);
        }
    }
}