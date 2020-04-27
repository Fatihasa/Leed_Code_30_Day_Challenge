/*
Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".
Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".
Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".
Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
Note:

1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.
Follow up:

Can you solve it in O(N) time and O(1) space?
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        
       boolean bool = false;

        //Arraylists are created to compare 2 different Strings
        //I prefered arraylist to add and remove
        ArrayList<Character> arraylistS = new ArrayList<Character>();
        ArrayList<Character> arraylistF = new ArrayList<Character>();
        
        AddArrayList(S , arraylistS);
        AddArrayList(T , arraylistF);
        
        
        BackSpace(arraylistS);
        BackSpace(arraylistF);
   
        //final condition for comparing two strings in arraylists
        if(arraylistS.equals(arraylistF)){
            bool = true;
        }
        
         return bool;
        
     }
     
     static void AddArrayList(String S , ArrayList<Character> arraylistS){
        
         //char array is necessary to manipulate characters in the string
        char[] charS = S.toCharArray();
        
         //this loop add chars to arraylist
        //max element is defined in question
        for(int i = 0 ; i<200 ; i++){
            
            if(i < charS.length){

                arraylistS.add(charS[i]);
            }
        }  
     }
     
     
     static void BackSpace(ArrayList<Character> arraylistS){
         
         //this loop adds and removes chars based on backspace (#)
         for(int i = 0; i<200 ; i++){
            
            if(i < arraylistS.size()){
                
                if(arraylistS.get(i) == '#'&& i>0){
                    arraylistS.remove(i);
                    arraylistS.remove(i-1);
                    i-=2;
                }else if(arraylistS.get(i) == '#'&& i==0){
                     arraylistS.remove(i);
                     i--;
                    
                }
            }
        
        }
    }
}
