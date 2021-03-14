import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {

	Queue queue = null;

	@BeforeEach
	void init() {
		queue = new Queue();
	}

	@Test
	void enqueue_StringWithLength_WithoutException() {
		try {
			queue.enqueue("Element");
		} catch (Exception e) {
			fail("Must not throw exception");
		}
	}

	@Test
	void enqueue_StringWithZeroLength_WithoudException() {
		try {
			queue.enqueue("");
		} catch (Exception e) {
			fail("Must not throw exception");
		}
	}

	@Test
	void enqueue_StringNull_WithException() {
		try {
			queue.enqueue(null);
			fail("Must throw exception");
		} catch (Exception e) {
			System.out.println("OK");
		}
	}

	@Test
	void size_EmptyQueue_SizeZero() {
		assertEquals(0, queue.size());
	}

	@Test
	void size_QueueWithOneElement_SizeOne() {
		try {
			queue.enqueue("String");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Must not throw exception");
		}
		assertEquals(1, queue.size());
	}

	@Test
	void size_QueueWithTwoElements_SizeTwo() {
		try {
			queue.enqueue("String");
			queue.enqueue("String");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail("Must not throw exception");
		}
		assertEquals(2, queue.size());
	}

	@Test
	void dequeue_QueueWithZeroElement_ThrowsException() {
		try {
			queue.dequeue();
			fail("Must throw exception");
		} catch (Exception e) {
			System.out.println("OK");
		}
	}

	@Test
	void dequeue_QueueWithOneElement_ReturnsElementWithoutException() {
		try {
			queue.enqueue("FirstElement");
			assertEquals("FirstElement", queue.dequeue());
		} catch (Exception e) {
			fail("Must not throw exception");
		}
	}

	@Test
	void dequeue_QeueuWithTwoElement_ReturnsFirstEnqueuedElementWithoutException() {
		try {
			queue.enqueue("FirstElement");
			queue.enqueue("SecondElement");
			assertEquals("FirstElement", queue.dequeue());
		} catch (Exception e) {
			fail("Must not throw exception");
		}
	}

	@Test
	void dequeue_QeueuWithTwoElementTwoTimesDequeue_ReturnsSecondEnqueuedElementWithoutException() {
		try {
			queue.enqueue("FirstElement");
			queue.enqueue("SecondElement");
			assertEquals("FirstElement", queue.dequeue());
			assertEquals("SecondElement", queue.dequeue());
		} catch (Exception e) {
			fail("Must not throw exception");
		}
	}

	@Test
	void dequeue_QueueWithOneElementTwoTimesDequeue_ThrowsException() {
		try {
			queue.enqueue("FirstElement");
			queue.dequeue();
			System.out.println("OK");
		} catch (Exception e) {
			fail("Must not throw exception");
		}

		try {
			queue.dequeue();
			fail("Must throw exception");
		} catch (Exception e) {
			System.out.println("OK");
		}
	}

	@Test
	void peek_QueueWithZeroElements_ThrowsException() {
		try {
			queue.peek();
			fail("Must throw exception");
		} catch (Exception e) {
			System.out.println("OK");
		}
	}
	
	@Test
	void peek_QueueWithOneElement_ReturnsFirstElementAndQueueSizeMustBeOne() {
		try {
			queue.enqueue("FirstElement");
			assertEquals("FirstElement", queue.peek());
			assertEquals(1, queue.size());
		} catch(Exception e) {
			fail("Must not throw exception");
		}
	}
	
	@Test 
	void peek_QueueWithTwoElements_ReturnsFirstElementAndQueueSizeMustBeTwo() {
		try {
			queue.enqueue("FirstElement");
			queue.enqueue("SecondElement");
			assertEquals("FirstElement", queue.peek());
			assertEquals(2, queue.size());
		} catch(Exception e) {
			fail("Must not throw exception");
		}
	}
	
	@Test 
	void peek_QueueWithOneElementPeekTwoTimes_ReturnsFirstElementOnEachPeek() {
		try {
			queue.enqueue("FirstElement");
			assertEquals("FirstElement", queue.peek());
			assertEquals("FirstElement", queue.peek());
			assertEquals(1, queue.size());
		} catch(Exception e) {
			fail("Must not throw exception");
		}
	}
	
	@Test
	void peek_QueueWithTwoElementPeekBeforeAndAfterDequeue_ReturnSuitableElementOnEachPeek() {
		try {
			queue.enqueue("FirstElement");
			queue.enqueue("SecondElement");
			assertEquals("FirstElement", queue.peek());
			queue.dequeue();
			assertEquals("SecondElement", queue.peek());
			assertEquals(1, queue.size());
		} catch(Exception e) {
			fail("Must not throw exception");
		}
	}
}
