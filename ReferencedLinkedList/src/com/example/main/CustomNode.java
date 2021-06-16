package com.example.main;

import com.example.node.Node;
import com.example.reference.list.ReferencedLinkedList;

public class CustomNode {
	
	public static void main(String[] args) {
		//create node object
		Node node = new Node(1);
		node.next = new Node(0);
		node.next.next = new Node(1);
		
		int value = ReferencedLinkedList.getDecimalValue(node);
		System.out.println("Decimal value : "+value);
	}

}
