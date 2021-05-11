package com.arrays.inputs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AddingUpTarget {

	public static int[] findTarget(int[] input, int target) {
		//for loop 1
		int[] output = new int[0];
		for (int i = 0; i < input.length; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] + input[j] == target)
					output = new int[] { i, j };

			}
		}
		return output;
	}

	public static int[] findTwoSum(int[] input, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length; i++) {
			int output = target - input[i];
			if (map.containsKey(output)) {
				return new int[] { map.get(output), i };
			} else {
				map.put(input[i], i);
			}
		}
		return new int[] {};
	}

	public static int[] findSum(int[] input, int target) {
		for (int i = 0; i < input.length; i++) {
			int arr = (input.length - 1) - i;
			int arr1 = input.length - arr;
			if (input[i] + input[arr] == target)
				return new int[] { i, arr };

			else if (input[i] + input[arr1] == target)
				return new int[] { i, arr1 };
		}
		return new int[] { 0 };
	}

	public static int[] findingSum(int[] input, int target) {
		Arrays.sort(input);
		int left = 0;
		int right = input.length - 1;
		for (int i = 0; i < input.length; i++) {
			if (input[left] + input[right] == target)
				return new int[] { left, right };
			else if (input[left] + input[right] < target)
				left++;
			else if (input[left] + input[right] > target)
				right--;

		}

		return new int[] { 0 };
	}

}
