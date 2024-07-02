public class Processor {
    private final String id;
    private Task currentTask;
    private static int currentId = 1;

    public Processor() {
        this.id = "P" + currentId;
        currentId++;

        currentTask = null;
    }

    public boolean isOccupied() {
        return currentTask != null;
    }

    public String getId() {
        return id;
    }

    public void assignTask(Task task) {
        if (task == null) return;

        task.setBeingServed();
        currentTask = task;
    }

    public String getCurrentTaskId() {
        if (currentTask == null) return null;
        return currentTask.getId();
    }

    public void serve() {
        if (this.currentTask == null) return;

        this.currentTask.getServed();
        if (this.currentTask.isFinished()) {
            currentTask = null;
        }
    }

    @Override
    public String toString() {
        String s = "Processor " + id + "{ currentTask= ";
        if(this.isOccupied()) s += currentTask.toString();
        else s += "Empty";
        s += " }";
        return s;
    }
}
