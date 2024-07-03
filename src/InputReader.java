import java.io.*;
import java.util.ArrayList;

public class InputReader {
    public static ArrayList<Task> loadTasksFromFile(String filePath) throws IOException {

        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        ArrayList<Task> tasks = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Try with resource statements automatically close the opened resources, cool :)
            int numberOfTasks = Integer.parseInt(reader.readLine());
            for (int i = 0; i < numberOfTasks; i++) {
                String[] tokens = reader.readLine().split(" ", 3);
                tasks.add(new Task(Integer.parseInt(tokens[0]),
                        Integer.parseInt(tokens[1]),
                        Integer.parseInt(tokens[2])));
            }
        }
        return tasks;
    }
}
