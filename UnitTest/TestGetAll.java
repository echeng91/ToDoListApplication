import static org.junit.Assert.*;

import org.junit.Test;

import java.util.List;
import model.Todolistitem;
import model.User;

public class TestGetAll {

	@Test
	public void testNotEmpty() {
		User userp = new User();
		userp.setUserid(1);
		userp.setUsername("Eric");
		userp.setUserpass("abc123");
		List<Todolistitem> testList = ToDoListDB.getAllToDoListItems(userp);
		assertFalse(testList.isEmpty());
	}
	
	@Test
	public void testNumber() {
		User userp = new User();
		userp.setUserid(1);
		userp.setUsername("Eric");
		userp.setUserpass("abc123");
		List<Todolistitem> testList = ToDoListDB.getAllToDoListItems(userp);
		assertTrue(testList.size() == 2);//test will need to be changed if table is altered
	}

}
