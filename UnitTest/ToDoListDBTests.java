import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFindStatus.class, TestGetAll.class, TestGetById.class })
public class ToDoListDBTests {

}
