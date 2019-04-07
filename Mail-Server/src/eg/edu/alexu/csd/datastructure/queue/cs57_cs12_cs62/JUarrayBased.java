package eg.edu.alexu.csd.datastructure.queue.cs57_cs12_cs62;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 * @author lenovo
 */
public class JUarrayBased {
	/**
	 * test enqueue.
	 */
		@Test
		public void test1() {
			ArrayBased test = new ArrayBased(2);
	        assertEquals(0, test.size());
			test.enqueue(1);
	        assertEquals(1, test.size());
			test.enqueue(2);
	        assertEquals(false, test.isEmpty());
		}
		/**
		 * test dequeue.
		 */
			@Test
			public void test2() {
				ArrayBased test = new ArrayBased(2);
		        assertEquals(0, test.size());
				test.enqueue(1);
		        assertEquals(1, test.size());
				test.enqueue(2);
				test.dequeue();
				test.dequeue();
		        assertEquals(true, test.isEmpty());
			}
			/**
			 * test size.
			 */
				@Test
				public void test3() {
					ArrayBased test = new ArrayBased(2);
			        assertEquals(0, test.size());
					test.enqueue(1);
			        assertEquals(1, test.size());
					test.enqueue(2);
					test.dequeue();
					test.dequeue();
			        assertEquals(0, test.size());
				}
}
