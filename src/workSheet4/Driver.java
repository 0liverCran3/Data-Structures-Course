package worksheet4;

import support.LLNode;

public class Driver {

	public static void main(String[] args) {
		
		
		SingleLL<String> node1 = new SingleLL<String>();
		
		node1.addFront("bill");
		node1.addFront("gill");
		node1.addFront("hill");
		System.out.println(node1.getNumElements());
		System.out.println(node1.toString());
		
		node1.removeFront();
		System.out.println(node1.getNumElements());
		System.out.println(node1.toString());
		
		node1.addLast("yoyoyoyoyoyoyoyooy");
		System.out.println(node1.getNumElements());
		System.out.println(node1.toString());
		
		node1.removeFront();
		System.out.println(node1.getNumElements());
		System.out.println(node1.toString());
		
	}
	
}
