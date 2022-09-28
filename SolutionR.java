package com.dadamagic.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class SolutionR {
	
	public String longestCommonPrefix(String[] strs) {
		
		String retVal = "";
		int shorttestLen = 500;
		
		for(String strVal : strs) {
			
			if (shorttestLen >  strVal.length()) {				
				shorttestLen = strVal.length();
			}
		}
		
		if(shorttestLen != 500 && shorttestLen != 0) {
			
			for(int idx = 0; idx <shorttestLen; idx++ ) {			
				Character sampleC = strs [0].charAt(idx);
				for(int idx1 = 1; idx1 <strs.length; idx1++ ) {
					if(sampleC !=  strs[idx1].charAt(idx)) {
						return retVal;
					}
				}
				retVal = retVal.concat(""+sampleC);
				
			}
		}
		
		return retVal;
        
    }
	
	Map<Character, Integer> valueMap = new HashMap <Character, Integer>();
	public int romanToInt(String s) {
		
		valueMap.put('I',1);
		valueMap.put('V',5);
		valueMap.put('X',10);
		valueMap.put('L',50);
		valueMap.put('C',100);
		valueMap.put('D',500);
		valueMap.put('M',1000);
		
		boolean oneAdd = true;
		boolean tenAdd = true;
		boolean hundredAdd = true;
	
		int value = 0;
		int idx = s.length() - 1;
		
		
		
		for(; idx >= 0; idx--) {
			
			char c = s.charAt(idx);			
			int valFromMap = valueMap.get(c);
			
			if(c == 'I' && !oneAdd ) {
				valFromMap *= -1;
			}else if(c == 'X' && !tenAdd ) {
				valFromMap *= -1;
			}else if(c == 'C' && !hundredAdd ) {
				valFromMap *= -1;
			}
			
			value += valFromMap;
			
			if(oneAdd && (c == 'V' || c == 'X')) {
				oneAdd = false;
			}else if((tenAdd) && (c == 'L' || c == 'C')) {
				tenAdd = false;
			}else if((hundredAdd) && (c == 'D' || c == 'M')) {
				hundredAdd = false;
			}
		}
		
		
		return value;
        
    }
	
	public int removeDuplicates(int[] nums) {
		
	LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
    for (int i = 0; i < nums.length; i++) {
        set.add(nums[i]);
    }
    
    int len = set.size();
    int count = 0;
    Iterator itr = set.iterator();
    while (itr.hasNext()) {
        nums[count++] = (Integer)itr.next();
    }
    
    return len;
    
    }
	
	public int removeElement(int[] nums, int val) {
		
		int counter = 0;
		int[] newArray = new int [nums.length];
		
		for(int genCounter = 0; genCounter < nums.length; genCounter++) {
			
			int num = nums [genCounter]; 
			if(num != val) {
				newArray[counter++] = num;
			}
		}
		for(int c = 0; c < nums.length; c++) {			
			nums[c] = newArray[c];
		}		
		
		return counter;
        
    }

	public static void main(String s[]) {
		
		String[] strs =  new String[] {""};
		int[] nums = new int [] {1,1,2};
		
		System.out.println(new SolutionR().removeElement(nums, 2));
		
		for(int c = 0; c < nums.length; c++) {
			System.out.println( "nums again  " + nums [c]);
		}
		
		
	}

}
