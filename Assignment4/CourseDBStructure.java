import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * @author Germain Asaba
 * This is class is a hashtable class with buckets to store data elements in.
 */

public class CourseDBStructure implements CourseDBStructureInterface {
	protected LinkedList<CourseDBElement> hashTable[];
	protected int length;



	/**
	 * This is a parameterized constructor
	 * @param length The size of the hashtable
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(int length) {
		this.length = length;
		hashTable = new LinkedList[length];
	}

	/**
	 * This is a constructor used for testing
	 * @param testing
	 * @param length The size of the constructor
	 */
	@SuppressWarnings("unchecked")
	public CourseDBStructure(String testing, int length) {
		this.length = length;
		hashTable = new LinkedList[length];
	}


	/**
	 * This method checks the hash code of an element then if the hash table doesn't have an element in
	 * that position, it adds the element to that position on the hash table.
	 * @param The element to be added
	 */
	@Override
	public void add(CourseDBElement element) {
		int i = (element.hashCode() % length);
		if(hashTable[i] == null) {
			hashTable[i] = new LinkedList<CourseDBElement>();
		}
		hashTable[i].add(element);

	}

	/**
	 * This method uses the crn of a CDE and goes through the hash table until it finds a crn that matches.
	 * @throws IOException Thrown if the index is not found on the hash table
	 * @return returns the element that has the same crn number
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String crnStr = crn + "";
		int myHash = crnStr.hashCode();
		int i = myHash % length;
		if(hashTable[i] == null) {
			throw new IOException();
		}
		else {
			for(int index = 0; index < length; index++) {
				CourseDBElement e = hashTable[index].get(index);
				if(e.getCrnNumber() == crn) {
					return e;
				}
			}
		}

		return null;
	}

	/**
	 * This method keeps track of the size of the hash table
	 * @return returns the size of the hash table
	 */
	@Override
	public int getTableSize() {
		return length;
	}

}
