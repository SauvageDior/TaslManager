package model;

import java.sql.Time;
import java.util.Date;
import java.util.UUID;

public class Alert implements Runnable {

    private UUID id;
    private Time alertTime;
    private String message;
    //private UUID taskId; // хранение задания

    public Alert(UUID id, Time alertTime, String message) {
        this.id = id;
        this.alertTime = alertTime;
        this.message = message;
        //this.taskId = taskId;
        //start();
    }

    public Alert(){}

    public Time getAlertTime() {
        return alertTime;
    }

    public void setAlertTime(Time alertTime) {
        this.alertTime = alertTime;
    }

    public void setMessage(String message) { this.message = message;}

    public String getMessage() { return message; }




    public void run(){
        try {
            Thread.sleep(alertTime.getTime() - new Date().getTime());
            //TODO сигнализация о настпление времени таски
            System.out.println("Task started:" + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
