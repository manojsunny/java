package com.example.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumOfArrays {
	
	/*
	 * input : [9, 6, 5, 5, 5, 4, 3, 3, 2, 2]
	 * output : [[2, 2, 4, 6], [2, 2, 5, 5], [2, 3, 3, 6], [2, 3, 4, 5]]
	 * 
	 * input : [0, 3, 5, 4, 2, 1]
	 * output : [[0, 1, 4, 5], [0, 2, 3, 5], [1, 2, 3, 4]]
	 * 
	 * input : [4, 32, 5, 6, 1, 3, 1, 9, 8, 7]
	 * output : [[1, 1, 3, 5]]
	 * 
	 * Time Complexity: nlogn + n3
	 * 					 
	 * */
	
	public static List<List<Integer>> fourSum(int[] num, int target) {

		Arrays.sort(num);
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int i = 0;
		while (i < num.length - 3) {
			int j = i + 1;
			while (j < num.length - 2) {
				int k = j + 1, l = num.length - 1;
				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
					if (sum > target) {
						l--;
						while (k < l && num[l] == num[l + 1])
							l--;
					} else if (sum < target) {
						k++;
						while (k < l && num[k] == num[k - 1])
							k++;
					} else {
						ArrayList<Integer> list = new ArrayList<Integer>(4);
						list.add(num[i]);
						list.add(num[j]);
						list.add(num[k]);
						list.add(num[l]);
						result.add(list);
						k++;
						while (k < l && num[k] == num[k - 1])
							k++;
						l--;
						while (k < l && num[l] == num[l + 1])
							l--;
					}
				}
				j++;
				while (j < num.length && num[j] == num[j - 1])
					j++;
			}
			i++;
			while (i < num.length && num[i] == num[i - 1]) {
				i++;
			}
		}

		return result;
	}


	/*
	 * input : [9, 6, 5, 5, 5, 4, 3, 3, 2, 2]
	 * output : [[2, 2, 4, 6], [2, 2, 5, 5], [2, 3, 3, 6], [2, 3, 4, 5]]
	 * 
	 * input : [0, 3, 5, 4, 2, 1]
	 * output : [[0, 1, 4, 5], [0, 2, 3, 5], [1, 2, 3, 4]]
	 * 
	 * input : [4, 32, 5, 6, 1, 3, 1, 9, 8, 7]
	 * output : [[1, 1, 3, 5]]
	 * 
	 * Time Complexity : nlogn + n3
	 * 					 
	 * */
                                                   
	public static List<List<Integer>> sumOfTarget(int[] num, int target) {
		Arrays.sort(num);
		Set<List<Integer>> hSet = new HashSet<List<Integer>>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				for (int k = j + 1, l = num.length - 1; k < l;) {
					int sum = num[i] + num[j] + num[k] + num[l];
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> innerList = new ArrayList<Integer>();
						innerList.add(num[i]);
						innerList.add(num[j]);
						innerList.add(num[k]);
						innerList.add(num[l]);
						if (!hSet.contains(innerList)) {
							hSet.add(innerList);
							result.add(innerList);
						}

						k++;
						l--;

					}
				}
			}
		}
		return result;
	}
	
	
}
