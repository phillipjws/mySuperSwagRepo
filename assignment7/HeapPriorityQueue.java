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

	private int parent(int pos) {
		return (pos - 1) / 2;
	}
	private int leftChild(int pos) { 
		return (2 * pos) + 1; 
	}
	
	private int rightChild(int pos){
		return (2 * pos) + 2;
	}

	private void swap(int pos1, int pos2){
		T temp = storage[pos1];
		storage[pos1] = storage[pos2];
		storage[pos2] = temp;

	}

	public void insert (T element) throws HeapFullException {
		// TODO: implement this
		
		// When inserting the first element, choose whether to use 
		// a 0-based on 1-based implementation. (By default, the root
		// index is set to 1 for you above. Whatever you choose,
		// make sure your implementation for the rest of the program
		// is consistent with this choice.	
		if (isFull()) {
			throw new HeapFullException();
		}
		storage[currentSize] = element;
		int current = currentSize;
		currentSize++;
		if (currentSize > 1) {
			bubbleUp(current);
		}
    }
	
	private void bubbleUp(int index) {
		while(index > 0 && storage[index].compareTo(storage[parent(index)]) < 0){
			swap(index, parent(index));
			index = parent(index);
		}
	}
			
	public T removeMin() throws HeapEmptyException {
		// TODO: implement this
		if(isEmpty()){
			throw new HeapEmptyException();
		}else{
			T min = storage[0];
			storage[0] = storage[currentSize - 1];
			currentSize--;
			bubbleDown(rootIndex);
			return min;
		}
		
	}
	
	private void bubbleDown(int index) {
		// TODO: implement this
		if (leftChild(index) >= currentSize) {
			return;
		}
		int smallerChildIndex;
		if (rightChild(index) >= currentSize || storage[leftChild(index)].compareTo(storage[rightChild(index)]) <= 0) {
			smallerChildIndex = leftChild(index);
		} else {
			smallerChildIndex = rightChild(index);
		}
		if (storage[index].compareTo(storage[smallerChildIndex]) > 0) {
			swap(index, smallerChildIndex);
			bubbleDown(smallerChildIndex);
		}
	}

	public boolean isEmpty(){
		// TODO: implement this
		
		return currentSize == 0; // so it compiles
	}
	
	public boolean isFull() {
		// TODO: implement this
		
		return currentSize == storage.length; // so it compiles
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
