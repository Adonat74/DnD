package util;

import java.util.concurrent.TimeUnit;

public class Pause {
    public static void pause(int timeInMS) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(timeInMS);
    }
}
