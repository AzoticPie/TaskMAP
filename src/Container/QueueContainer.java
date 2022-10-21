package Container;

import Model.Task;

public class QueueContainer extends ContainerSuperclass implements Container{
    private int first;
    private int last;

    public QueueContainer() {
        super();
        first = 0;
        last = 0;
    }
    public Task remove() {
        if (!isEmpty()) {
            Task temp = tasks[this.first];
            if(++this.first == this.tasks.length){
                this.first = 0;
            }
            size--;
            return temp;
        }
        return null;
    }
    public void add(Task task) {
        if(last == first && !isEmpty()){
            //no more capacity
            this.last = this.tasks.length;
            Task[] t = new Task[tasks.length * 2];
            System.arraycopy(this.tasks,first,t,0, this.tasks.length - first);
            System.arraycopy(this.tasks,this.tasks.length + first,t,this.tasks.length - first, first);
            this.tasks = t;
            this.first = 0;
        }

        this.tasks[this.last] = task;
        this.size++;

        if(++this.last == this.tasks.length){
            this.last = 0;
        }
    }
}
