package Container;

import Model.Task;

public class StackContainer extends ContainerSuperclass implements Container {
    public StackContainer() {
        super();
    }
    public Task remove() {
        if (!isEmpty()) {
            --size;
            return tasks[size];
        }
        return null;
    }

    public void add(Task task) {
        if (tasks.length == size) {
            Task[] t = new Task[tasks.length * 2];
            System.arraycopy(tasks,0,t,0,tasks.length);
            tasks = t;
        }
        tasks[size] = task;
        ++size;
    }
}
