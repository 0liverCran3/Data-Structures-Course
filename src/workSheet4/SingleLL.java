package worksheet4;

import support.LLNode;

/**
 * The class implements a single linked list using LLNode objects
 * @author Dr. Niharika Jain
 *
 */
public class SingleLL<T> {
	protected LLNode<T> list;
	protected int numElements;
	/**
	 * 
	 */
	public SingleLL() {
		list = null;
		numElements = 0;
	}
	/**
	 * @return the list
	 */
	public LLNode<T> getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(LLNode<T> list) {
		this.list = list;
	}
	/**
	 * @return the numElements
	 */
	public int getNumElements() {
		return numElements;
	}
	/**
	 * @param numElements the numElements to set
	 */
	public void setNumElements(int numElements) {
		this.numElements = numElements;
	}

	//Traversal of a list
	public void traverse() {
		LLNode<T> currNode = this.list;
		while(currNode!=null) {
			System.out.println(currNode.getInfo());
			currNode = currNode.getLink();
		}
	}

	//Add an element to the front of linked list
	public void addFront(T elem) {
		LLNode<T> newNode = new LLNode<T>(elem);
		newNode.setLink(list);
		list = newNode;
		numElements++;
	}	
	
	//Print a single linked list
	@Override
	public String toString() {
		LLNode<T> node = list;
		String result = "";
		if (node ==null)
			result = "List is empty";
		else {
			while (node.getLink() != null) {
				result += node.getInfo();
				result += "-->";
				node = node.getLink();
			}
			result += node.getInfo();
		}
		return result;
	}
	
	public void removeFront() {
		LLNode<T> fNode = this.list.getLink();
		list = fNode;
		numElements--;
	}
	public void addLast(T element) {
		LLNode<T> newNode = new LLNode<T>(element);
		LLNode<T> currNode = this.list;
		while(currNode!=null) {
			currNode = currNode.getLink();
			if(currNode.getLink() == null) {
				currNode.setLink(newNode);
				break;
			}
		}
		currNode = newNode;
		numElements++;
	}
}