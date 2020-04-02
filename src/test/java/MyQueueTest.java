import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
    private MyQueue queue;
    private int length;
    private int element;

    @Before
    public void setUp() throws Exception {
        length = 11;
        element = 1;
        queue = new MyQueue(length);
        queue.insert(element);
    }

    @Test
    public void insertValid() {
        Assert.assertEquals(queue.getTail(), element);
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void insertNotValid() {
        queue.remove();
        Assert.assertFalse(queue.getTail() != element);
        Assert.assertTrue(queue.isEmpty());
    }

    @Test(expected = IllegalStateException.class)
    public void removeValid() {
        Assert.assertEquals(queue.remove(), element);
        queue.remove();
    }

    @Test
    public void peekValid() {
        Assert.assertEquals(queue.peek(), element);
    }

    @Test
    public void peekNotValid() {
        Assert.assertFalse(queue.peek() != element);
    }

    @Test
    public void getTailValid() {
        int last = 2;
        queue.insert(last);
        Assert.assertEquals(queue.getTail(), last);
    }

    @Test
    public void getTailNotValid() {
        int last = 2;
        queue.insert(last);
        Assert.assertFalse(queue.getTail() != last);
    }

    @Test
    public void isEmptyValid() {
        queue.remove();
        Assert.assertTrue(queue.isEmpty());
    }

    @Test
    public void isEmptyNotValid() {
        Assert.assertFalse(queue.isEmpty());
    }

    @Test
    public void offer() {
        int size = 1;
        while (size < length - 1) {
            queue.insert(element);
            size++;
        }
        Assert.assertTrue(queue.offer());
    }
}