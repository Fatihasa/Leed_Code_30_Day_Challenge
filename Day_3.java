/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
Example:
Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/



//Both n2 and nlogn approaches are included


//n2 approach
class Solution {
    public int maxSubArray(int[] nums) {
        
        // int [] subArray = Array.copyOfRange(nums,0,5);

            int sum =Integer.MIN_VALUE;
            
            for(int i=1; i != nums.length+1 ; i++){
                 
               for(int k = 0; k < nums.length ; k++){
                
                int tmpsum =0;                
                for(int j=k ; j<nums.length ; j++){
                    
//                  System.out.println( " i: " + i + " J: " + j + " K: " + k + "     nums[j]: " + array[j]);
                    tmpsum += nums[j];
                                        
                    if (i==(j+1)){
                        break;
                    }
                
                    if(nums[j]>sum){
                    sum=nums[j];
                    }                
                }
                
//              System.out.println(tmpsum);
                if(tmpsum>sum){
                    
                    sum=tmpsum;
                }


            }
                
            
        }
        
    return sum;    
    }
}

//nlogn approach

import java.util.*; 
class Solution {
    

    static int maxCrossingSum(int arr[], int l, 
                                int m, int h) 
    { 
        // Include elements on left of mid. 
        int sum = 0; 
        int left_sum = Integer.MIN_VALUE; 
        for (int i = m; i >= l; i--) 
        { 
            sum = sum + arr[i]; 
            if (sum > left_sum) 
            left_sum = sum; 
        } 
 
        sum = 0; 
        int right_sum = Integer.MIN_VALUE; 
        for (int i = m + 1; i <= h; i++) 
        { 
            sum = sum + arr[i]; 
            if (sum > right_sum) 
            right_sum = sum; 
        } 
  
        return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum)); 
    } 

    static int maxSubArraySum(int arr[], int l,  
                                      int h) 
    { 

    if (l == h) 
        return arr[l]; 
  

    int m = (l + h)/2; 
  

    return Math.max(Math.max(maxSubArraySum(arr, l, m), 
                    maxSubArraySum(arr, m+1, h)), 
                    maxCrossingSum(arr, l, m, h)); 
    } 
  
    
    public int maxSubArray(int[] nums) {
        int n = nums.length; 
        int max_sum = maxSubArraySum(nums, 0, n-1); 
        return max_sum;
    }
}
