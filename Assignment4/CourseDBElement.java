import java.util.Objects;

/**
 * 
 * @author Germain Asaba
 * This class creates a Course data element with the appropriate fields
 *
 */

public class CourseDBElement implements Comparable {

	private String courseID;
	private int crnNumber;
	private int numOfCreds;
	private String roomNum;
	private String instructorName;

	/**
	 * Default constructor
	 */
	public CourseDBElement() {
		this.courseID = "";
		this.crnNumber = 0;
		this.numOfCreds = 0;
		this.roomNum = "" ;
		this.instructorName = "";
	}

	/**
	 * Parameterized constructor
	 * @param id The course id
	 * @param crnNum the crn number of the course
	 * @param numOfCreds the number of credits for the course
	 * @param roomNum the room number where the course is taught
	 * @param profName the name of the instructor 
	 */
	public CourseDBElement(String id, int crnNum, int numOfCreds, String roomNum, String profName) {
		this.courseID = id;
		this.crnNumber = crnNum;
		this.numOfCreds = numOfCreds;
		this.roomNum = roomNum;
		this.instructorName = profName;
	}


	/**
	 * this method gets the course id
	 * @return the course id
	 */
	public String getCourseID() {
		return courseID;
	}


	/**
	 * This method sets the course id
	 * @param courseID
	 */
	public void setCourseID(String courseID) {
		this.courseID = courseID;
	}


	/**
	 * This method gets the crn number
	 * @return crn number
	 */
	public int getCrnNumber() {
		return crnNumber;
	}

	/**
	 * This method sets the crn number
	 * @param crnNumber
	 */
	public void setCrnNumber(int crnNumber) {
		this.crnNumber = crnNumber;
	}


	/** 
	 * This method gets the number of credits
	 * @return The number of credits
	 */
	public int getNumOfCreds() {
		return numOfCreds;
	}


	/**
	 * This method sets the number of credits
	 * @param numOfCreds
	 */
	public void setNumOfCreds(int numOfCreds) {
		this.numOfCreds = numOfCreds;
	}



	/**
	 * This method gets the room number
	 * @return The room number
	 */
	public String getRoomNum() {
		return roomNum;
	}



	/**
	 * This method sets the room number
	 * @param roomNum
	 */
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
	}



	/**
	 * This method gets the name of the instructor
	 * @return the name of the instructor
	 */
	public String getInstructorName() {
		return instructorName;
	}



	/**
	 * This method sets the name of the instructor
	 * @param instructorName
	 */
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}



	/**
	 * This method creates a hash code for each element using the crn number
	 */
	@Override
	public int hashCode() {
		String crnString = crnNumber + "";
		return crnString.hashCode();
	}



	/**
	 * This method checks of two elements are equal to one another
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDBElement other = (CourseDBElement) obj;
		return crnNumber == other.crnNumber;
	}


	/**
	 * This method is used to sort the elements usning the crn number
	 */
	@Override
	public int compareTo(Object element) {
		CourseDBElement other = (CourseDBElement) element;
		return (this.crnNumber - other.crnNumber);
	}

	/**
	 * This method converts the attributes of the CDE to a string and returns the string
	 */
	@Override
	public String toString() {
		String result = "\nCourse:" + courseID + " CRN:" + crnNumber + " Credits:" + numOfCreds 
				+ " Instructor:" + instructorName + " Room:" + roomNum;
		return result;
	}



}
