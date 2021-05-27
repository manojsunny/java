package com.example.main;

import java.util.Arrays;
import java.util.Scanner;

import com.example.sum.SumOfArrays;


public class ExampleApplication {
			

		public static void main(String[] args) {
			//create scanner object
			Scanner sc = new Scanner(System.in);
			//enter length of array
			System.out.println("Enter length of Array ");
			int n = sc.nextInt();
			//array object
			int[] input = new int[n];
			//input elements
			for (int i = 0; i < input.length; i++) {
				System.out.println("Enter Element " + i);
				input[i] = sc.nextInt();
			}
	
			System.out.println(Arrays.toString(input));
			
			//enter target value
			System.out.println("Enter target ");
			int target = sc.nextInt();
	
			//get dependency object
		
			System.out.println(SumOfArrays.sumOfTarget(input, target));
			System.out.println(SumOfArrays.fourSum(input, target));
			
		}

}
