public class MyQueue {
    private int[] queue;
    private int length;
    private int size;
    private int head;
    private int tail;

    public MyQueue(int length) {
        this.length = length;
        queue = new int[length];
        tail = -1;
        head = 0;
        size = 0;
    }

    public void insert(int element) {
        if (!this.offer()) {
            throw new IllegalStateException();
        }
        queue[++tail] = element;
        size++;
    }

    public int remove() {
        if (this.isEmpty()) {
            throw new IllegalStateException();
        }
        int element = queue[head++];
        if (head == length) {
            head = 0;
        }
        size--;
        return element;
    }

    public int peek() {
        return queue[head];
    }

    public int getTail() {
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean offer() {
        return size < length;
    }
}
