package Model;

import java.util.Objects;

public abstract class Task {
    private String taskId;
    private String description;

    public Task(String taskID, String description) {
        this.taskId = taskID;
        this.description = description;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskID(String taskID) {
        this.taskId = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void execute();

    @Override
    public String toString() {
        return getTaskId() + " " + getDescription();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTaskId(),getDescription());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Task task)) {
            return false;
        }

        return Objects.equals(task.getTaskId(),getTaskId()) &&
                Objects.equals(task.getDescription(),getDescription());
    }

}
