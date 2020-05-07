/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
Example:
Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
Note: Please solve it without division and in O(n).
Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
*/

import java.util.*;
class Solution {

    public int[] productExceptSelf(int[] nums) {
        
        int [] output = new int[nums.length];
                    
        for(int i=0 ; i< nums.length; i++){
            int iSum=1;
            int jSum=1;
           output[i] = Mult(i-1, i+1 , nums, iSum , jSum);
        }        
        return output;       
    }
    
    static int Mult(int i, int j , int [] array,int iSum, int jSum){
         
        if(j != array.length){
            jSum= array[j] * jSum;
        }          
        if(i >= 0){
            iSum = array[i] * iSum;
        }               
            
        if(i == -1 && j == array.length){
           return iSum*jSum;
        }else if( j == array.length){
           return Mult(i-1, j , array , iSum ,jSum);
        }else if( i == -1){
            return Mult(i, j+1, array , iSum ,jSum);
        }else{
            return Mult(i-1,j+1, array , iSum , jSum );   
        }
           
    }
}
