import java.util.*;

public class Scheduler {
    private PriorityQueue<Task> tasks;
    private ArrayList<Processor> idleProcessors;
    private ArrayList<Processor> busyProcessors;

    public Scheduler() {
        tasks = new PriorityQueue<Task>();
        idleProcessors = new ArrayList<Processor>();
        busyProcessors = new ArrayList<Processor>();
    }

    public void addTaskToQueue(Task task) {
        if (task == null) throw new IllegalArgumentException();
        tasks.add(task);
    }

    public void scheduleTask() {
        if (idleProcessors.isEmpty()) return;
        while (!idleProcessors.isEmpty()) {
            Processor tmp = idleProcessors.remove(idleProcessors.size() - 1);
            if (!tasks.isEmpty()) {
                tmp.assignTask(tasks.poll());
            } else {
                idleProcessors.add(tmp);
                break;
            }
            busyProcessors.add(tmp);
        }
    }

    public void addIdleProcessor(Processor processor) {
        if (processor == null) throw new IllegalArgumentException();
        idleProcessors.add(processor);
    }

    public void sweep() {
        for (int i = busyProcessors.size() - 1; i >= 0; i--) {
            if (!busyProcessors.get(i).isOccupied()) {
                idleProcessors.add(busyProcessors.get(i));
                busyProcessors.remove(i);
            }
        }
        for (int i = idleProcessors.size() - 1; i >= 0; i--) {
            if (idleProcessors.get(i).isOccupied()) {
                busyProcessors.add(idleProcessors.get(i));
                idleProcessors.remove(i);
            }
        }
    }
}
