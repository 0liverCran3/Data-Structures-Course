/**COSC 2100 –Fall2020
 *Assignment#5
 *<I added 5 methods that give insight on the BinarySearchTree>
 * @author <Oliver Crane>
 */

package assignment5;

//----------------------------------------------------------------------------
//BinarySearchTree.java          by Dale/Joyce/Weems                Chapter 7
//
//Defines all constructs for a reference-based BST
//----------------------------------------------------------------------------

import assignment3.LinkedStack;
import support.BSTNode;      

public class BinarySearchTree<T extends Comparable<T>> implements BSTInterface<T>{
	protected BSTNode<T> root;      // reference to the root of this BST

	boolean found;   // used by remove

	// for traversals
	protected LinkedQueue<T> inOrderQueue;    // queue of info
	protected LinkedQueue<T> preOrderQueue;   // queue of info
	protected LinkedQueue<T> postOrderQueue;  // queue of info

	public BinarySearchTree()
	// Creates an empty BST object.
	{
		root = null;
	}

	public boolean isEmpty()
	// Returns true if this BST is empty; otherwise, returns false.
	{
		return (root == null);
	}

	private int recSize(BSTNode<T> node)
	// Returns the number of elements in tree.
	{
		if (node == null)    
			return 0;
		else
			return recSize(node.getLeft()) + recSize(node.getRight()) + 1;
	}

	public int size()
	// Returns the number of elements in this BST.
	{
		return recSize(root);
	}

	public int size2()
	// Returns the number of elements in this BST.
	{
		int count = 0;
		if (root != null)
		{
			LinkedStack<BSTNode<T>> hold = new LinkedStack<BSTNode<T>>();
			BSTNode<T> currNode;
			hold.push(root);
			while (!hold.isEmpty())
			{
				currNode = hold.top();
				hold.pop();
				count++;
				if (currNode.getLeft() != null)
					hold.push(currNode.getLeft());
				if (currNode.getRight() != null)
					hold.push(currNode.getRight());
			}
		}
		return count;
	}

	private boolean recContains(T element, BSTNode<T> node)
	// Returns true if tree contains an element e such that 
	// e.compareTo(element) == 0; otherwise, returns false.
	{
		if (node == null)
			return false;       // element is not found
		else if (element.compareTo(node.getInfo()) < 0)
			return recContains(element, node.getLeft());   // Search left subtree
		else if (element.compareTo(node.getInfo()) > 0)
			return recContains(element, node.getRight());  // Search right subtree
		else
			return true;        // element is found
	}

	public boolean contains (T element)
	// Returns true if this BST contains an element e such that 
	// e.compareTo(element) == 0; otherwise, returns false.
	{
		return recContains(element, root);
	}

	private T recGet(T element, BSTNode<T> node)
	// Returns an element e from tree such that e.compareTo(element) == 0;
	// if no such element exists, returns null.
	{
		if (node == null)
			return null;             // element is not found
		else if (element.compareTo(node.getInfo()) < 0)
			return recGet(element, node.getLeft());          // get from left subtree
		else
			if (element.compareTo(node.getInfo()) > 0)
				return recGet(element, node.getRight());         // get from right subtree
			else
				return node.getInfo();  // element is found
	}

	public T get(T element)
	// Returns an element e from this BST such that e.compareTo(element) == 0;
	// if no such element exists, returns null.
	{
		return recGet(element, root);
	}

	private BSTNode<T> recAdd(T element, BSTNode<T> node)
	// Adds element to tree; tree retains its BST property.
	{
		if (node == null)
			// Addition place found
			node = new BSTNode<T>(element);
		else if (element.compareTo(node.getInfo()) <= 0)
			node.setLeft(recAdd(element, node.getLeft()));    // Add in left subtree
		else
			node.setRight(recAdd(element, node.getRight()));   // Add in right subtree
		return node;
	}

	public void add (T element)
	// Adds element to this BST. The tree retains its BST property.
	{
		root = recAdd(element, root);
	}

	private T getPredecessor(BSTNode<T> node)
	// Returns the information held in the rightmost node in tree
	{
		while (node.getRight() != null)
			node = node.getRight();
		return node.getInfo();
	}

	private BSTNode<T> removeNode(BSTNode<T> node)
	// Removes the information at the node referenced by tree.
	// The user's data in the node referenced by tree is no
	// longer in the tree.  If tree is a leaf node or has only
	// a non-null child pointer, the node pointed to by tree is
	// removed; otherwise, the user's data is replaced by its
	// logical predecessor and the predecessor's node is removed.
	{
		T data;

		if (node.getLeft() == null)
			return node.getRight();
		else if (node.getRight() == null) 
			return node.getLeft();
		else
		{
			data = getPredecessor(node.getLeft());
			node.setInfo(data);
			node.setLeft(recRemove(data, node.getLeft()));  
			return node;
		}
	}

	private BSTNode<T> recRemove(T element, BSTNode<T> node)
	// Removes an element e from tree such that e.compareTo(element) == 0
	// and returns true; if no such element exists, returns false. 
	{
		if (node == null)
			found = false;
		else if (element.compareTo(node.getInfo()) < 0)
			node.setLeft(recRemove(element, node.getLeft()));
		else if (element.compareTo(node.getInfo()) > 0)
			node.setRight(recRemove(element, node.getRight()));
		else  
		{
			node = removeNode(node);
			found = true;
		}
		return node;
	}

	public boolean remove (T element)
	// Removes an element e from this BST such that e.compareTo(element) == 0
	// and returns true; if no such element exists, returns false. 
	{
		root = recRemove(element, root);
		return found;
	}

	private void inOrder(BSTNode<T> node)
	// Initializes inOrderQueue with tree elements in inOrder order.
	{
		if (node != null)
		{
			inOrder(node.getLeft());
			inOrderQueue.enqueue(node.getInfo());
			inOrder(node.getRight());
		}
	}

	private void preOrder(BSTNode<T> node)
	// Initializes preOrderQueue with tree elements in preOrder order.
	{
		if (node != null)
		{
			preOrderQueue.enqueue(node.getInfo());
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}

	private void postOrder(BSTNode<T> node)
	// Initializes postOrderQueue with tree elements in postOrder order.
	{
		if (node != null)
		{
			postOrder(node.getLeft());
			postOrder(node.getRight());
			postOrderQueue.enqueue(node.getInfo());
		}
	}

	public int reset(int orderType)
	// Initializes current position for an iteration through this BST
	// in orderType order. Returns current number of nodes in the BST.
	{
		int numNodes = size();

		if (orderType == INORDER)
		{
			inOrderQueue = new LinkedQueue<T>();
			inOrder(root);
		}
		else
			if (orderType == PREORDER)
			{
				preOrderQueue = new LinkedQueue<T>();
				preOrder(root);
			}
		if (orderType == POSTORDER)
		{
			postOrderQueue = new LinkedQueue<T>();
			postOrder(root);
		}
		return numNodes;
	}

	public T getNext (int orderType)
	// Preconditions: The BST is not empty
	//                The BST has been reset for orderType
	//                The BST has not been modified since the most recent reset
	//                The end of orderType iteration has not been reached
	//
	// Returns the element at the current position on this BST for orderType
	// and advances the value of the current position based on the orderType. 
	{
		if (orderType == INORDER)
			return inOrderQueue.dequeue();
		else
			if (orderType == PREORDER)
				return preOrderQueue.dequeue();
			else
				if (orderType == POSTORDER)
					return postOrderQueue.dequeue();
				else return null;
	}
	
	public T getNthLargest(int n) {
		T curr = null;
		reset(1);
		for(int i=-1; i<size()-n; i++) {
			curr = inOrderQueue.dequeue();
		}
		return curr;
	}
	
	public void printLeafNodes() {
		LinkedStack<BSTNode<T>> store1 = new LinkedStack<BSTNode<T>>();
		LinkedStack<BSTNode<T>> store2 = new LinkedStack<BSTNode<T>>();
		store1.push(root);
		while(!store1.isEmpty()) {
			BSTNode curr = store1.top();
			store1.pop();

			if(curr.getLeft() != null)
				store1.push(curr.getLeft());
			if(curr.getRight() != null)
				store1.push(curr.getRight());
			else if (curr.getLeft() == null && curr.getRight() == null)
				store2.push(curr);
		}
		while(!store2.isEmpty()) {
			System.out.println(store2.top().getInfo());
			store2.pop();
		}
	}
			
	
	public int numChildNodes() {
		int count = 0;
		LinkedStack<BSTNode<T>> store = new LinkedStack<BSTNode<T>>();
		if(root == null)
			return 0;
		store.push(root);
		while(!store.isEmpty()) {
			BSTNode curr = store.top();
			store.pop();
			
			if(curr.getLeft() != null && curr.getRight() == null) {
				store.push(curr.getLeft());
				count++;
			}	
			if(curr.getLeft() == null && curr.getRight() != null) { 
				store.push(curr.getRight());
				count++;
			}
			if(curr.getLeft() != null && curr.getRight() != null) { 
				store.push(curr.getLeft());
				store.push(curr.getRight());
			}
			
		}
		return count;
	}
	
	public boolean isFullBinaryTree() {
		LinkedStack<BSTNode<T>> store = new LinkedStack<BSTNode<T>>();
		store.push(root);
		while(!store.isEmpty()) {
			if(store == null)
				return true;
			BSTNode curr = store.top();
			if(curr.getLeft() == null && curr.getRight() == null)
				return true;
			if((curr.getLeft() != null) && (curr.getRight() != null)) {
				store.push(curr.getLeft());
				store.push(curr.getRight());
			}
			if((curr.getLeft() == null) && (curr.getRight() != null)
					||(curr.getLeft() != null) && (curr.getRight() == null))
				break;
		}
		return false;
	}
	
	public boolean isIdentical(BinarySearchTree<T> other) {
		if(size() != other.size())
			return false;
		reset(1);
		other.reset(1);
		for(int i=0; i<size(); i++) {
			T element2 = other.inOrderQueue.dequeue();
			T element1 = inOrderQueue.dequeue();
			if(element1 != element2)
				return false;
		}
		return true;
	}
		
	
}


