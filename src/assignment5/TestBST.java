package assignment5;

public class TestBST {
	
	public static void main(String[] args) {
		BinarySearchTree<String> tree = new BinarySearchTree<String>();
		BinarySearchTree<String> shrub = new BinarySearchTree<String>();
		
		tree.add("H");
		tree.add("D");
		tree.add("B");
		tree.add("E");
		tree.add("T");
		tree.add("Z");
		tree.add("J");
		
		shrub.add("H");
		shrub.add("D");
		
		
		System.out.println("\nBoth BST's are identical: "+shrub.isIdentical(tree));
		System.out.println("\nLeaf nodes are... ");
		tree.printLeafNodes();
		System.out.println("\nNumber of child nodes: "+tree.numChildNodes());
		System.out.println("\nThe BST is full: "+tree.isFullBinaryTree());
		System.out.println("\nThe 5th largest value is: "+tree.getNthLargest(5));
	}
	
}
