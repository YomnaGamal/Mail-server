package eg.edu.alexu.csd.datastructure.mailServer.cs12_cs57_cs62;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitQueue {

	@Test
	public void test() {
		PriorityQueue test = new PriorityQueue();
		test.insert("a", 5);
		test.insert("b", 5);
        assertEquals(2, test.size());
        assertEquals("a", test.removeMin());
	}

}
