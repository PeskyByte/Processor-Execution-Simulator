import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {
    private Clock clock = Clock.getInstance();
    private ArrayList<Processor> processors = new ArrayList<Processor>();
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private int simulationTime;
    private Scheduler scheduler = new Scheduler();

    public Simulator(int numberOfProcessors, int simulationTime, String filePath) throws IOException {
        this.simulationTime = simulationTime;
        for (int i = 0; i < numberOfProcessors; i++) {
            Processor processor = new Processor();
            processors.add(processor);
            scheduler.addIdleProcessor(processor);
        }

        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int numberOfTasks = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfTasks; i++) {
            String[] tokens = reader.readLine().split(" ", 3);
            tasks.add(new Task(Integer.parseInt(tokens[0]),
                    Integer.parseInt(tokens[1]),
                    Integer.parseInt(tokens[2])));
        }
        reader.close();
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