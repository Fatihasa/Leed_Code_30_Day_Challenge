/*
Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
Example 2:
Input: [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Note: The length of the given binary array will not exceed 50,000.
*/

public class Solution {
    
    public int findMaxLength(int[] nums) {
        /*This approach uses hash maps and creates value for every count key to find max distance */
        Map<Integer, Integer> map = new HashMap<>();
        
        //this is starting point of index (length starts from 0 and goes to index + 1)
        // lets say index is 6 the len gonna be equal to 6 - (-1) =7  where count equals 0 next time
        map.put(0, -1);
        
        int len = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
 
            //if this is the second time we encountered the count maximum length is calculated
            //if the first time we encountered count creates the index as new value for the count key
            if (map.containsKey(count)) {
                len = Math.max(len, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        //finally returns the maximum length
        return len;
    }
}
