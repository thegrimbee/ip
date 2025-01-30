package kyrie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TodoTest {
    @Test
    public void testToDoConstructor() {
        Todo todo = new Todo("Sample Task");
        assertEquals("Sample Task", todo.getName());
        assertEquals(false, todo.isDone());
        todo.markAsDone();
        assertEquals(true, todo.isDone());
        todo.unmarkAsDone();
        assertEquals(false, todo.isDone());
    }

    @Test
    public void testToString() {
        Todo todo = new Todo("Sample Task");
        assertEquals("[T][ ] Sample Task", todo.toString());
        todo.markAsDone();
        assertEquals("[T][X] Sample Task", todo.toString());
    }

    @Test
    public void testToFileString() {
        Todo todo = new Todo("Sample Task");
        assertEquals("TODO | 0 | Sample Task", todo.toFileString());
        todo.markAsDone();
        assertEquals("TODO | 1 | Sample Task", todo.toFileString());
    }
}