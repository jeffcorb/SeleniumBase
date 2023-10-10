package utilities;

public class AutomationUtilities {
    public static void automationSleep(long milliMs) {
        try {
            Thread.sleep(milliMs);
        } catch (InterruptedException interruptedException) {
            Logs.error("Error: %s", interruptedException.getLocalizedMessage());
        }
    }
}
