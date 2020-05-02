/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
 
Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2
 
Constraints:
Methods pop, top and getMin operations will always be called on non-empty stacks.
*/



//Initially I did the exception handling for the top operation after pop but later I noticed that Leetcode handling this exception
// and there was no input that needs that handling. Code accepted and worked very well 
//Thats why I shortened the code

class MinStack {
    
    static final int MAX = 1000; 
    int top; 
    int a[] = new int[MAX]; 
    
    //Minstack is called in the main method of Leetcode example
    public MinStack() {
        top = -1;
    }
    
    //checks empty array and adds element to index of top in the array
    public void push(int x) {
        
        if (top >= (MAX - 1)) { 
            System.out.println("Stack Overflow"); 
        } 
        else { 
            a[++top] = x; 
            System.out.println(x + " pushed into stack"); 

        } 
    }
    
    //just updates the top index to minus 1
    public void pop() {
            top--; 
    
    }
    
    //returns the array[index] where index is defined as top
    public int top() {
        
        return a[top];
        
    }
    
    //loops the array from beginning to top and finds the min element
    public int getMin() {

        int min_value =  Integer.MAX_VALUE;
        for(int i = 0 ; i<=top;i++){
            
            if(a[i] < min_value){
            
                min_value = a[i];
            }            
        }

        return min_value;
    }
}
