public class Solution {

    /*
    Naive solution: Keep two running pointers to nums1 and nums2, and keep re-calculating the median at each step.
        - Time complexity: O(n + m)
        - Space complexity: O(n + m)
     */

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /*
        2080 / 2080 test cases passed.
        Status: Accepted
        Runtime: Your runtime beats 13.88% of java submissions.
         */

        int ptr1 = 0;
        int ptr2 = 0;
        int num_elems = 0;
        int[] elems = new int[nums1.length + nums2.length];

        while(num_elems < nums1.length + nums2.length) {
            int next_number;

            if(ptr1 == nums1.length) {
                next_number = nums2[ptr2];
                ptr2++;
            }

            else if(ptr2 == nums2.length) {
                next_number = nums1[ptr1];
                ptr1++;
            }

            else if(nums1[ptr1] < nums2[ptr2]) {
                next_number = nums1[ptr1];
                ptr1++;
            }

            else {
                next_number = nums2[ptr2];
                ptr2++;
            }

            elems[num_elems] = next_number;
            num_elems++;
        }

        int mid = (int) (Math.floor(num_elems/2));
        return (num_elems%2 == 0) ? (elems[mid] + elems[mid-1])/2.0 : elems[mid];
    }
}