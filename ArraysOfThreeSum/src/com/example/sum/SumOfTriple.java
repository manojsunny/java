package com.example.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfTriple {
	
	private static SumOfTriple INSTANCE;
	
	private SumOfTriple() {
		
	}
	
	public static SumOfTriple getInstance() {
		if(INSTANCE == null)
			INSTANCE = new SumOfTriple();
		return INSTANCE;
	} 

	public List<List<Integer>> threeSum(int[] nums, int target) {
	    Arrays.sort(nums);
	 
	    ArrayList<List<Integer>> result = new ArrayList<>();
	 
	    for (int i = 0; i < nums.length; i++) {
	        int j = i + 1;
	        int k = nums.length - 1;
	 
			 if (i > 0 && nums[i] == nums[i - 1]) {
			    continue;
			}
	 
	        while (j < k) {
				if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
				    k--;
				    continue;
				}
	 
	            if (nums[i] + nums[j] + nums[k] > target) {
	                k--;
	            } else if (nums[i] + nums[j] + nums[k] < target) {
	                j++;
	            } else {
	                ArrayList<Integer> l = new ArrayList<>();
	                l.add(nums[i]);
	                l.add(nums[j]);
	                l.add(nums[k]);
	                result.add(l);
	                j++;
	                k--;
	            }
	        }
	    }
	 
	    return result;
	}
}
