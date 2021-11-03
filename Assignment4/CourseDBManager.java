import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author Germain Asaba
 * This class allows the user to read courses from a file or to enter 
 * the data by hand, and print out the database elements
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {

	private CourseDBStructure CDS = new CourseDBStructure(30);


	/**
	 * This method adds an element to the hashtable by calling the add method
	 * from the CourseDataSTructure class
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement CDE = new CourseDBElement(id, crn, credits, roomNum, instructor);
		CDS.add(CDE);
	}

	/**
	 * This method uses the get method from the CDS class to get the element
	 * @param crn the crn number of the CDE
	 * @return The CDE
	 */
	@Override
	public CourseDBElement get(int crn) {

		try {
			return CDS.get(crn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method takes all the element in the hashtable and buckets and puts it in an array
	 * as a string
	 * @return myArrayList The array full of all the elements
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> myArrayList = new ArrayList<>();
		for(int g = 0; g < CDS.hashTable.length; g++) {
			LinkedList<CourseDBElement> temp = CDS.hashTable[g];
			if(temp != null) {
				for (int h = 0; h < temp.size(); h++) {
					CourseDBElement e = temp.get(h);
					myArrayList.add(e.toString());
				}
			}
		}
		return myArrayList;
	}

	/**
	 * This method reads from a file and makes a CDE from each line of the file
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
			Scanner myFile = new Scanner(input);
			while(myFile.hasNext()) {
				
				String courseID = myFile.next();
				int crn_Number = myFile.nextInt();
				int numOfCreds = myFile.nextInt();
				String roomNum = myFile.next();
				String professor = myFile.nextLine();
				add(courseID, crn_Number, numOfCreds, roomNum, professor);

			}
			myFile.close();
		}catch (FileNotFoundException e) {
			e.getMessage();
		}

	}

	


}
