package com.dadamagic.action;

import java.util.Arrays;

public class TempSolution {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		 
		 
		 
		 int one = nums1.length;        //determines length of firstArray  
		 int two = nums2.length;   //determines length of secondArray  
		 int total = one + two;
		 int[] result = new int[ total ];  //resultant array of size first array and second array  
		 System.arraycopy(nums1, 0, result, 0, one);  
		 System.arraycopy(nums2, 0, result, one, two);  
		 
		 Arrays.sort(result);
		 
		 if(total % 2 == 0) {
			 
			 double val1 = result [total/2 - 1];
			 double val2 =  result [total/2];
			 
			 return  (val1 + val2) / 2;
			 
			 
		 }else {
			 
			 double val2 =  result [total/2];
			 return val2;
		 }
		 
	        
	 }
	
	public static void main (String args[]) {
		
		int[] array1 = new int[] {1,3};
    	int[] array2 = new int[] {2};
		
		System.out.println( new TempSolution().findMedianSortedArrays(array1, array2));
	}

}
