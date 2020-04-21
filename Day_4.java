/Temp easy solution, I will try to find optimized method later
/*

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Example:

Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:

You must do this in-place without making a copy of the array.
Minimize the total number of operations.

*/
import java.util.ArrayList;

public class HelloWorld{

     public static void main(String []args){
        
        ArrayList<Integer> values = new ArrayList<>();        
        int [] nums = {0,1,0,3,12};
        int zeros= 0;
        int nonzeros=0;
        
      
        for(int i=0; i<nums.length ; i++){
        
            if(nums[i] ==  0){
                    zeros++;
            }
            else{
                
                values.add(nums[i]);
                nonzeros++;

            }
            
        }

        
        for(int i=0; i< nonzeros; i++){
            
        nums[i]= values.get(i);    
            
        }
        
        for(int i = (nums.length-zeros) ; i<nums.length ; i++ ){
            nums[i] =0;
        }
        
        for(int var : nums){
            System.out.print(var+" ");
        }
        
        
    }
}
