package com.example.reference.list;

import com.example.node.Node;

public class ReferencedLinkedList {
	
	/*
	 * Time compexilty : n+1
	 * 
	 * 	O(n)*/
	
	public static int getDecimalValue(Node node) {
		int i = node.value;
		while(node.next != null) {         // --------> n+1
			i = (i*2)+node.next.value;
			node = node.next;
		}
		
		return i;
	}

}
