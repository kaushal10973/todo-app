package todo;

import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testAddTask() {
        App app = new App();
        app.addTask("Test Task");
        List<String> tasks = app.getTasks();
        assertTrue(tasks.contains("Test Task"));
    }
}
