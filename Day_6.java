/*
Given an array of strings, group anagrams together.
Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
All inputs will be in lowercase.
The order of your output does not matter
*/


//This is the first solution that I implemented but timeouts for the 100.th case out of 101
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> list= new ArrayList<List<String>>(); 
         ArrayList<Integer> list2 = new ArrayList<Integer>();            

           
            
        for(int i = 0; i < strs.length; i++){
            if (list2.contains(i)) continue;
            
            List<String> list3 = new ArrayList<String>(); 
            char [] a  = strs[i].toCharArray();
            Arrays.sort(a);
            

            
            for(int j = i; j < strs.length; j++){
                
                char [] b  = strs[j].toCharArray();
                Arrays.sort(b);
                
                if (Arrays.equals(a,b)){
                    
                    if(list2.contains(j) == true){
                        break;
                    }else{
                        list3.add(strs[j]);
                        list2.add(j);
                    }
                    
                }
            
            }
            
            if(list3.isEmpty()==true){
                continue;
            }            
            list.add(list3);
             //System.out.println(list);
             //list.clear();
            
        }
        return list;

        }
       
    }


//This is the second solution that I found implemented by someone else and shared to public which does not timeout

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) {
                ans.put(key, new ArrayList());
            }
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());

        }        
        
    }
