import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class Longsubstring {
	
    public static int lengthOfLongestSubstring(String s) {
    	if (null == s)
    		return 0;
    	int len=0;
    	HashSet myset = new HashSet();
    	for(int i=0; i< s.length(); i++) {
    		int cursor = i;
    		while (cursor < s.length() && !myset.contains(s.charAt(cursor))) {
    			cursor++;
    		}
			if (myset.size() > len)
				len = myset.size();
    		myset.clear();
    	}
    	return len;
    }
    
    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
    
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    
    public static int findComplement(int num) {
        int mask=~0;
        while ((num & mask) != 0) mask <<=1;
        return ~mask & ~num;
    }
    
    public static String[] findWords(String[] words) {
    	List<String> returnArr = new ArrayList<String>();
        String[] keyboards = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i, j;
        for(i=0; i< keyboards.length; i++) {
        	for(j=0; j<keyboards[i].length(); j++)
        		map.put(keyboards[i].charAt(j), i);
        }
        for(i=0; i< words.length; i++) {
        	if (words[i].length() == 0)
        		continue;
        	String wordUp = words[i].toUpperCase();
        	int index = map.get(wordUp.charAt(0));
        	for(j=0; j<wordUp.length(); j++){
        		if (map.get(wordUp.charAt(j)) != index)
        			break;
        	}
        	if (j == wordUp.length()) {
        		returnArr.add(words[i]);
        	}
        }
        return returnArr.toArray(new String[returnArr.size()]);
    }
    
    public static List<String> fizzBuzz(int n) {
        List<String> forReturn = new ArrayList<String>();
        if (n<1)
        	return forReturn;
        for(int i=1; i<=n; i++) {
        	if (i%15 == 0)
        		forReturn.add("FizzBuzz");
        	else if (i%3 == 0)
        		forReturn.add("Fizz");
        	else if (i%5 == 0)
        		forReturn.add("Buzz");
        	else
        		forReturn.add(String.valueOf(i));
        }
        return forReturn;
    }
    public static String reverseString(String s) {
    	if(s == null || s.length() <= 1)
    		return s;
        char[] charArr = new char[s.length()];
        for(int i=s.length()-1; i>=0; i--) {
        	charArr[s.length()-1-i] = s.charAt(i);
        }
        return String.valueOf(charArr);
    }
    
    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        for (Integer num:nums) {
        	while (!stack.isEmpty() && stack.peek() < num) {
        		map.put(stack.pop(), num);
        	}
        	stack.push(num);
        }
        
        for(int i=0; i<findNums.length; i++) {
        	findNums[i] = map.getOrDefault(findNums[i], -1);
        }
        
        return findNums;
    }
    
    public static int islandPerimeter(int[][] grid) {
    	int island=0, edges=0;
        for(int i=0; i<grid.length; i++)
        	for (int j=0; j<grid[i].length; j++) {
        		if (grid[i][j] == 1) {
        			island++;
        			if (j!=grid[i].length-1 && grid[i][j+1] == 1)
        				edges++;
        			if (i!=grid.length-1 && grid[i+1][j] == 1)
        				edges++;
        		}
        	}
        return (4*island-2*edges);
    }
    
    public static boolean canWinNim(int n) {
        if(n<=3)
        	return true;
        if (canWinNim(n-1) && canWinNim(n-2) && canWinNim(n-3))
        	return false;
        return true;
    }
    
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0, maxtemp=0;
        for(int n:nums){
        	if (n==0)
        		maxtemp=0;
        	else
        		maxtemp++;
        	max = max<maxtemp?maxtemp:max;
        }
        return max;
    }
    
    public static int singleNumber(int[] nums) {
        int result=0;
        for (int num:nums)
        	result ^= num;
        return result;
    }
    
    public static boolean detectCapitalUse(String word) {
    	int capital=0;
        for(int i=0; i<word.length();i++) {
        	if (word.charAt(i)>='A' && word.charAt(i)<='Z') {
        		capital++;
        	}
        }
        if(capital == word.length() || capital == 0 || 
        		(capital==1 && word.charAt(0)>='A' && word.charAt(0)<='Z'))
        	return true;
        return false;
    }
    
    public static void main(String[] args) {
    	String str="USA";
    	int[] bb={4,1,2};
    	int[] aa={1,1,0,1,1,1};
//    	int[][] cc={{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
//    	System.out.print(lengthOfLongestSubstring2(str));
//    	String[] words = {"Hello", "Alaska", "Dad", "Peace"};
    	System.out.print(detectCapitalUse(str));
    }
}