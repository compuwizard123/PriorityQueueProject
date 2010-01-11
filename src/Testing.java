import junit.framework.*;

public class Testing extends TestCase{
	
	private static int points = 0;

	public void testAddandtoArray(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.add(3));
		assertTrue(q.add(5));
		assertTrue(q.add(2));
		assertTrue(q.add(4));
		assertTrue(q.add(2));
		try {
			q.add(null);
			fail("Did not throw NullPointerException");
		} catch (Exception e){
			if (!(e instanceof NullPointerException)) {
				fail("Did not throw NullPointerException");				
			}
		}
		Object[] a = q.toArray();
		assertEquals(2,a[0]);
		assertEquals(2,a[1]);
		assertEquals(3,a[2]);
		assertEquals(5,a[3]);
		assertEquals(4,a[4]);
		points+=15;
	}
	
	public void testToArray(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.add(3));
		assertTrue(q.add(5));
		assertTrue(q.add(2));
		Object[] a = q.toArray();
		a[1] = 4;
		Object[] b = q.toArray();
		assertFalse(a[1].equals(b[1]));
		points+=2;
	}

	public void testOffer(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.offer(3));
		assertTrue(q.offer(5));
		assertTrue(q.offer(2));
		assertTrue(q.offer(4));
		assertTrue(q.offer(2));
		try {
			q.add(null);
			fail("Did not throw NullPointerException");
		} catch (Exception e){
			if (!(e instanceof NullPointerException)) {
				fail("Did not throw NullPointerException");				
			}
		}
		Object[] a = q.toArray();
		assertEquals(2,a[0]);
		assertEquals(2,a[1]);
		assertEquals(3,a[2]);
		assertEquals(5,a[3]);
		assertEquals(4,a[4]);
		points+=2;
	}
	public void testPeek(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertEquals(null ,q.peek());		
		assertTrue(q.add(3));
		assertTrue(q.add(5));
		assertTrue(q.add(2));
		assertEquals(new Integer(2) ,q.peek());	
		points += 2;
	}
	
	public void testClear(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.add(3));
		assertTrue(q.add(5));
		assertTrue(q.add(2));
		q.clear();
		assertEquals(0,q.toArray().length);
		points += 2;
	}

	public void testContains(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.add(3));
		assertTrue(q.add(5));
		assertTrue(q.add(2));
		assertTrue(q.contains(2));
		assertFalse(q.contains(7));
		points += 2;
	}
	
	public void testSize(){	
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.add(3));
		assertTrue(q.add(5));
		assertTrue(q.add(2));
		assertEquals(3,q.toArray().length);
		points += 2;
	}

	public void testToArray2(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.add(3));
		assertTrue(q.add(5));
		assertTrue(q.add(2));
		Number[] y = q.toArray(new Number[0]);
		points += 2;
	}
	
	public void testPoll(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.offer(3));
		assertTrue(q.offer(5));
		assertTrue(q.offer(2));
		assertTrue(q.offer(4));
		assertTrue(q.offer(2));
		assertEquals(new Integer(2),q.poll());
		assertEquals(new Integer(2),q.poll());
		assertEquals(new Integer(3),q.poll());
		assertEquals(new Integer(4),q.poll());
		assertEquals(new Integer(5),q.poll());
		assertEquals(null,q.poll());
		points += 13;
	}
	
	public void testRemove(){
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		assertTrue(q.offer(3));
		assertTrue(q.offer(5));
		assertTrue(q.offer(2));
		assertTrue(q.offer(4));
		assertTrue(q.offer(2));
		assertFalse(q.remove(new Integer(7)));
		assertTrue(q.remove(new Integer(2)));
		assertTrue(q.remove(new Integer(4)));
		points += 8;
	}
	
	public void testNothing(){
		System.out.println("Points: " + points);
	}
	public static void main(String args[]) {
		junit.swingui.TestRunner.run(Testing.class);
	}	

}