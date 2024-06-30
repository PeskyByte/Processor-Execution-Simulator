import java.util.*;
public class Scheduler {
    private PriorityQueue<Task> highPriorityTasks;
    private PriorityQueue<Task> lowPriorityTasks;
    private Stack<Processor> idleProcessors;

    public Scheduler(){
        highPriorityTasks = new PriorityQueue<Task>();
        lowPriorityTasks = new PriorityQueue<Task>();
        idleProcessors = new Stack<Processor>();
    }

    public void addTaskToQueue(Task task){
        if(task == null) throw new IllegalArgumentException();
        if(task.getPriority() == 1){
            highPriorityTasks.add(task);
        }
        else{
            lowPriorityTasks.add(task);
        }
    }

    public void scheduleTask(){
        if(idleProcessors.isEmpty()) return;

        if(highPriorityTasks.isEmpty()){
            idleProcessors.pop().assignTask(lowPriorityTasks.poll());
        }
        else{
            idleProcessors.pop().assignTask(highPriorityTasks.poll());
        }
    }

    public void addIdleProcessor(Processor processor){
        if(processor == null) throw new IllegalArgumentException();
        idleProcessors.push(processor);
    }

}
