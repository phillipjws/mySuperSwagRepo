import javax.swing.border.StrokeBorder;

/*
* HeapPriorityQueue.java
*
* An implementation of a minimum PriorityQueue using a heap.
* based on the implementation in "Data Structures and Algorithms
* in Java", by Goodrich and Tamassia
*
* This implementation will throw a Runtime, HeapEmptyException
*	if the heap is empty and removeMin is called.
*
* This implementation will throw a Runtime, HeapFullException
*	if the heap is full and insert is called.
*
*/
public class HeapPriorityQueue<T extends Comparable<T>> implements PriorityQueue<T> {

	protected final static int DEFAULT_SIZE = 10000;
	
	protected T[] storage;
	protected int currentSize;
	
	// Feel free to change rootIndex to 0 if you want to 
	// use 0-based indexing (either option is fine)
	private static final int rootIndex = 0;

	/*
	 * Constructor that initializes the array to hold DEFAULT_SIZE elements
	 */
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> dataType) {
		// Creating generics arrays in Java is not very clean. The following 
		// two lines allocate the generic array for you based on whether you
		// have selected to store the root at index 0 or 1 above.
		if (rootIndex == 0) {
			storage = (T[]) java.lang.reflect.Array.newInstance(dataType, DEFAULT_SIZE);
		} else {
			storage = (T[]) java.lang.reflect.Array.newInstance(dataType, DEFAULT_SIZE+1);
		}
		currentSize = 0;
	}
	
	/*
	 * Constructor that initializes the array to hold size elements
	 */
	@SuppressWarnings({"unchecked"})
	public HeapPriorityQueue(Class<T> clazz, int size) {
		// Creating generics arrays in Java is not very clean. The following 
		// two lines allocate the generic array for you based on whether you
		// have selected to store the root at index 0 or 1 above.
		if (rootIndex == 0) {
			storage = (T[]) java.lang.reflect.Array.newInstance(clazz, size);
		} else {
			storage = (T[]) java.lang.reflect.Array.newInstance(clazz, size+1);
		}
		currentSize = 0;
	}

	public void insert (T element) throws HeapFullException {
		// TODO: implement this
		if (isFull())
		{
			throw new HeapEmptyException();
		}
		else if(isEmpty())
		{
			storage[0] = element;
			currentSize++;
		}
		else
		{
			storage[currentSize] = element;
			bubbleUp(currentSize);
			currentSize++;
		}
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. (By default, the root
		// index is set to 1 for you above. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.		
    }
	
	private void bubbleUp(int index) {
		if (index == 0)
		{
			return;
		}
		int parentIndex = (index-1)/2;
		T temp;
		if (storage[index].compareTo(storage[parentIndex]) < 0)
		{
			temp = storage[parentIndex];
			storage[parentIndex] = storage[index];
			storage[index] = temp;
			bubbleUp(parentIndex);
		}
		return;
	}

			
	public T removeMin() throws HeapEmptyException {
		T removed;
		if (isEmpty())
		{
			throw new HeapEmptyException();
		}
		else
		{
			removed = storage[0];
			storage[0] = storage[currentSize-1];
			storage[currentSize-1] = null;
			currentSize--;
			bubbleDown(0);
		}
		
		return removed; // so it compiles
	}
	
	private void bubbleDown(int index) {
		int leftIndex = (index + 1) * 2 - 1;
		int rightIndex = (index + 1) * 2;
	
		if (leftIndex >= currentSize && rightIndex >= currentSize) {
			return;
		}
	
		T nodeValue = storage[index];
		T leftChildValue = null;
		T rightChildValue = null;
	
		if (leftIndex < currentSize) {
			leftChildValue = storage[leftIndex];
		}
		if (rightIndex < currentSize) {
			rightChildValue = storage[rightIndex];
		}
	
		if (leftChildValue == null && rightChildValue == null) {
			return;
		} else if (rightChildValue == null) {
			if (leftChildValue.compareTo(nodeValue) < 0) {
				storage[index] = leftChildValue;
				storage[leftIndex] = nodeValue;
				bubbleDown(leftIndex);
			}
		} else if (leftChildValue == null) {
			if (rightChildValue.compareTo(nodeValue) < 0) {
				storage[index] = rightChildValue;
				storage[rightIndex] = nodeValue;
				bubbleDown(rightIndex);
			}
		} else {
			if (leftChildValue.compareTo(nodeValue) < 0 && leftChildValue.compareTo(rightChildValue) <= 0) {
				storage[index] = leftChildValue;
				storage[leftIndex] = nodeValue;
				bubbleDown(leftIndex);
			} else if (rightChildValue.compareTo(nodeValue) < 0 && rightChildValue.compareTo(leftChildValue) < 0) {
				storage[index] = rightChildValue;
				storage[rightIndex] = nodeValue;
				bubbleDown(rightIndex);
			}
		}
	}
	

	public boolean isEmpty(){
		// TODO: implement this
		
		return currentSize == 0; // so it compiles
	}
	
	public boolean isFull() {
		// TODO: implement this
		
		return currentSize>storage.length; // so it compiles
	}
	
	public int size () {
		// TODO: implement this
		
		return currentSize; // so it compiles
	}

	public String toString() {
		String s = "";
		String sep = "";
		if (rootIndex == 0) {
			for (int i = 0; i < currentSize; i++) {
				s += sep + storage[i];
				sep = " ";				
			}
		} else if (rootIndex == 1) {
			for(int i=1; i<=currentSize; i++) {
				s += sep + storage[i];
				sep = " ";
			}
		}
		return s;
	}
}
