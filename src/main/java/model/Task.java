package model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jdk.jfr.Name;
import org.w3c.dom.Attr;

import javax.xml.bind.Element;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Time;
import java.util.UUID;


/**
 * class Task
 * @see Alert
 */
public class Task implements Serializable {

    /** task description*/
    private String description;
    /**  name */
    private String name;
    private UUID userId;
    /** id of task*/
    private UUID id;
    /** Alert */
    private Alert alert;

    /**
     * constructor
     * @param description
     * @param name
     * @param userId
     * @param id
     * @param time
     */
    public Task(String description, String name, UUID userId, UUID id, Time time){
        this.description = description;
        this.name = name;
        this.userId = userId;
        this.id = id;
        this.alert = new Alert(UUID.randomUUID(), time, "Not entered");
    }

    /**
     * constructor with Alert as a param
     * @param name
     * @param description
     * @param userId
     * @param id
     * @param alert
     */
    public Task(String name, String description, UUID userId, UUID id, Alert alert){
        this.description = description;
        this.name = name;
        this.userId = userId;
        this.id = id;
        this.alert = alert;
    }

    public Task(){}


    /**
     * set time
     * @param time
     */
    public void setAlertTime(Time time){
        alert.setAlertTime(time);
    }

    /**
     * set message
     * @param message
     */
    public void setMessage(String message) {this.alert.setMessage(message);}

    /**
     * get alert
     * @return alert
     */
    public Alert getAlert() { return alert; }

    /**
     * get description
     * @return description
     */
    public String getDescription(){ return description; }

    /**
     * set description
     * @param description
     */
    public void setDescription(String description){ this.description = description; }

    /**
     * get name
     * @return name
     */
    public String getName(){ return name; }

    /**
     * set name
     * @param name
     */
    public void setName(String name){ this.name = name; }

    /**
     * get id
     * @return id
     */
    public UUID getId(){ return id; }

    /**
     * set id
     * @param id
     */
    public void setId(UUID id){ this.id = id; }


    public void setUserId(UUID userId){ this.userId = userId; }

    public UUID getUserId(){ return userId; }

    /**
     * printing task
     * @return string
     */
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("id: " + id + " Name: " + name + " Description: " + description );
        return sb.toString();
    }

}
