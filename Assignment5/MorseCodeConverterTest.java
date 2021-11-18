

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTest {
	File inputFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPrintTree()
	{
		//Note the extra space between j and b - that is because there is an empty string that
		//is the root, and in the LNR traversal, the root would come between the right most
		//child of the left tree (j) and the left most child of the right tree (b).
		String correctResult = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String s = MorseCodeConverter.printTree();
		s = s.trim(); // take off preceding or succeeding spaces
		assertEquals(correctResult, s);
	}
	
	@Test
	public void testConvertToEnglishString() {	
		String converter1 = MorseCodeConverter.convertToEnglish("--. --- --- -.. -... -.-- . / .-- --- .-. .-.. -.. ");
		assertEquals("goodbye world",converter1);
		
		String test2="daisy daisy";		
		String converter2 = MorseCodeConverter.convertToEnglish("-.. .- .. ... -.-- / -.. .- .. ... -.-- ");
		assertEquals("daisy daisy", converter2);
	}
	
	@Test
	public void testConvertToEnglishStringSTUDENT() {
		String studentConverter1 = MorseCodeConverter.convertToEnglish("- .... . / .- ...- . -. --. . .-. ... / .. -. ..-. .. -. .. - -.-- / .-- .- .-. ");
		assertEquals("the avengers infinity war",studentConverter1);
		
		String studentConverter2 = MorseCodeConverter.convertToEnglish("-.-. .- .-.. .-.. / -- . / --. . .-. -- .- .. -. ");
		assertEquals("call me germain", studentConverter2);
	}

	@Test
	public void testConvertToEnglishFile() throws FileNotFoundException {
		String test1="give me your answer do";		
		getFile("Daisy.txt");
		String converter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test1,converter1);
		
		String test2="im half crazy all for the love of you";		
		getFile("DaisyDaisy.txt");
		String converter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(test2,converter2);

	}
	
	@Test
	public void testConvertToEnglishFileSTUDENT() throws FileNotFoundException {
		
		String studentTest1 = "we are doomed";		
		getFile("Germs1.txt");
		String studentConverter1 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(studentTest1,studentConverter1);
		
		String studentTest2 = "do what i say not what i do";		
		getFile("Germs2.txt");
		String studentConverter2 = MorseCodeConverter.convertToEnglish(inputFile);
		assertEquals(studentTest2,studentConverter2);
	}
	
	public void getFile(String in) throws FileNotFoundException {		
		JFileChooser chooser = new JFileChooser();
		int status;

		chooser.setDialogTitle("Select Input File - " + in);
		status = chooser.showOpenDialog(null);

		if(status == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inputFile = chooser.getSelectedFile();
				// readFile();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "There is a problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}