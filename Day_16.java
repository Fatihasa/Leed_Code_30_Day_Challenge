/*
Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:
Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
*/

// I used a very different approach for this question
//There was a trick in the question which '*' can be used as ')' or '(' if it is needed else does not change the balanced paranthesis
class Solution {
    public boolean checkValidString(String s) {
         int a = 0;
        
        // First we start from the beginning of the string and check if there exists extra paranthesis and the extra one is ')'
        for (int i = 0; i < s.length(); i++) {   
            char c = s.charAt(i); 
            if(c == '*' || c == '(')a++;
            else if(c == ')' && a>0 ) a--;
            else if(c == ')')return false;
        }
        
        // Starts from the last element and check if there is extra '(' paranthesis
        a = 0 ;
        for (int i = s.length()-1; i >= 0 ; i--) {   
            char c = s.charAt(i); 
            if(c == '*' || c == ')')a++;
            else if(c == '(' && a>0 ) a--;
            else if(c == '(')return false;
        }
        
        return true;
    }
    
}
