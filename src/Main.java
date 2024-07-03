import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        if (args.length != 3) {
            System.out.println("Wrong number of arguments. <Number of processors> <Simulation time> <Input file path>");
            return;
        }
        int numberOfProcessors = 0;
        int simulationTime = 0;
        String filePath = "";
        try {
            numberOfProcessors = Integer.parseInt(args[0]);
            simulationTime = Integer.parseInt(args[1]);
            filePath = args[2];
        } catch (Error e) {
            System.out.println("Bad input. <Number of processors> <Simulation time> <Input file path>");
            return;
        }

        Simulator sim = new Simulator(numberOfProcessors, simulationTime, filePath);
        sim.simulate();
    }
}