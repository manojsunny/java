package com.main;

import java.util.Scanner;

import com.arrays.inputs.AddingUpTarget;

public class SumOfTwoNumbers {

	public static void main(String[] args) {

		//create scanner object
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of array ");
		int n = sc.nextInt();
		//create a new Array
		int[] input = new int[n];

		for (int i = 0; i < input.length; i++) {
			System.out.println("Enter input of index [" + i + "]");
			input[i] = sc.nextInt();
		}

		//target number
		System.out.println("Enter target value");
		int target = sc.nextInt();

		//invoke target equivalent method
		int[] output = AddingUpTarget.findingSum(input, target);

		//check output containing minimum of two indexes
		if (output.length == 2)
			System.out.println("[" + output[0] + ", " + output[1] + "]");

		else
			System.out.println("Result not Found");

		//close the scanner object
		sc.close();

	}
}
