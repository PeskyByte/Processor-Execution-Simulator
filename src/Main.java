import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.out.println("Wrong number of arguments.");
            return;
        }
        int numberOfProcessors = 0;
        int simulationTime = 0;
        String filePath = "";
        try {
            numberOfProcessors = Integer.parseInt(args[0]);
            simulationTime = Integer.parseInt(args[1]);
            filePath = args[2];
            File file = new File(filePath);
            if (!file.exists()) {
                System.out.println("Wrong path, file does not exist.");
                return;
            }
        } catch (Error e) {
            System.out.println("Bad input.");
            return;
        }

        Simulator sim = new Simulator(numberOfProcessors, simulationTime, filePath);
        sim.simulate();

        /*
         * when the current clock cycle is equal to the arrival time of the task in the List, you add it to the queues
         * in the scheduler.
         *
         * you need to wait until the task list is empty and the queues are empty and all processors are idle to know
         * that you are done with all tasks
         *
         * separate tasks into priority arrays, sort by smaller arrival time, if equal sort by bigger exec time
         * */
    }
}