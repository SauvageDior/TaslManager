package model;

import java.sql.Time;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;


/**
 * Alert class
 */

public class Alert implements Runnable /*extends Thread*/ {

    /** thread */
    transient private Thread al;
    /** id */
    private UUID id;
    /** alert time*/
    private Time alertTime;
    /** message */
    private String message;



    /**
     * constructor Alert
     * @param id
     * @param alertTime
     * @param message
     */
    public Alert(UUID id, Time alertTime, String message) {
        this.id = id;
        this.alertTime = alertTime;
        this.message = message;

        al = new Thread(this);
        al.start();
    }

    public Alert(){}

    /**
     * get alert time
     * @return time of alert
     */
    public Time getAlertTime() {
        return alertTime;
    }

    /**
     * set time
     * @param alertTime
     */
    public void setAlertTime(Time alertTime) {
        this.alertTime = alertTime;
    }

    /**
     * set message
     * @param message
     */
    public void setMessage(String message) { this.message = message;}

    /**
     * get message
     * @return сmessage string
     */
    public String getMessage() { return message; }


    /**
     *  threads performance
     */
    public void run(){
        try {
            Thread.sleep(alertTime.getTime() - new Date().getTime());
            //TODO сигнализация о настпление времени таски
            System.out.println("---------------------");
            System.out.println("Task started:" + message);
            System.out.println("---------------------");

            Scanner scan = new Scanner(System.in);

            System.out.println("1) change\n2) done");

            int x = 0;
            String s = "";

            s = scan.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");}

            if (x==1) {
                System.out.println("enter new time (10:11): ");
                String timeS = scan.next();
                String[] str = timeS.split(":");

                int hour = Integer.parseInt(str[0]);
                int min = Integer.parseInt(str[1]);

                this.alertTime.setSeconds(0);
                this.alertTime.setHours(hour);
                this.alertTime.setMinutes(min);


            }




        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
