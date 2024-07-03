import java.util.concurrent.TimeUnit;

public class Clock {
    private static Clock clock;
    private int currentCycle;

    private Clock() {
        currentCycle = 1;
    }

    public static Clock getInstance() {
        if (clock == null) {
            clock = new Clock();
        }
        return clock;
    }

    public String getCurrentCycleId() {
        return "C" + currentCycle;
    }

    public int getCurrentCycle() {
        return currentCycle;
    }

    public void nextCycle() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }

        currentCycle++;
    }
}