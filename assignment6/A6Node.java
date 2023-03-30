public class A6Node<T>{
	    
	private T data;
	protected A6Node<T> next;

	public A6Node (T value) {
		this.data = value;
		this.next = null;
	}

	/*
	 * Purpose: get the data value of this Node
	 * Parameters: nothing	 
	 * Returns: T - the data value
	 */
	public T getData() {
		return data;
	}

	public void setData(T newValue){
		this.data = newValue;
	}

	/*
	 * Purpose: get the next node
	 * Parameters: nothing
	 * Returns: Node<T> - the next node
	 */
	public A6Node<T> getNext() {
		return next;
	}

	/*
	 * Purpose: update the next reference for this node
	 * Parameters: Node<T> next - the new next
	 * Returns: void - nothing
	 */
	public void setNext(A6Node<T> next) {
		this.next = next;
	}

}