package com.dadamagic.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
	
	static Map< Integer, String> valueMap = new HashMap <Integer, String>();
	
	static {
		valueMap.put(1, "I");
		valueMap.put(2, "II");
		valueMap.put(3, "III");
		valueMap.put(4, "IV");
		valueMap.put(5, "V");
		valueMap.put(6, "VI");
		valueMap.put(7, "VII");
		valueMap.put(8, "VIII");
		valueMap.put(9, "IX");		
		valueMap.put(10, "X");
		valueMap.put(20, "XX");
		valueMap.put(30, "XXX");
		valueMap.put(40, "XL");
		valueMap.put(50, "L");
		valueMap.put(60, "LX");
		valueMap.put(70, "LXX");
		valueMap.put(80, "LXXX");
		valueMap.put(90, "XC");
		valueMap.put(100, "C");
		valueMap.put(200, "CC");
		valueMap.put(300, "CCC");
		valueMap.put(400, "CD");
		valueMap.put(500, "D");
		valueMap.put(600, "DC");
		valueMap.put(700, "DCC");
		valueMap.put(800, "DCCC");
		valueMap.put(900, "CM");
		valueMap.put(1000, "M");
	}
	public String intToRoman(int num) {		
		
		StringBuilder sb = new StringBuilder();		
		int val = 0;
		int bal = 0;
		int c = 0;
		
		bal = num % 10;
		val = num - bal;
		if(bal > 0) {
			sb.insert(0,valueMap.get(bal));
		}
		
		if (val > 0 ) {
			
			bal = val % 100;
			val = val - (bal);
			if(bal > 0) {
				sb.insert(0,valueMap.get(bal));
			}
			if (val > 0 ) {
				
				bal = val % 1000;
				val = val - (bal );
				if(bal > 0) {
					sb.insert(0,valueMap.get(bal));
				}
				
				int finalVal = val /1000;
				for (; c < finalVal; c++) {
					sb.insert(0, "M");
				}			
			}
			
		}
		
				
		return sb.toString();        
    }
	
	 public int mySqrt(int x) {
		 
		 int val = (int) Math.floor(Math.sqrt(x));
		 return val;
	        
	 }
	
	public String addBinary(String a, String b) {
		
		String leaderString =  "";
		String nonLeaderString =  "";
		
		if(a.length() > b.length()) {
			leaderString = a;
			nonLeaderString = b;
		}else {
			leaderString = b;
			nonLeaderString = a;
		}		
		int leaderStrLen = leaderString.length();
		
		StringBuilder sb = new StringBuilder();
		while (sb.length() < leaderStrLen - nonLeaderString.length()) {
		        sb.append('0');
		}
		sb.append(nonLeaderString);
		nonLeaderString = sb.toString();
		
		int balance = 0;
		
		StringBuilder sbReturn = new StringBuilder();
		    
		for(int c = leaderStrLen - 1; c >=0; c--) {
			
			int val1 = Character.getNumericValue(leaderString.charAt(c));
			int val2 = Character.getNumericValue(nonLeaderString.charAt(c));
			int resultVal = val1 ^ val2 ^ balance;
			int addVal = val1 + val2 + balance;
			
			if(addVal >  1 ) {
				balance = 1;
			}else {
				balance = 0;
			}
			sbReturn.append(resultVal);
		}
		
		if(balance > 0) {
			sbReturn.append(balance);
		}
		
		return sbReturn.reverse().toString();

		
//		int totalVal = decimal1 + decimal2;
//		return Integer.toBinaryString(totalVal);
	
		
		
        
    }
	
	 public int[] plusOne(int[] digits) {
		 
		
		 
		 
		 boolean balance = true;
		 
		 for(int count = digits.length -1; count >=0; count--) {
			 
			 int val = digits [count];
			 if(balance ) {		
				 
				 val = val + 1;
				 if(val >  9 ) {
					 digits[count] = 0;
					 balance = true;					 
				 }else {
					 
					 digits[count] = val;
					 balance = false;
					 break;
				 }
			 }		
		 }
		 if(balance) {
			
			int [] returnList = new int[digits.length + 1];
			System.arraycopy(digits, 0, returnList, 1, digits.length);
			returnList[0] = 1;
			return returnList;
		 }else {
			 return digits;
		 }
		
	        
	 }
	
	public int lengthOfLastWord(String s) {
		
		String[] words = s.split(" ");		
		String lastWord = words [words.length - 1];
		return lastWord.length();
        
    }
	
	 public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 
		 double medianVal = 0.0;
		 int lenNums1 = nums1.length;
		 int lenNums2 = nums2.length;
		 int totalLen = lenNums1 + lenNums2;
		 int overallMedian = totalLen / 2;
		 int cut1 = overallMedian % 2 == 0 ? overallMedian / 2 : (overallMedian / 2 + 1);
		 int cut2 = overallMedian - cut1;
		 
		 if(lenNums1 >= lenNums2) {		 
			 
			 return getMedian(nums1, nums2,  cut1, cut2, lenNums1, lenNums2);
			 
		 }else {		
			 
			 return getMedian(nums2, nums1,  cut1, cut2, lenNums1, lenNums2);
			 
		 }	
	        
	 }
	 
	 private double getMedian(int[] nums1, int[] nums2, int cut1, int cut2, int lenNums1, int lenNums2) {
		 
		
		 int firstInIdx = -0 ;
		 int firstOutIdx = -0 ;
		 int secondInIdx =  -0;
		 int secondOutIdx =  -0;
		 double medianVal = 0.0;
		 
		 if(cut1 > 0 && cut1 <= lenNums1) {
			 firstInIdx = nums1 [cut1 - 1] ;
		 }
		 if(cut1 >= 0 && cut1 < lenNums1) {
			 firstOutIdx = nums1 [cut1] ;
		 }		 
		 if(cut2 > 0 && cut2 <= lenNums2) {
			 secondInIdx = nums2 [cut2 - 1];
		 }
		 if(cut2 >= 0 && cut2 < lenNums2) {
			 secondOutIdx = nums2 [cut2] ;
		 }
		 
		 if(cut2 >= lenNums2 || cut1 < 0) {
			 if( (lenNums1 + lenNums2) %2 != 0) {
				 
				 medianVal = Math.min(firstOutIdx, secondOutIdx);
			 }else {
				 double val1 = firstOutIdx;
				 double val2 =  secondOutIdx;
				 medianVal = (val1 + val2) / 2;
			 }
			 return medianVal;				 
		 }else if(cut1 >= lenNums1 || cut2 < 0) {
			 if( (lenNums1 + lenNums2) %2 != 0) {
				 medianVal = Math.min(firstOutIdx, secondOutIdx);
			 }else {
				 double val1 = firstOutIdx;
				 double val2 =  secondOutIdx;
				 medianVal = (val1 + val2) / 2;
			 }
			 return medianVal;
		 }
		 
		 if(firstInIdx != -0 && secondOutIdx != -0 && firstInIdx > secondOutIdx) {
			 
			 cut1 = cut1 - 1;
			 cut2 = cut2 + 1;
			 return getMedian( nums1,  nums2,  cut1,  cut2, lenNums1, lenNums2);
			 
			 
		 }else if (firstOutIdx != -0 && firstOutIdx != -0 && secondInIdx > firstOutIdx) {
			 
			 cut1 = cut1 + 1;
			 cut2 = cut2 - 1;
			 return getMedian( nums1,  nums2,  cut1,  cut2, lenNums1, lenNums2);
			 
		 }else {
			 
			 if( (lenNums1 + lenNums2) %2 != 0) {
				 medianVal = Math.min(firstOutIdx, secondOutIdx);
			 }else {
				 double val1 = firstOutIdx;
				 double val2 =  secondOutIdx;
				 medianVal = (val1 + val2) / 2;
			 }
			 return medianVal;
		 }
		 
		 
		 
	 }
	
	 public boolean isValid(String s) {
		 
		 Stack <String> keeper = new Stack<String>();
		 String val = null;
		 
		 char[] characters = s.toCharArray();
		 for(char c : characters) {			 
			 switch (c) {
				 case '(':
					 keeper.push("(");
				 break;
				 case '[':
					 keeper.push("[");
				 break;
				 case '{':
					 keeper.push("{");
				 break;
				 case ')':
					 if(keeper.empty())
						 return false;
					 val = keeper.pop();
					 if ( !val.equals("(")) {
						 return false;
					 }
				 break;
				 case ']':
					 if(keeper.empty())
						 return false;
					 val = keeper.pop();
					 if (!val.equals("[")) {
						 return false;
					 }
				 break;
				 case '}':
					 if(keeper.empty())
						 return false;
					 val = keeper.pop();
					 if ( !val.equals("{")) {
						 return false;
					 }
				 break;
			 }				 
				
		 }
		 if(keeper.empty()) {
			 return true;
		 }else {
			 return false;
		 }
	 }
	
	public boolean isPalindrome(int x) {
		
		int digit = 0;
		boolean paliandromeFlag = true;
		List<Integer> valList = new ArrayList<Integer>(20);
		
		if(x < 0) {
			paliandromeFlag = false;
		}
    	
    	
    	
    	
    	
    	for (;;) {    		 		
    		
    		digit = x % 10;
    		x = x / 10;
    		valList.add(digit);
    		if(x == 0) {
    			break;
    		}    		
    	}
    	
    	int max = valList.size();
    	for(int count = 0; count < max; count++ ) {
    		if(valList.get(count) != valList.get((max-1) - count)) {
    			paliandromeFlag = false;
    		}
    	}
    	
    	return paliandromeFlag;
    	
    }
	
	
    public int[] twoSum (int[] nums, int target) {
    	
        int outVar[] = new int[2];
        
        test : for(int count = 0; count < nums.length; count++ ){
            
            int var1 = nums[count];
          //  if(var1 <= target){
                int var2 = target - var1;
                for(int count1 = 0; count1 < nums.length; count1++ ){
                    if(var2 ==  nums[count1] && count != count1){
                        outVar[0] = count;
                        outVar[1] = count1;
                        break test;
                    }
                }
           // }
        }
        
        return outVar;
        
    }
    
    
    
    public static void main(String args[]) {
    	
//    	int[] src = new int[] {-1, -2, -3, -4, -5};
//    	
//    	int[] out = new Solution().twoSum(src, -8);
//    	
//    	for(int val : out) {
//    		System.out.println(""+out);
//    	}
//    	
//    	new Solution().isPalindrome(2147483646);
    	
    	int[] array1 = new int[] {9,9,9,9};
    	int[] array2 = new int[] {3,4};
    	
//    	int [] array3 = new Solution().addBinary("11", "1");
    	
//    	for(int v : array3) {
//    		System.out.println ("Value - " + v);
//    	}
    	
//    	System.out.println ("Length of last word - " + new Solution().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 
//    			"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
//    	
    	Long x1 = 2147483646l;
    	
    	System.out.println ("Length of last word - " +new Solution().intToRoman(400) );
//    	Long x2 = 6463847412l;
//    	
//    	byte b1 = x1.byteValue();
//    	byte b2 = x2.byteValue();
//    	
//    	System.out.println(b1);
//    	System.out.println(b2);
    	
    }
}