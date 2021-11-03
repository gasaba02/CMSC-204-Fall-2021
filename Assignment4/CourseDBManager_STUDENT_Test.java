

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 * 
 * @author ralexander
 *
 */
public class CourseDBManager_STUDENT_Test {
	private CourseDBManagerInterface dataMgrTest = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgrTest = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgrTest = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgrTest.add("CMSC203",20000,5,"SC500","T One Thousand");
		}
		catch(Exception e) {
			fail("This should not have caused an Exception");
		}
	}
	
	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgrTest.add("CMSC203",30001,3,"SC450","Tony Stark");
		dataMgrTest.add("CMSC203",30000,3,"Distance-Learning","Steve Roggers");
		
		ArrayList<String> list = dataMgrTest.showAll();
		
		assertEquals(list.get(0),"\nCourse:CMSC203 CRN:30000 Credits:3 Instructor:Steve Roggers Room:Distance-Learning");
		assertEquals(list.get(1),"\nCourse:CMSC203 CRN:30001 Credits:3 Instructor:Tony Stark Room:SC450");
			}
	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test1.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC203 30000 3 Distance-Learning Joey Tony Stark");
			inFile.print("CMSC203 30001 2 Zoom Jill Peter Parker");
			
			inFile.close();
			dataMgrTest.readFile(inputFile);
			System.out.println(dataMgrTest.showAll());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}