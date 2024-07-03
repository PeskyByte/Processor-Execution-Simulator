public class Task implements Comparable<Task> {

    private final int creationTime;
    private final int priority;
    private final String id;
    private int executionTime;
    private boolean isDone;
    private static int currentId = 1;

    public Task(int creationTime, int executionTime, int priority) {
        this.creationTime = creationTime;
        this.executionTime = executionTime;
        this.priority = priority;
        this.isDone = false;
        this.id = "T" + currentId;
        currentId++;
    }

    public int getCreationTime() {
        return creationTime;
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
        return "Task " + id + " { " +
                "creationTime= " + creationTime +
                ", TimeLeft= " + executionTime +
                ", priority= " + priority +
                " }";
    }

    @Override
    public int compareTo(Task task) {
        if(task == null) throw new IllegalArgumentException();
        if (this.priority > task.priority) return -1;
        if (this.priority < task.priority) return +1;
        if (this.executionTime > task.executionTime) return -1;
        if (this.executionTime < task.executionTime) return +1;
        return 0;
    }
}
