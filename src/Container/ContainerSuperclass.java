package Container;

import Model.Task;
import Utils.Constants;

public class ContainerSuperclass {
    protected Task[] tasks;
    protected int size;

    public ContainerSuperclass() {
        tasks = new Task[Constants.INITIAL_TASK_SIZE];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
