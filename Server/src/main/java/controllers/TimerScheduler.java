package controllers;

import java.util.Timer;
import java.util.TimerTask;

public class TimerScheduler {
    private Timer timer;

    public TimerScheduler(long seconds) {
        this.timer = new Timer();
        timer.schedule(new TaskForTimer(), seconds * 1000);
    }
}

class TaskForTimer extends TimerTask {

    @Override
    public void run() {
        System.out.println("Hello");
    }
}