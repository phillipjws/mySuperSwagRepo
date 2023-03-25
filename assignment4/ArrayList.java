public class ArrayList implements List {

	private Building[] storage;
	private int numElements;
	
	public ArrayList(int size) {
		this.storage = new Building[size];
		this.numElements = 0;
	}
	
	public ArrayList(Building[] array) {
		this.storage = array;
		numElements = array.length;
	}
	
	public void expandAndCopy() {
		Building[] newStorage = new Building[storage.length*2];
		for (int i = 0; i < storage.length; i++) {
			newStorage[i] = storage[i];
		}
		this.storage = newStorage;
	}
	
	public void add(Building b) {
		while (numElements >= storage.length) {
			expandAndCopy();
		}
		storage[numElements++] = b;
	}
		
	public int size() {
		return this.numElements;
	}
			
	public Building get(int index) {
		return storage[index];
	}

	public int find(Building b) {
		int index = -1;
		int cur = 0;
		while (cur < numElements && index == -1) {
			if (storage[cur].equals(b)) {
				index = cur;
			}
			cur++;
		}
		return index;
	}
	
}