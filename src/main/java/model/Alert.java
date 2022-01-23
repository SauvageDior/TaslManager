package model;

import java.beans.Transient;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;




public class Alert implements Runnable /*extends Thread*/ {


    transient private Thread al;
    private UUID id;
    private Time alertTime;
    private String message;


    public Alert(UUID id, Time alertTime, String message) {
        this.id = id;
        this.alertTime = alertTime;
        this.message = message;

        al = new Thread(this);
        al.start();
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
            System.out.println("---------------------");
            System.out.println("Task started:" + message);
            System.out.println("---------------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
