

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TicketTest {

	Ticket ticketTest;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTicket() {
		ticketTest = new Ticket();
	}


	@Test
	public void testMovieName() {
		ticketTest = new Ticket();
		ticketTest.setMovieName("Titanic");
		assertEquals(ticketTest.getMovieName(),"Titanic");
	}

	@Test
	public void testTimeNumber() {
		ticketTest = new Ticket();
		ticketTest.setTimeNumber(2);
		assertEquals(ticketTest.getTimeNumber(),2);
	}

	@Test
	public void testTime() {
		ticketTest = new Ticket();
		ticketTest.setTime("3:08");
		assertEquals(ticketTest.getTime(),"3:08");
	}


	@Test
	public void testScreenNumber() {
		ticketTest = new Ticket();
		ticketTest.setScreenNumber(3);
		assertEquals(ticketTest.getScreenNumber(),3);	
	}


	@Test
	public void testChild() {
		ticketTest = new Ticket();
		ticketTest.setChild(4);
		assertEquals(ticketTest.getChild(),4);
	}


	@Test
	public void testAdult() {
		ticketTest = new Ticket();
		ticketTest.setAdult(5);
		assertEquals(ticketTest.getAdult(),5);
	}


	@Test
	public void testSenior() {
		ticketTest = new Ticket();
		ticketTest.setSenior(6);
		assertEquals(ticketTest.getSenior(),6);
	}

	
	@Test
	public void testStudent() {
		ticketTest = new Ticket();
		ticketTest.setStudent(8);
		assertEquals(ticketTest.getStudent(),8);
	}



	@Test
	public void testStudentID() {
		ticketTest = new Ticket();
		int TestID[]={12,23,34};
		ticketTest.setStudentID(TestID);
		assertEquals(ticketTest.getStudentID(),TestID);
	}

	
	@Test
	public void testSeatSelect() {
		ticketTest = new Ticket();
		String TestSeat[]={"A1","B2","D3"};
		ticketTest.setSeatSelect(TestSeat);
		for(int i=0;i<TestSeat.length;i++)
		{
			assertEquals(ticketTest.getSeatSelect()[i],TestSeat[i]);
		}
		
	}


	@Test
	public void testGetTotalNumber() {
		ticketTest = new Ticket();
		ticketTest.setChild(1);
		ticketTest.setAdult(5);
		ticketTest.setStudent(6);
		ticketTest.setSenior(4);
		assertEquals(ticketTest.getTotalNumber(),16);
	}

	
	@Test
	public void testGetPrice() {
		ticketTest = new Ticket();
		ticketTest.setChild(2);
		ticketTest.setAdult(3);
		ticketTest.setStudent(4);
		ticketTest.setSenior(5);
		assertEquals(ticketTest.getPrice(),"89.60");
	}

	@Test
	public void testMovieNumber() {
		ticketTest = new Ticket();
		ticketTest.setMovieNumber(7);
		assertEquals(ticketTest.getMovieNumber(),7);
	}


}
