import static org.junit.Assert.*;

import org.junit.Test;

import model.Status;

public class TestFindStatus {

	@Test
	public void test1() {
		Status testStatus = ToDoListDB.findStatus(1);
		assertTrue(testStatus.getStatusdescription().equals("incomplete"));
	}
	
	@Test
	public void test2() {
		Status testStatus = ToDoListDB.findStatus(2);
		assertTrue(testStatus.getStatusdescription().equals("in progress"));
	}
	
	@Test
	public void test3() {
		Status testStatus = ToDoListDB.findStatus(3);
		assertTrue(testStatus.getStatusdescription().equals("on hold"));
	}
	
	@Test
	public void test4() {
		Status testStatus = ToDoListDB.findStatus(4);
		assertTrue(testStatus.getStatusdescription().equals("complete"));
	}

}
