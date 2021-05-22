package com.example.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfTriple {

	private static SumOfTriple INSTANCE;

	private SumOfTriple() {

	}

	public static SumOfTriple getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SumOfTriple();
		return INSTANCE;
	}
	
	

	/*Brute Force solution logic 1
	
	input : [6, 3, 2, 4, -9, -4, 3, 5, 4, 3]
	output : [[3, 2, 4], [3, 2, 4], [3, 3, 3], [2, 4, 3], [2, 4, 3], [2, 3, 4], [2, 4, 3]]	
	
	input : [2, 3, -4, 6, 2, 5]
	output :[[3, -4, 6]]
	
	input : [23, 56, 45, 1, 2, 65, 89, 23, 45, 25, 78, -89, -65, 47, -25, -3, -65, 65, 89, 12]
	output : [[23, 65, 12], [23, 65, 12], [56, 47, -3], [65, 23, 12], [23, 65, 12], [25, 78, -3], [78, 47, -25]]
	
	input : [0, -1, -1, 1, 2, 4]
	output : [[0, -1, 1], [0, -1, 1], [-1, -1, 2]]

	input : [1, 25, 3, 6, 4, 8, 6] 
	output : [[6, 4, 8], [4, 8, 6]]

	Time complexity = O(n3)
	
	*/
			
	public List<List<Integer>> threeSumOfTarget(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j < nums.length; j++) {
				for (int k = j; k < nums.length; k++) {
					if (i != j && j != k && i != k && (nums[i] + nums[j] + nums[k] == target)) {
						List<Integer> innerlist = new ArrayList<Integer>(3);
						innerlist.add(nums[i]);
						innerlist.add(nums[j]);
						innerlist.add(nums[k]);
						list.add(innerlist);
					}
				}
			}
		}
		return list;
	}

	/* logic 2
	  	input : [6, 3, 2, 4, -9, -4, 3, 5, 4, 3]
	   	output : [[2, 3, 4], [2, 3, 4], [3, 3, 3]]
	   	
	   	input : [2, 3, -4, 6, 2, 5]
		output :[[-4, 3, 6]]
		
		input : [23, 56, 45, 1, 2, 65, 89, 23, 45, 25, 78, -89, -65, 47, -25, -3, -65, 65, 89, 12]
		output : [[-25, 47, 78], [-3, 25, 78], [-3, 47, 56], [12, 23, 65], [12, 23, 65]]
		
		input : [0, -1, -1, 1, 2, 4]
		output : [[-1, -1, 2], [-1, 0, 1], [-1, 0, 1]]
		
		input : [1, 25, 3, 6, 4, 8, 6]
		output : [[4, 6, 8]]
		
		time complexity = nlogn + n2 + n + 1

	*/
	public List<List<Integer>> findingThreeSum(int[] input, int target) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		Arrays.sort(input);
		for (int i = 0; i < input.length; i++) {
			int left = i + 1;
			int right = input.length - 1;
			while (left < right) {
				if (input[i] + input[left] + input[right] == target) {
					ArrayList<Integer> innerlist = new ArrayList<>();
					innerlist.add(input[i]);
					innerlist.add(input[left]);
					innerlist.add(input[right]);
					list.add(innerlist);
					left++;
					right--;
				} else if (input[i] + input[left] + input[right] > target)
					right--;
				else if (input[i] + input[left] + input[right] < target)
					left++;

			}

		}
		return list;
	}
	
	/* logic 3 
	 * comparing to previous logic this logic is not allowing duplicate set
	  	input : [6, 3, 2, 4, -9, -4, 3, 5, 4, 3]
	   	output : [[2, 3, 4], [2, 3, 4], [3, 3, 3]]
	   	
	   	input : [2, 3, -4, 6, 2, 5]
		output :[[-4, 3, 6]]
		
		input : [23, 56, 45, 1, 2, 65, 89, 23, 45, 25, 78, -89, -65, 47, -25, -3, -65, 65, 89, 12]
		output : [[-25, 47, 78], [-3, 25, 78], [-3, 47, 56], [12, 23, 65], [12, 23, 65]]
		
		input : [0, -1, -1, 1, 2, 4]
		output : [[-1, -1, 2], [-1, 0, 1]]
		
		input : [1, 25, 3, 6, 4, 8, 6]
		output : [[4, 6, 8]]

		time complexity = nlogn + n2 + n + 1

	 */

	public List<List<Integer>> threeSum(int[] nums, int target) {
		Arrays.sort(nums);

		List<List<Integer>> result = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			while (j < k) {
				/*if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
				    k--;
				    continue;
				}*/

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
