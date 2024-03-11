import java.util.Timer;
import java.util.TimerTask;

public class Time {
    Timer timer = new Timer();
    int time = 0;
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            String timeString = getTime(time);
            time++;
            System.out.println(timeString);
        }
    };

    public void runTime() {
        timer.schedule(timerTask, 0, 1000);
    }

    public void stopTime() {
        timer.cancel();
    }
     public String getTime(int sec) {
        int minutes = 0;
        int seconds = 0;

        if (sec >= 60) {
            minutes = sec / 60;
            seconds = sec % 60;
        } else if (sec < 60) {
            seconds = sec;
        }

        StringBuilder timeBuilder = new StringBuilder();
        if (minutes < 10)
            timeBuilder.append("0");
            timeBuilder.append(minutes).append(":");
        if (seconds < 10)
            timeBuilder.append("0");
            timeBuilder.append(seconds);

        return timeBuilder.toString();
    }
}
