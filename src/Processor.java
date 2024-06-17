public class Processor {
    private final String id;
    private Task currentTask = null;
    private static int currentId = 1;

    public Processor() {
        this.id = "P" + currentId;
        currentId++;
    }

    public boolean isOccupied(){
        return currentTask != null;
    }

    public String getId() {
        return id;
    }

    public String getCurrentTaskId() {
        return currentTask.getId();
    }

    public void serve(){
        if(this.currentTask == null) return;

        this.currentTask.getServed();
        if(this.currentTask.isFinished()){
            currentTask = null;
        }
    }

    @Override
    public String toString() {
        return "Processor id= " + id + " {" +
                ", currentTask= " + getCurrentTaskId() +
                '}';
    }
}
