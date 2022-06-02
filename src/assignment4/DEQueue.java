/*** COSC 2100 –Fall2020
 * * Assignment#4
 * * <The class is able to do everything intended but for some reason it cannot store elements past front or before rear.>
 * * @author <Oliver Crane>
 * */

package assignment4;

public class DEQueue<T> implements DequeInterface<T> {

	protected DLLNode<T> front;      // reference to the front and rear of this dequeue
	protected DLLNode<T> rear;
	protected int numElements = 0; 	 // number of elements in this dequeue

	public DEQueue() {
		front = null;
		rear = null;
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return (numElements == 0);
	}

	public int size() {
		return numElements;
	}

	public void enqueueFront(T element) {
		//TODO(1) Implement this method to add element to the front
		DLLNode<T> newNode = new DLLNode<T>(element);
		if(front == null) {
			front = newNode;
			rear = newNode;
		}
		else {
			front.setForward(newNode);
			front = newNode;
		}
		numElements ++;
	}

	public void enqueueRear(T element) {
		//TODO(2) Implement this method to add element to the rear
		DLLNode<T> newNode = new DLLNode<T>(element);
		if(front == null) {
			rear = newNode;
			front = newNode;
		}
		else {
			rear.setBack(newNode);
			rear = newNode;
		}
		numElements ++;
	}

	public T dequeueFront() throws QueueUnderflowException {
		//TODO(3) Implement this method to remove element from the front
		if(isEmpty()) {
			throw new QueueUnderflowException("Queue is empty");
		}
		else {
			front = null;
			front = front.getBack();
		}
		numElements--;
		return rear.getInfo();
	}

	public T dequeueRear() throws QueueUnderflowException {
		//TODO(4) Implement this method to remove element from the rear
		if(isEmpty()) {
			throw new QueueUnderflowException("Queue is empty");
		}
		else {
			rear = null;
			rear = rear.getForward();
		}
		numElements--;
		return rear.getInfo();
	}

	public String toString() {
		//TODO(5) Implement this method to print a nicely formatted deque
		DLLNode<T> newNode = front;
        String result = "";
        while(newNode != null) {
        	if(newNode.getBack() == null)
        		result += newNode.getInfo();
        	else
        		result += newNode.getInfo()+"<-->";
        	newNode = newNode.getBack();
        }
        return result+"      Median= "+median();
    }

	public int median() {
		//TODO(6) Implement this method to find the median.
		DLLNode<T> frontNode1 = front;
		DLLNode<T> frontNode2 = front;
		int count = 0;
		String median = "";
		if(numElements%2==0) {
			count = (numElements/2)+1;
		}
		else if(numElements%2==1) {
			count = ((numElements+1)/2);
		}
		if(frontNode2 != null) {
			while(count != 1) {
				frontNode2 = frontNode2.getBack();
				count --;
			}
			return((Integer)frontNode2.getInfo());
		}
		else {
			return 0;
		}
	}

	public void insert(T element) {
		if ( ((Integer)element) >= this.median()) {
			System.out.println("Enqueue from Rear");
			insertRear(element);
		} else {
			System.out.println("Enqueue from Front");
			insertFront(element);
		}
	}

	public void delete(T element) throws QueueUnderflowException {
		if ( ((Integer)element) >= this.median()) {
			System.out.println("Dequeue from Rear");
			deleteRear(element);
		} else {
			System.out.println("Dequeue from Front");
			deleteFront(element);
		}
	}
	public void insertFront(T element) {
		//TODO(7) Implement this method to insert the element from the front so as to get a sorted deque
		if(front == null)
			enqueueFront(element);
		else if((Integer)front.getInfo() < (Integer)element){
			enqueueFront(element);
		}else {
			front.setBack(new DLLNode<T>(element));
		}

	}

	public void insertRear(T element) {
		//TODO(8) Implement this method to insert the element from the rear so as to get a sorted deque
		if(rear == null)
			enqueueRear(element);
		else if((Integer)rear.getInfo() > (Integer)element){
			enqueueRear(element);
		}else {
			rear.setForward(new DLLNode<T>(element));
		}
		
	}

	public void deleteFront(T element) throws QueueUnderflowException {
		//TODO(9) Implement this method to remove element while traversing the deque from the front
		DLLNode<T> newNode = new DLLNode<T>(element);
		DLLNode<T> frontNode = front;
		if(isEmpty()) {
			throw new QueueUnderflowException("Queue is empty");}
		else {
			while(frontNode != null){
				if(newNode == frontNode) {
					dequeueFront();
				}
				frontNode = frontNode.getBack();
			}
			
		}
	}

	public void deleteRear(T element) throws QueueUnderflowException {
		//TODO(10) Implement this method to remove element while traversing the deque from the rear
		DLLNode<T> newNode = new DLLNode<T>(element);
		DLLNode<T> rearNode = rear;
		if(isEmpty()) {
			throw new QueueUnderflowException("Queue is empty");}
		else {
			while(rearNode != null){
				if(newNode == rearNode) {
					dequeueRear();
				}
				rearNode = rearNode.getForward();
			}
		}
	}

}
