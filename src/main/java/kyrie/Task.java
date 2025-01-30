package kyrie;

/**
 * Represents a task.
 */
public class Task {
    protected Boolean isDone;
    protected String name;
    protected TaskType type;

    /**
     * Constructor for Task.
     * @param name The name of the task.
     * @param type The type of the task.
     */
    public Task(String name, TaskType type) {
        this.name = name;
        this.isDone = false;
        this.type = type;
    }

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Unmarks the task as done.
     */
    public void unmarkAsDone() {
        this.isDone = false;
    }

    /**
     * Retrieves the name of the task.
     * @return The name of the task.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Checks if the task is done.
     * @return True if the task is done, false otherwise.
     */
    public Boolean isDone() {
        return this.isDone;
    }

    /**
     * Returns the string representation of the task, suitable for saving to file.
     * @return The string representation of the task, suitable for saving to file.
     */
    public String toFileString() {
        return this.type + " | " + (this.isDone ? "1" : "0") + " | " + this.name;
    }

    /**
     * Returns the string representation of the task.
     * @return The string representation of the task.
     */
    @Override
    public String toString() {
        return this.isDone ? "[X] " + this.name : "[ ] " + this.name;
    }
}