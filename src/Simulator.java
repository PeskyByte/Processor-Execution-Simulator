import java.io.IOException;
import java.util.ArrayList;

public class Simulator {
    private Clock clock;
    private ArrayList<Processor> processors;
    private ArrayList<Task> tasks;
    private int simulationTime;
    private Scheduler scheduler;

    public Simulator(int numberOfProcessors, int simulationTime, String filePath) throws IOException {
        this.simulationTime = simulationTime;
        clock = Clock.getInstance();
        tasks = new ArrayList<Task>();
        scheduler = new Scheduler();
        initializeProcessors(numberOfProcessors);
        tasks = InputReader.loadTasksFromFile(filePath);
    }

    private void initializeProcessors(int numberOfProcessors) {
        processors = new ArrayList<Processor>();
        for (int i = 0; i < numberOfProcessors; i++) {
            Processor processor = new Processor();
            processors.add(processor);
            scheduler.addIdleProcessor(processor);
        }
    }

    public void simulate() {
        int currentTask = 0;
        while (simulationTime > 0) {
            System.out.println("==================================================");
            System.out.println("----> " + clock.getCurrentCycleId() + '\n');

            while (currentTask < tasks.size() && tasks.get(currentTask).getCreationTime() <= clock.getCurrentCycle()) {
                scheduler.addTaskToQueue(tasks.get(currentTask));
                currentTask++;
            }

            scheduler.sweep();
            scheduler.scheduleTask();

            for (Processor processor : processors) {
                System.out.println(processor.toString() + '\n');
            }

            for (Processor processor : processors) {
                processor.serve();
            }

            System.out.println("==================================================");
            clock.nextCycle();
            simulationTime--;
        }
    }
}