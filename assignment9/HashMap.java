import java.util.*;

public class HashMap<K extends Comparable<K>, V> implements Map<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;

	// For Part III
	private long getLoops;
	private long putLoops;
	

	public HashMap() {
		tableSize = 1000003; // prime number
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;

		// For Part III:
		resetGetLoops();
		resetPutLoops();
	}

	// For Part III
	public long getGetLoopCount() {
		return getLoops;
	}

	// For Part III
	public long getPutLoopCount() {
		return putLoops;
	}

	// For Part III
	public void resetGetLoops() {
		getLoops = 0;
	}
	
	// For Part III
	public void resetPutLoops() {
		putLoops = 0;
	}

	public boolean containsKey(K key) {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;

		// iterate through the list at the given index and check if the key exists
		for (Entry<K, V> entry : table.get(index)) {
			if (entry.getKey().equals(key)) {
				return true;
			}
		}
		return false;
	}

	public V get (K key) throws KeyNotFoundException {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;

		// iterate through the list at the given index and return the value if the key exists
		for (Entry<K, V> entry : table.get(index)) {
			if (entry.getKey().equals(key)) {
				return entry.getValue();
			}
		}
		throw new KeyNotFoundException();
	}


	public void put(K key, V value) {
		int index = Math.abs(key.hashCode()) % tableSize;
		List<Entry<K, V>> bucket = table.get(index);
	
		for (Entry<K, V> entry : bucket) {
			if (entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}
	
		bucket.add(new Entry<K, V>(key, value));
		count++;
	}
	
	public List<Entry<K, V>> entryList() {
		List<Entry<K, V>> resultList = new LinkedList<Entry<K, V>>();
	
		for (List<Entry<K, V>> bucket : table) {
			for (Entry<K, V> entry : bucket) {
				resultList.add(entry);
			}
		}
	
		return resultList;
	}
	

	public int size() {
		return count;
	}

    public void clear() {
		for(int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}