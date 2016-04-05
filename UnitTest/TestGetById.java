import static org.junit.Assert.*;

import org.junit.Test;

import model.Todolistitem;

public class TestGetById {

	@Test
	public void testName() {
		Todolistitem testItem = ToDoListDB.getToDoListItemByID(1);
		assertTrue(testItem.getItemname().equals("badminton"));
	}

	@Test
	public void testDescription() {
		Todolistitem testItem = ToDoListDB.getToDoListItemByID(1);
		assertTrue(testItem.getItemdescription().equals("play badminton for 3 hours"));
	}
	
	@Test
	public void testUserId() {
		Todolistitem testItem = ToDoListDB.getToDoListItemByID(1);
		assertTrue(testItem.getUser().getUserid() == 1);
	}
	
	@Test
	public void testUserName() {
		Todolistitem testItem = ToDoListDB.getToDoListItemByID(1);
		assertTrue(testItem.getUser().getUsername().equals("Eric"));
	}
	
	@Test
	public void testUserPass() {
		Todolistitem testItem = ToDoListDB.getToDoListItemByID(1);
		assertTrue(testItem.getUser().getUserpass().equals("abc123"));
	}
	
	@Test
	public void testStatusId() {
		Todolistitem testItem = ToDoListDB.getToDoListItemByID(1);
		assertTrue(testItem.getStatus().getStatusid() == 4);//may change during runtime of application
	}
	
	@Test
	public void testStatusDescription() {
		Todolistitem testItem = ToDoListDB.getToDoListItemByID(1);
		assertTrue(testItem.getStatus().getStatusdescription().equals("complete"));//may change during runtime of application
	}
	
}
