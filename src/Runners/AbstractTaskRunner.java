package Runners;

import Model.Task;
import Utils.Constants;

import java.time.LocalDateTime;

public abstract class AbstractTaskRunner implements TaskRunner{
    protected TaskRunner runner;

    public AbstractTaskRunner(TaskRunner runner) {
        this.runner = runner;
    }

    public abstract void executeOneTask();
    public void executeAll() {
        while (runner.hasTasks()) {
            executeOneTask();
        }
    }

    public void addTask(Task t) {
        runner.addTask(t);
    }

    public boolean hasTasks() {
        return runner.hasTasks();
    }
}
