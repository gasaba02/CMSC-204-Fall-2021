import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 * This class uses the morse code tree class the convert morse code to english
 * @author Germain Asaba
 *
 */
public class MorseCodeConverter {
	
	private static MorseCodeTree myTree = new MorseCodeTree();
	
	/**
	 * Constructor
	 */
	public MorseCodeConverter(){
		
	}
	
	/**
	 * This method converts morse code to English
	 * @param code The morse code
	 * @return The English representation of the morse code
	 */
	public static String convertToEnglish(String code) {
		String[] words;
		String[] letters;
		String result = "";
		words = code.trim().split("/");
		for(String word : words) {
			letters = word.trim().split(" ");
			for(String letter : letters) {
				result += myTree.fetch(letter);
			}
			result += " ";
		}
		
		
		return result.trim();
		
	}
	
	/**
	 * This method reads a morse code from a text file then converts it to English
	 * @param codeFile The text file containing the morse code
	 * @return The English representation of the morse code
	 * @throws FileNotFoundException thrown if the file is not found
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		BufferedReader reader = new BufferedReader(new FileReader(codeFile));
		String result = "";
	     try {
			String code = reader.readLine();
			 result = convertToEnglish(code);
			 
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	     
		
		
		return result;
		
	}
	
	/**
	 * This method puts all the elements of the tree into an array the prints it out
	 * @return All the elements in the array
	 */
	public static String printTree() {
		String result = "";
		ArrayList<String> data = new ArrayList<>();
		data = myTree.toArrayList();
		for(String str : data) {
			result += str + " "; 
		}
		return result;
		
	}
	
	

}
