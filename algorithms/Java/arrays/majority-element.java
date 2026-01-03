//Given an array A of N elements. Find the majority element in the array.
//A majority element in an array A of size N is an element that appears more than N/2 times in the array

// Moore’s Voting Algorithm => Time Complexity: O(n), Space Complexity: O(1)

/**
 * Majority Element using Moore's Voting Algorithm.
 *
 * An element is a majority if it appears more than n/2 times.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public final class MajorityElement {

    private MajorityElement() {
        // Utility class
    }

    public static int findMajority(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int candidate = findCandidate(nums);

        return isMajority(nums, candidate) ? candidate : -1;
    }

    private static int findCandidate(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    private static boolean isMajority(int[] nums, int candidate) {
        int count = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            }
        }
        return count > nums.length / 2;
    }
}


/* Test Case: 
Input:
N = 5  A[] = {3,1,3,3,2} 

Output: 3

Explanation:
Since, 3 is present more
than N/2 times, so it is 
the majority element. */
