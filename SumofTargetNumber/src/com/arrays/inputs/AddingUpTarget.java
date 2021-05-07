package com.arrays.inputs;

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

}