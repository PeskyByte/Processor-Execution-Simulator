public class Task implements Comparable<Task> {

    private final int creationTime;
    private final int priority;
    private final String id;
    private int executionTime;
    private boolean beingServed;
    private boolean isDone;
    private static int currentId = 1;

    public Task(int creationTime, int executionTime, int priority) {
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
        this.beingServed = false;
        this.isDone = false;
        this.id = "T" + currentId;
        currentId++;
    }

    public int getCreationTime() {
        return creationTime;
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public int getPriority() {
        return priority;
    }

    public String getId() {
        return id;
    }

    public void setBeingServed() {
        beingServed = true;
    }

    public boolean isBeingServed() {
        return beingServed;
    }

    public boolean isFinished() {
        return isDone;
    }

    public void getServed() {
        executionTime--;
        if (executionTime == 0) isDone = true;
    }

    @Override
    public String toString() {
        return "Task " + id + " {" +
                "creationTime= " + creationTime +
                ", executionTime= " + executionTime +
                ", priority= " + priority +
                '}';
    }

    @Override
    public int compareTo(Task task) {
        if (this.executionTime > task.executionTime) return -1;
        if (this.executionTime < task.executionTime) return +1;
        return 0;
    }
}
