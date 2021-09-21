import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester {
	
	GradeBook g1 = new GradeBook(5);
	GradeBook g2 = new GradeBook(5);
	
	@BeforeEach
	void setUp() throws Exception {
		
		g1.addScore(6);
		g1.addScore(10);
		g1.addScore(7);
		g1.addScore(11);
		
		
		g2.addScore(20);
		g2.addScore(25);
		g2.addScore(30);
		g2.addScore(29);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	
	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("6.0 10.0 7.0 11.0 0.0 "));
		assertEquals(g1.getScoreSize(), 4);
		
		assertTrue(g2.toString().equals("20.0 25.0 30.0 29.0 0.0 "));
		assertEquals(g1.getScoreSize(), 4);
	}
	
	@Test
	void testSum() {
		assertEquals(g1.sum(), 34);
		assertEquals(g2.sum(), 104);
	}

	@Test
	void testMinimum() {
		assertEquals(g1.minimum(), 6.00, .001);
		assertEquals(g2.minimum(), 20.00, .001);
	}
	
	@Test
	void testFinalScore() {
		assertEquals(g1.finalScore(), 28, .001);
		assertEquals(g2.finalScore(), 84, .001);
	}
	
}

